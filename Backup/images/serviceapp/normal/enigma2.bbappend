FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RRECOMMENDS_${PN}_remove = "enigma2-plugin-skins-pli-hd"

RRECOMMENDS_${PN}_append += " \
	enigma2-plugin-skins-pli-fullnighthd \
"

PKGV_enigma2-fonts = "2018.12.09"

SRC_URI = "git://github.com/jack2015/enigma2-openpli.git;branch=develop"
SRC_URI_dm800 = "git://github.com/jack2015/enigma2-openpli.git;branch=develop"
SRC_URI_dm800se = "git://github.com/jack2015/enigma2-openpli.git;branch=dm800se"

PYTHON_RDEPS += " \
	python-service-identity \
"

SRC_URI_append_dm800 += " \
	file://e2_old_dvbapi.patch \
"

do_install_append() {
	find ${D}/usr/share/enigma2/rc_models/ -name '*.png' -exec rm {} \;
	find ${D}/usr/share/enigma2/rc_models/ -name '*.xml' -exec rm {} \;
	install -m 0644 ${S}/data/rc_models/dmm.png ${D}/usr/share/enigma2/rc_models/dmm.png
	install -m 0644 ${S}/data/rc_models/dmmadv.png ${D}/usr/share/enigma2/rc_models/dmmadv.png
	install -m 0644 ${S}/data/rc_models/dmm.xml ${D}/usr/share/enigma2/rc_models/dmm.xml
	install -m 0644 ${S}/data/rc_models/dmmadv.xml ${D}/usr/share/enigma2/rc_models/dmmadv.xml
}

python populate_packages_prepend() {
    enigma2_podir = bb.data.expand('${datadir}/enigma2/po', d)
    do_split_packages(d, enigma2_podir, '^(\w+)/[a-zA-Z0-9_/]+.*$', 'enigma2-plugin-language-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
}

SUMMARY_enigma2-plugin-language-en = "British English"
SUMMARY_enigma2-plugin-language-ru = "Russian"
SUMMARY_enigma2-plugin-language-ar = "Arabic"
SUMMARY_enigma2-plugin-language-de = "German"
SUMMARY_enigma2-plugin-language-es = "Spanish"
SUMMARY_enigma2-plugin-language-it = "Italian"
SUMMARY_enigma2-plugin-language-tr = "Turkish"
SUMMARY_enigma2-plugin-language-bg = "Bulgarian"
SUMMARY_enigma2-plugin-language-ca = "Catalan"
SUMMARY_enigma2-plugin-language-cs = "Czech"
SUMMARY_enigma2-plugin-language-da = "Danish"
SUMMARY_enigma2-plugin-language-el = "Greek"
SUMMARY_enigma2-plugin-language-et = "Estonian"
SUMMARY_enigma2-plugin-language-fa = "Persian"
SUMMARY_enigma2-plugin-language-fi = "Finnish"
SUMMARY_enigma2-plugin-language-fr = "French"
SUMMARY_enigma2-plugin-language-fy = "Frisian"
SUMMARY_enigma2-plugin-language-he = "Hebrew"
SUMMARY_enigma2-plugin-language-hr = "Croatian"
SUMMARY_enigma2-plugin-language-hu = "Hungarian"
SUMMARY_enigma2-plugin-language-id = "Indonesian"
SUMMARY_enigma2-plugin-language-is = "Icelandic"
SUMMARY_enigma2-plugin-language-ku = "Kurdish"
SUMMARY_enigma2-plugin-language-lt = "Lithuanian"
SUMMARY_enigma2-plugin-language-lv = "Latvian"
SUMMARY_enigma2-plugin-language-nb = "Norwegian Bokm"
SUMMARY_enigma2-plugin-language-nl = "Dutch"
SUMMARY_enigma2-plugin-language-nn = "Norwegian Nynorsk"
SUMMARY_enigma2-plugin-language-pl = "Polish"
SUMMARY_enigma2-plugin-language-pt = "Portuguese-Portugal"
SUMMARY_enigma2-plugin-language-pt-br = "Portuguese-Brazil"
SUMMARY_enigma2-plugin-language-ro = "Romanian"
SUMMARY_enigma2-plugin-language-sk = "Slovak"
SUMMARY_enigma2-plugin-language-sl = "Slovenian"
SUMMARY_enigma2-plugin-language-sr = "Serbian"
SUMMARY_enigma2-plugin-language-sv = "Swedish"
SUMMARY_enigma2-plugin-language-th = "Thailand-Thai"
SUMMARY_enigma2-plugin-language-uk = "Ukrainian"
SUMMARY_enigma2-plugin-language-vi = "Vietnamese"
SUMMARY_enigma2-plugin-language-zh-cn = "Chinese-China"
SUMMARY_enigma2-plugin-language-zh-hk = "Chinese-Hong Kong"

SUMMARY_enigma2-plugin-font-wqy-microhei = "wqy-microhei font supports Chinese EPG"
PACKAGES =+ "enigma2-plugin-font-wqy-microhei"
FILES_enigma2-plugin-font-wqy-microhei = "${datadir}/fonts/wqy-microhei.ttc ${datadir}/fonts/fallback.font"
ALLOW_EMPTY_enigma2-plugin-font-wqy-microhei = "1"
