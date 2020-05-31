FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_dm800 += " \
    file://06-Revert-disable-all-ipcpipeline-tests.patch \
"

SRC_URI_append += " \
    file://dvbapi5-fix-old-kernel.patch \
"
