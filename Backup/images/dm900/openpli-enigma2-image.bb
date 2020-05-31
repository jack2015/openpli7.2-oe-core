require openpli-image.bb
#dm900

KERNEL_WIFI_DRIVERS = ""

EXTERNAL_WIFI_DRIVERS = ""

ENIGMA2_PLUGINS = " \
	enigma2-plugin-language-en \
	enigma2-plugin-language-zh-cn \
	enigma2-plugin-language-ru \
	enigma2-plugin-font-wqy-microhei \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-cacheflush \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-e2iplayer-deps \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-ppanel \
	enigma2-plugin-extensions-youtube \
	${@bb.utils.contains("MACHINE", "dm800", "enigma2-plugin-softcams-oscam-dm800", "", d)} \
	${@bb.utils.contains("MACHINE", "dm800se", "dm800se-branding enigma2-plugin-softcams-oscam-dm800se", "", d)} \
	${@bb.utils.contains("MACHINE", "dm900", "dm900-branding enigma2-plugin-softcams-oscam-dm900", "", d)} \
	${@bb.utils.contains("MACHINE", "dm920", "dm920-branding enigma2-plugin-softcams-oscam-dm920", "", d)} \
	\
	${@bb.utils.contains('MACHINE_FEATURES', 'ci', 'enigma2-plugin-systemplugins-commoninterfaceassignment', '', d)} \
	enigma2-plugin-systemplugins-cablescan \
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-mphelp \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-osdpositionsetup \
	enigma2-plugin-systemplugins-osd3dsetup \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-systemtime \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-systemplugins-wirelesslan \
	"

DEPENDS += " \
	enigma2 \
	enigma2-pliplugins \
	enigma2-plugins \
	"

IMAGE_INSTALL += " \
	aio-grab \
	curl \
	enigma2 \
	libavahi-client \
	libcrypto-compat \
	settings-autorestore \
	tuxbox-common \
	${ENIGMA2_PLUGINS} \
	${KERNEL_WIFI_DRIVERS} \
	${EXTERNAL_WIFI_DRIVERS} \
	${@bb.utils.contains("MACHINE", "dm800", "enigma2-plugin-opkg-dm800", "", d)} \
	${@bb.utils.contains("MACHINE", "dm800se", "enigma2-plugin-opkg-dm800se", "", d)} \
	${@bb.utils.contains("MACHINE", "dm900", "enigma2-plugin-opkg-dm900", "", d)} \
	${@bb.utils.contains("MACHINE", "dm920", "enigma2-plugin-opkg-dm920", "", d)} \
	"

export IMAGE_BASENAME = "openpli-enigma2"
