#!/bin/sh

SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"
cd "${SCRIPTPATH}"

def_path="${SCRIPTPATH}/meta-dream/recipes-bsp/linux"

cp -f $def_path/linux-dreambox-3.2/dm800se/defconfig $def_path/linux-dreambox-3.2/defconfig
cp -f Backup/images/dm800/en/* meta-openpli/recipes-openpli/images
cp -f Backup/images/image-size/64m/* meta-dream/conf/machine/include/
cp -f Backup/images/serviceapp/normal/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
cp -f Backup/images/serviceapp/normal/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
echo "Compiling dm800se english image & feed, please wait ..."

MACHINE=dm800se make feed

