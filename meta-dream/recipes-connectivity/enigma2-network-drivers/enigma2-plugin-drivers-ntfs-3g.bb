SUMMARY = "Allow writes to NTFS file systems"
inherit allarch
require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "ntfs-3g"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
