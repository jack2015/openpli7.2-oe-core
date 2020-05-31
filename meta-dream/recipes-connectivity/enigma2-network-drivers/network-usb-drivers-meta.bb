SUMMARY = "meta file for USB Network drivers"
inherit packagegroup

require conf/license/license-gplv2.inc

DEPENDS = "\
    enigma2-plugin-drivers-network-usb-carl9170 \
    enigma2-plugin-drivers-network-usb-rt2500 \
    enigma2-plugin-drivers-network-usb-rt2800 \
    enigma2-plugin-drivers-network-usb-zd1211rw \
    ${@bb.utils.contains("MACHINE", "dm800se", " \
    enigma2-plugin-drivers-network-usb-rtl8814au \
    enigma2-plugin-drivers-network-usb-rt8723bs \
    enigma2-plugin-drivers-network-usb-mt7601u \
    enigma2-plugin-drivers-network-usb-mt7610u \
    enigma2-plugin-drivers-network-usb-rtl8822bu \
    enigma2-plugin-drivers-network-usb-rtl8192eu \
    enigma2-plugin-drivers-network-usb-r8723a \
    enigma2-plugin-drivers-network-usb-r8188eu \
    enigma2-plugin-drivers-network-usb-rtl8821cu \
    ", "", d)} \
    enigma2-plugin-drivers-network-usb-rt73 \
    enigma2-plugin-drivers-network-usb-rt3573 \
    enigma2-plugin-drivers-network-usb-rt5572 \
    enigma2-plugin-drivers-network-usb-r8712u \
    enigma2-plugin-drivers-network-usb-rtl8192cu \
    enigma2-plugin-drivers-network-usb-ath9k-htc \
    enigma2-plugin-drivers-network-usb-rtl8187 \
    enigma2-plugin-drivers-network-usb-rt3070 \
    enigma2-plugin-drivers-exfat \
    enigma2-plugin-drivers-ntfs-3g \
    "
