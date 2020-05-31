DESCRIPTION = "Openvision Opkg Settings for dm800se"
SUMMARY = "Openvision Opkg Settings for dm800se"
SECTION = "base"
LICENSE = "CLOSED"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

SRC_URI += " \
	file://all-feed.conf \
	file://dm800se-feed.conf \
	file://mips32el-feed.conf"

FILES_${PN} = "/etc/opkg"

do_install() {
	install -d ${D}/etc/opkg
	install -m 0644 ${S}/all-feed.conf ${D}/etc/opkg/all-feed.conf
	install -m 0644 ${S}/dm800se-feed.conf ${D}/etc/opkg/dm800se-feed.conf
	install -m 0644 ${S}/mips32el-feed.conf ${D}/etc/opkg/mips32el-feed.conf
}
