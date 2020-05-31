DESCRIPTION = "Openvision Opkg Settings for dm900"
SUMMARY = "Openvision Opkg Settings for dm900"
SECTION = "base"
LICENSE = "CLOSED"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"
PACKAGES = "${PN}"

SRC_URI += " \
	file://all-feed.conf \
	file://3rd-party-armv7ahf-neon-feed.conf \
	file://3rd-party-dm900-feed.conf \
	file://3rd-party-feed.conf \
	file://arch.conf \
	file://armv7ahf-neon-feed.conf \
	file://dm900-feed.conf \
"

FILES_${PN} = "/etc/opkg"

do_install() {
	install -d ${D}/etc/opkg
	cp -f ${S}/*.conf ${D}/etc/opkg/
}
