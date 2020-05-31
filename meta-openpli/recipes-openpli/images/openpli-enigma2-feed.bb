# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# Trick: We want to create the package index, and we don't actually
# package anything, so we "inherit" the package indexer recipe.
require recipes-core/meta/package-index.bb

# We have a GPLv2 license for this recipe...
require conf/license/openpli-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openpli-enigma2-image"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""

OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""
OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""

# Out-of-tree wifi drivers, build conditionally based on kernel version
OPTIONAL_WIFI_PACKAGES = ""

OPTIONAL_PACKAGES += " \
	astra-sm \
	autofs \
	ccid \
	exfat-utils \
	exteplayer3 \
	gstplayer \
	inadyn-mt \
	mc \
	ntfs-3g \
	openssh \
	${@bb.utils.contains("MACHINE", "dm800", "", "openvpn", d)} \
	${@bb.utils.contains("MACHINE", "dm800", "", "openmultiboot", d)} \
	unzip \
	zip \
	"

OPTIONAL_ENIGMA2_PACKAGES = " \
	channelsettings-enigma2-meta \
	network-usb-drivers-meta \
	libcrypto-compat \
	dvb-usb-drivers-meta \
	softcams-enigma2-meta \
	enigma2-pliplugins \
	enigma2-plugins \
	packagegroup-openplugins \
	enigma2-plugin-extensions-automatic-fullbackup \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-keyadder \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-extensions-weatherplugin \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-blurayplayer \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-filecommander \
	enigma2-plugin-extensions-fontinfo \
	enigma2-plugin-extensions-flashexpander \
	${@bb.utils.contains("MACHINE", "dm800", "", "enigma2-plugin-extensions-e2iplayer", d)} \
	${@bb.utils.contains("MACHINE", "dm800", "", "enigma2-plugin-extensions-e2iplayer-deps", d)} \
	enigma2-plugin-extensions-youtube \
	${@bb.utils.contains("MACHINE", "dm800", "", "enigma2-plugin-extensions-openmultiboot", d)} \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-softcams-oscam-dm800se \
	enigma2-plugin-extensions-modifyplifullhd \
	enigma2-plugin-extensions-refreshbouquet \
	enigma2-plugin-extensions-managerautofs \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-joynescan \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-systemplugins-servicemp3 \
	enigma2-plugin-systemplugins-exteplayer3 \
	enigma2-plugin-systemplugins-hrtunerproxy \
	enigma2-plugin-systemplugins-quadpip \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-radiotimesxmltvemulator \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-security-firewall \
	enigma2-plugin-systemplugins-bh-skin-support \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd1 \
	enigma2-plugin-skins-pli-hd2 \
	enigma2-plugin-skins-pli-fullnighthd \
	enigma2-plugin-skins-pli-fullhd \
	enigma2-plugin-skins-mx-hq7 \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-skins-mx-hq10 \
	enigma2-plugin-skins-mx-titaniumc \
	enigma2-plugin-skins-mx-black \
	enigma2-plugin-skins-simple-gray-hd \
	enigma2-plugin-skins-magic \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-systemplugins-satscan \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${OPTIONAL_ENIGMA2_PACKAGES}"
