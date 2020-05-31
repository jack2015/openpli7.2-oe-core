BCMNUMBER = "bcm7439"
SRC_URI[dm900.md5sum] = "5136e1c8c29ce53885ab40fd4f07aa8c"
SRC_URI[dm900.sha256sum] = "0b8af55570b382444330c1818722a92af6be372f5b25928ab9c45562d0a3f883"
DREAMBOX_DVB_MODULES_MIRROR_dm900 = "http://github.com/jack2015/basefile/raw/master"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN}_append = " already-stripped"

