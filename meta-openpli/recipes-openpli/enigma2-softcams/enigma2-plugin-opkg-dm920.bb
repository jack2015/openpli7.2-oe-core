DESCRIPTION = "Openvision Opkg Settings for dm920"
SUMMARY = "Openvision Opkg Settings for dm920"
SECTION = "base"
LICENSE = "CLOSED"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"
PACKAGES = "${PN}"

SRC_URI += " \
	file://all-feed.conf \
	file://armv7ahf-neon-feed.conf \
	file://cortexa15hf-neon-vfpv4-feed.conf \
"

FILES_${PN} = "/etc/opkg"

do_install() {
	install -d ${D}/etc/opkg
	install -m 0644 ${S}/all-feed.conf ${D}/etc/opkg/all-feed.conf
	install -m 0644 ${S}/armv7ahf-neon-feed.conf ${D}/etc/opkg/armv7ahf-neon-feed.conf
	install -m 0644 ${S}/cortexa15hf-neon-vfpv4-feed.conf ${D}/etc/opkg/cortexa15hf-neon-vfpv4-feed.conf
}
