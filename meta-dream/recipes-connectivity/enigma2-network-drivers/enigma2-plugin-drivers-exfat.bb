SUMMARY = "Add support for exfat filesystem"
inherit allarch
require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "fuse-exfat"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
