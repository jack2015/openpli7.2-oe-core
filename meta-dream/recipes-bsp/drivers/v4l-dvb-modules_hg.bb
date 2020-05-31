SUMMARY = "V4L dvb modules for Dreambox"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRCDATE = "20100904"
KV = "2.6.18-7.4-${MACHINE}"
PV = "${KV}+${SRCDATE}"

FILESEXTRAPATHS_prepend := "${THISDIR}/v4l-dvb-modules:"

SRC_URI = "file://v4l-dvb-modules_2.6.18-7.4-dm800-20100904.zip"

S = "${WORKDIR}/"

require v4l-dvb-modules.inc
