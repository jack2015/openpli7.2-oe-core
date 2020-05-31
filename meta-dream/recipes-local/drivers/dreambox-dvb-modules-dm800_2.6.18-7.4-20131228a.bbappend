SRC_URI[modules.md5sum] = "fa38739737f9024119540ad068759e1a"
SRC_URI[modules.sha256sum] = "b469e19b6b027d6ae032074d8f0ea12721606c3cb54ba1139c755ee61245d6ca"
SRC_URI_dm800 = "https://jack2015.github.io/files/dreambox-dvb-modules-dm800-2.6.18-7.4-dm800-20131228a.zip;name=modules \
       file://modules \
"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN}_append = " already-stripped"

