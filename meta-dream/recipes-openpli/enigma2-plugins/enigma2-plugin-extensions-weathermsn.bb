SUMMARY = "Weather MSN - Weather forecast for five days"
DESCRIPTION = "Weather forecast for 5 days"
MAINTAINER = "Sirius"
HOMEPAGE = "www.gisclub.tv"
require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"

SRC_URI = "git://github.com/jack2015/enigma2-plugins-weathermsn.git;protocol=https"
#SRCREV = "ab75d3dd2ac6c26d91b52b237d3b5b55a360d93b"
SRCREV = "${AUTOREV}"
FILES_${PN} = "${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
    python -O -m compileall ${S}
}

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions
    cp -r --preserve=mode,links ${S}/python/Plugins/Extensions/WeatherMSN ${D}${libdir}/enigma2/python/Plugins/Extensions/
    chmod -R a+rX ${D}${libdir}/enigma2/
    find ${D}/ -name '*.pyc' -exec rm {} \;
    find ${D}/ -name '*.po' -exec rm {} \;
}

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	"
