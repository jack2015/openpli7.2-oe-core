SUMMARY = "Broadcom V3D driver"
LICENSE = "CLOSED"
FILES_${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES_${PN}-dev = "${includedir}"

EXCLUDE_FROM_WORLD = "1"

INSANE_SKIP_${PN} = "dev-so"
