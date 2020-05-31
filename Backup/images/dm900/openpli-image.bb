require conf/license/openpli-gplv2.inc
#dm900

inherit image

DEPENDS += " \
	zip-native \
	"

IMAGE_INSTALL = " \
	${ROOTFS_PKGMANAGE} \
	avahi-daemon \
	ca-certificates \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fakelocale \
	fuse-exfat \
	glibc-binary-localedata-en-gb \
	kernel-params \
	modutils-loadscript \
	ntp \
	ntfs-3g \
	nfs-utils \
	nfs-utils-client \
	openpli-bootlogo \
	openssh-sftp \
	opkg \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	python-ipaddress  \
	python-netifaces \
	python-pysmb \
	sdparm \
	samba \
	tuxbox-common \
	tzdata \
	volatile-media \
	vsftpd \
	bitratecalc \
	"

export IMAGE_BASENAME = "openpli"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.

rmpy() {
	rm -f $1/*.py
	for file2 in `ls -A $1`
	do
		if [ -d "$1/$file2" ];then
			if [ $file2 != "OpenMultiboot" ];then
				rmpy "$1/$file2"
			fi
		fi
	done
}

export PATH_CN = "${THISDIR}/files/dm900"

addcn() {
	cp -rf ${PATH_CN}/usr ${IMAGE_ROOTFS}/
       	cp -rf ${PATH_CN}/etc ${IMAGE_ROOTFS}/
	chmod 0755 ${IMAGE_ROOTFS}/usr/bin/CCcam
}

rootfs_removeopkgleftovers() {
	rm -rf ${IMAGE_ROOTFS}/var/lib/opkg/lists
	rm -rf ${IMAGE_ROOTFS}/usr/lib/python2.7/site-packages/*egg-info*
	rmpy ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins
	rmpy ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Components
	addcn
	mv -f ${IMAGE_ROOTFS}/usr/lib/bitratecalc.so ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Components/Converter/
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-HD/picon_default.png || true
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-FullHD/picon_default.png || true
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-FullNightHD/picon_default.png || true
	rm -f ${IMAGE_ROOTFS}/etc/opkg/arch.conf-opkg || true
}

# Speedup boot by reducing the host key size. The time it takes grows
# exponentially by key size, the default is 2k which takes several
# seconds on most boxes.
rootfs_speedup_dropbearkey() {
	echo 'DROPBEAR_RSAKEY_ARGS="-s 1024"' >> ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}

ssh_allow_empty_password () {
	true
}

license_create_manifest() {
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_removeopkgleftovers; rootfs_speedup_dropbearkey; "
