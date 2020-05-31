DESCRIPTION = "Openvision Opkg Settings for dm800"
SUMMARY = "Openvision Opkg Settings for dm800"
SECTION = "base"
LICENSE = "CLOSED"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

SRC_URI += " \
	file://all-feed.conf \
	file://dm800-feed.conf \
	file://mips32el-nf-feed.conf"

FILES_${PN} = "/etc/opkg"

do_install() {
	install -d ${D}/etc/opkg
	install -m 0644 ${S}/all-feed.conf ${D}/etc/opkg/all-feed.conf
	install -m 0644 ${S}/dm800-feed.conf ${D}/etc/opkg/dm800-feed.conf
	install -m 0644 ${S}/mips32el-nf-feed.conf ${D}/etc/opkg/mips32el-nf-feed.conf
}
