require dreambox-secondstage.inc

COMPATIBLE_MACHINE = "dm800"

SRC_URI[md5sum] = "365df746869b1bd3738c705068c6d16c"
SRC_URI[sha256sum] = "5cddff85d70918805554f72049b105c8d64988ec79815119b5d962f52c17cb32"

RDEPENDS_${PN} = ""

pkg_postinst_${PN}() {
	echo "Due to space limitations, this is now a dummy package!"
	echo "Nothing will happen when you try to update or reinstall it!"
	echo "The secondstage bootloader will remain the same!"
}
