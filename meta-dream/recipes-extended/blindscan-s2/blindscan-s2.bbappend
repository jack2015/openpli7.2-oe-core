FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
SRC_URI = "git://github.com/OpenVisionE2/blindscan-s2.git"
SRC_URI_append_dm800 += " \
	file://dm800_dvb-api3.patch \
"
