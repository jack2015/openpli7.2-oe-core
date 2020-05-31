SRC_URI[md5sum] = "c29f3e32a312eba5ddf43d27ac648e44"
SRC_URI[sha256sum] = "ad0ef6a7b164c793bb40b70deb6429566a058b80d5abe754b40ec766bcc06caf"
SRC_URI_dm800 = "https://jack2015.github.io/files/secondstage-dm800-84.bin"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN}_append = " already-stripped"

