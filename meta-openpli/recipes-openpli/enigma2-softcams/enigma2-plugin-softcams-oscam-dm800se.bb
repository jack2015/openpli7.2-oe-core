require conf/license/openpli-gplv2.inc
require oscam-version.inc
SUMMARY = "Softcam oscam for DM800se"
SECTION = "base"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN}_append = " already-stripped"
RDEPENDS_${PN} += "softcam-support"

S = "${WORKDIR}"

SRC_URI += " \
	file://oscam \
	file://oscam.conf \
	file://softcam.oscam"

CONFFILES = "/etc/tuxbox/config/oscam.conf"

FILES_${PN} = "/usr/bin /etc"

do_install() {
	install -d ${D}/etc/tuxbox/config
	install -m 0644 ${S}/oscam.conf ${D}/etc/tuxbox/config/oscam.conf
	install -d ${D}/usr/bin
	install -m 0755 ${S}/oscam ${D}/usr/bin/oscam
	install -d ${D}/etc/init.d
	install -m 0755 ${S}/softcam.oscam ${D}/etc/init.d/softcam.oscam
	ln -sf "softcam.oscam" "${D}/etc/init.d/softcam"
}

CAMNAME = "oscam"
CAMLINK = "/etc/init.d/softcam"
CAMPATH = "/etc/init.d/softcam.${CAMNAME}"

# If no cam selected yet, install and start this cam (and don't start it on the build host).
pkg_postinst_${PN}_append () {
	if [ ! -e "${CAMLINK}" ] || [ "/etc/init.d/softcam.None" = "`readlink -f ${CAMLINK}`" ] || [ "softcam.None" = "`readlink -f ${CAMLINK}`" ]
	then
		ln -sf "softcam.${CAMNAME}" "${CAMLINK}"
		${CAMPATH} restart
	fi
}

# Stop this cam (if running), and move softlink to None if we're the current cam
pkg_prerm_${PN}_prepend () {
	OLDLINK="`readlink -f ${CAMLINK}`"
	if [ "${OLDLINK}" = "${CAMPATH}" ] || [ "softcam.${CAMNAME}" = "${CAMPATH}" ]
	then
		${CAMPATH} stop
		ln -sf "softcam.None" "${CAMLINK}"
	fi
}
