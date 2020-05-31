SRCREV = "${AUTOREV}"
PV = "10.3+git${SRCPV}"
PKGV = "10.3+git${GITPKGV}"

inherit gitpkgv

SRC_URI = "git://github.com/jack2015/cdparanoia.git"

S = "${WORKDIR}/git"
