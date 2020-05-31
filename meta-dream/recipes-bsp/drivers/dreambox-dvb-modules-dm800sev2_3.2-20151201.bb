SUMMARY = "Hardware drivers for Dreambox"
SECTION = "base"
LICENSE = "CLOSED"
DEPENDS += "virtual/kernel"
PRIORITY = "required"

SRC_URI[modules.md5sum] = "b17d215333da3d43e3f8fd6a69462077"
SRC_URI[modules.sha256sum] = "6bed413c13b53b178cbbcfb91522145443d74a4230bb7be6b8b735351579e3e6"

RDEPENDS_${PN} += "kernel-module-stv0299"

COMPATIBLE_MACHINE = "dm800sev2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DREAMBOX_DVB_MODULES_MIRROR ?= "http://sources.dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-dvb-modules"

SRC_URI = " \
			${DREAMBOX_DVB_MODULES_MIRROR}/dreambox-dvb-modules-${MACHINE}-3.2-${MACHINE}-${DRIVERDATE}.tar.bz2;name=modules \
			file://modules \
"

inherit module-base

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/modules-load.d
	install -m 0644 ${WORKDIR}/modules ${D}${sysconfdir}/modules-load.d/${PN}.conf
	install -d ${D}/lib/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/LICENSE ${D}/lib/modules/${DM_LOCALVERSION}/extra
	install -m 0644 ${WORKDIR}/*.ko ${D}/lib/modules/${DM_LOCALVERSION}/extra
}
PACKAGES = "${PN}"
RDEPENDS_${PN} += "dreambox-secondstage-${MACHINE} kernel-${DM_LOCALVERSION}"
# We don't use KERNEL_VERSION in this recipe, because the
# precompiled modules depend on a specific version.
DM_LOCALVERSION = "${@'-'.join('${PV}'.split('-')[:-1])}-${MACHINE}"
DRIVERDATE = "${@'${PV}'.split('-')[-1]}"
FILESEXTRAPATHS_prepend := "${THISDIR}/dreambox-dvb-modules:"
FILES_${PN} += "${sysconfdir}/modules-load.d/${PN}.conf /lib/modules/${DM_LOCALVERSION}/extra"
