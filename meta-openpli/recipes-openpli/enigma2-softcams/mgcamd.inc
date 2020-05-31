DESCRIPTION = "mgcamd ${PV} softcam"

SRC_URI = " \
	http://downloads.openpli.org/softcams/mgcamd-${PV}.tar.gz;name=softcam \
	"

CAMNAME = "mgcamd${MGCAMVER}"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

CONFFILES = "/usr/keys/mg_cfg /usr/keys/ignore.list /usr/keys/newcamd.list /usr/keys/priority.list /usr/keys/replace.list"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/mgcamd.${TARGET_ARCH} ${D}/usr/bin/${CAMNAME}
	install -d ${D}/usr/keys
	install -m 0644 ${S}/mg_cfg ${D}/usr/keys/mg_cfg
	install -m 0644 ${S}/ignore.list.example ${D}/usr/keys/ignore.list.example
	install -m 0644 ${S}/newcamd.list.example ${D}/usr/keys/newcamd.list.example
	install -m 0644 ${S}/priority.list.example ${D}/usr/keys/priority.list.example
	install -m 0644 ${S}/replace.list.example ${D}/usr/keys/replace.list.example
	touch ${D}/usr/keys/ignore.list
	touch ${D}/usr/keys/newcamd.list
	touch ${D}/usr/keys/priority.list
	touch ${D}/usr/keys/replace.list
}

LICENSE = "CLOSED"

FILES_${PN} += "/usr/bin /etc /usr/keys"

RDEPENDS_${PN} += "softcam-support"
INSANE_SKIP_${PN} += "already-stripped"

CAMLINK = "/etc/init.d/softcam"
CAMPATH = "/etc/init.d/softcam.${CAMNAME}"

CAMSTART ?= "exec start-stop-daemon -S -x /usr/bin/${CAMNAME} > /dev/null 2>&1"
CAMSTOP  ?= "exec start-stop-daemon -K -R 2 -x /usr/bin/${CAMNAME} > /dev/null 2>&1"

# Generate a simplistic standard init script
# (sorry for the sleep 1, but start-stop-daemon -R does not work as advertised)
do_compile_append () {
	if [ ! -f init.${CAMNAME} ]
	then
		cat > init.${CAMNAME} << EOF
#!/bin/sh
case "\$1" in
start)
	ulimit -s 1024
	${CAMSTART}
	;;
stop)
	${CAMSTOP}
	;;
restart|reload)
	\$0 stop
	sleep 1
	\$0 start
	;;
version)
	echo "${PV}"
	;;
info)
	echo "${CAMNAME} ${PV}"
	;;
*)
	echo "Usage: \$0 start|stop|restart"
	exit 1
	;;
esac
exit 0
EOF

	fi
}

# Install routine, should be ok for most cams.
do_install_append () {
	install -d ${D}/etc/init.d
	install -m 755 ${S}/init.${CAMNAME} ${D}/etc/init.d/softcam.${CAMNAME}
}

# If no cam selected yet, install and start this cam (and don't start it on the build host).
pkg_postinst_${PN}_append () {
	if [ ! -e "${CAMLINK}" ] || [ "/etc/init.d/softcam.None" = "`readlink -f ${CAMLINK}`" ] || [ "softcam.None" = "`readlink -f ${CAMLINK}`" ]
	then
		ln -sf "softcam.${CAMNAME}" "${CAMLINK}"
		${CAMPATH} restart
	fi
}

# Stop this cam (if running), and move softlink to None if we're the current cam
pkg_prerm_${PN}_prepend () {
	OLDLINK="`readlink -f ${CAMLINK}`"
	if [ "${OLDLINK}" = "${CAMPATH}" ] || [ "softcam.${CAMNAME}" = "${CAMPATH}" ]
	then
		${CAMPATH} stop
		ln -sf "softcam.None" "${CAMLINK}"
	fi
}

# If no cam selected yet, install and start this cam (and don't start it on the build host).
pkg_postinst_${PN}_append () {
if [ -f /lib/ld-2.28.so ]; then
	ln -s /lib/ld-2.28.so /lib/ld-linux.so.3
elif [ -f /lib/ld-2.26.so ]; then
	ln -s /lib/ld-2.26.so /lib/ld-linux.so.3
elif [ -f /lib/ld-2.25.so ]; then
	ln -s /lib/ld-2.25.so /lib/ld-linux.so.3
fi
}

# Stop this cam (if running), and move softlink to None if we're the current cam
pkg_prerm_${PN}_prepend () {
if [ -L /lib/ld-linux.so.3 ]; then
	rm -f /lib/ld-linux.so.3
fi
}
