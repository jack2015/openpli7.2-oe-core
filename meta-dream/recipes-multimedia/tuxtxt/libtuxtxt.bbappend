FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_dm900 = " \
	file://0001-fix-secfault-w-use-wrong-line_length.patch \
	"

SRC_URI_append_dm920 = " \
	file://0001-fix-secfault-w-use-wrong-line_length.patch \
	"
