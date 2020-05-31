require conf/license/openpli-gplv2.inc
#dm800(se)-only
inherit image

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
	nfs-utils \
	nfs-utils-client \
	openpli-bootlogo \
	openssh-sftp \
	openssh-sftp-server \
	opkg \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	python-ipaddress  \
	python-netifaces \
	python-pysmb \
	sdparm \
	tuxbox-common \
	tzdata \
	volatile-media \
	vsftpd \
	bitratecalc \
	ffmpeg \
	exteplayer3 \
	wget \
	softcam-support \
	"

export IMAGE_BASENAME = "openpli"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.

rmpy() {
	rm -f $1/*.py
	rm -f $1/*.pyc
	for file2 in `ls -A $1`
	do
		if [ -d "$1/$file2" ];then
			if [ $file2 != "OpenMultiboot" ];then
				rmpy "$1/$file2"
			fi
		fi
	done
}

rmpo() {
	for file2 in `ls -A $1`
	do
		if [ $file2 = "en" ]; then
			echo "do nothing"
		elif [ $file2 = "ru" ]; then
			echo "do nothing"
		elif [ $file2 = "it" ]; then
			echo "do nothing"
		else
			rm -rf $1/$file2
		fi
	done
}

upxall() {
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/bsdcat || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/blindscan || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/dbus-daemon || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/exteplayer3 || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/enigma2 || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/exteplayer3 || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/ffmpeg || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/ffprobe || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/ntfs-3g || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/ofgwrite_bin || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/openssl || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/sdparm || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/vpxdec || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/vpxenc || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/bin/wget.wget || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/alsactl || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/avahi-daemon || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/dropbearmulti || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/ethtool || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/exportfs || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/groupadd || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/groupdel || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/groupmod || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/newusers || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/parted || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/rpc.mountd || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/rpc.statd || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/useradd || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/usermod || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/vsftpd || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/wpa_cli || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/usr/sbin/wpa_supplicant || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/sbin/e2label || true
	upx --best --ultra-brute ${IMAGE_ROOTFS}/sbin/ldconfig || true
}

export PATH_CN_dm800se = "${THISDIR}/files/only"
export PATH_CN_dm800 = "${THISDIR}/files/dm800/only"

addextra() {
	cp -rf ${PATH_CN}/usr ${IMAGE_ROOTFS}/
       	cp -rf ${PATH_CN}/etc ${IMAGE_ROOTFS}/
}

rootfs_removeopkgleftovers() {
	rm -rf ${IMAGE_ROOTFS}/var/lib/opkg/lists
	rm -rf ${IMAGE_ROOTFS}/usr/lib/python2.7/site-packages/*egg-info*
	rmpy ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins
	rmpy ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Components
	upxall
	rm -rf ${IMAGE_ROOTFS}/usr/share/locale/*
	rm -rf ${IMAGE_ROOTFS}/usr/share/ffmpeg/examples/*
	rm -rf ${IMAGE_ROOTFS}/usr/lib/locale/en_GB
	rm -rf ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-FullHD
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/AudioSync/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/AutoBackup/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/BackupSuite/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/CacheFlush/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/MovieCut/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/Extensions/OscamStatus/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/SystemPlugins/NetworkBrowser/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale
	rmpo ${IMAGE_ROOTFS}/usr/lib/enigma2/python/Plugins/SystemPlugins/SystemTime/locale
	addextra
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-HD/picon_default.png || true
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-FullHD/picon_default.png || true
	rm -f ${IMAGE_ROOTFS}/usr/share/enigma2/PLi-FullNightHD/picon_default.png || true
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
