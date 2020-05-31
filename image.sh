#!/bin/sh

SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"
cd "${SCRIPTPATH}"

def_path="${SCRIPTPATH}/meta-dream/recipes-bsp/linux"

echo "Please enter: (1)dm800se-only (2)dm800se-big (3)dm800se-cn (4)dm800se-en (5)dm800-only (6)dm800-en (7)dm800-cn (8)dm900 (9)dm920"

read MACHINESPECIFIC

if [ $MACHINESPECIFIC != "dm800-only" -a $MACHINESPECIFIC != "dm800-en" -a $MACHINESPECIFIC != "dm800-cn" -a $MACHINESPECIFIC != "dm800se-cn" -a $MACHINESPECIFIC != "dm800se-big" -a $MACHINESPECIFIC != "dm800se-only" -a $MACHINESPECIFIC != "dm800se-en" -a $MACHINESPECIFIC != "dm900" -a $MACHINESPECIFIC != "dm920" ]
then
	echo -e "${RED}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi

if [ $MACHINESPECIFIC = "dm800-only" ]; then
        cp -f $def_path/linux-dreambox-2.6.18/dm800/defconfig $def_path/linux-dreambox-2.6.18/defconfig
	cp -f Backup/images/dm800/only/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/only/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/onlyserviceapp/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/onlyserviceapp/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800 make image
elif [ $MACHINESPECIFIC = "dm800-cn" ]; then
        cp -f $def_path/linux-dreambox-2.6.18/dm800/defconfig $def_path/linux-dreambox-2.6.18/defconfig
	cp -f Backup/images/dm800/cn/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/64m/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/normal/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/normal/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800 make image
elif [ $MACHINESPECIFIC = "dm800-en" ]; then
        cp -f $def_path/linux-dreambox-2.6.18/dm800/defconfig $def_path/linux-dreambox-2.6.18/defconfig
	cp -f Backup/images/dm800/en/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/64m/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/normal/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/normal/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800 make image
elif [ $MACHINESPECIFIC = "dm800se-only" ]; then
        cp -f $def_path/linux-dreambox-3.2/dm800se/defconfig $def_path/linux-dreambox-3.2/defconfig
	cp -f Backup/images/dm800/only/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/only/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/onlyserviceapp/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/onlyserviceapp/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800se make image
elif [ $MACHINESPECIFIC = "dm800se-big" ]; then
        cp -f $def_path/linux-dreambox-3.2/dm800se/defconfig $def_path/linux-dreambox-3.2/defconfig
	cp -f Backup/images/dm800/big/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/big/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/big/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/big/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800se make image
elif [ $MACHINESPECIFIC = "dm800se-cn" ]; then
        cp -f $def_path/linux-dreambox-3.2/dm800se/defconfig $def_path/linux-dreambox-3.2/defconfig
	cp -f Backup/images/dm800/cn/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/64m/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/normal/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/normal/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800se make image
elif [ $MACHINESPECIFIC = "dm800se-en" ]; then
        cp -f $def_path/linux-dreambox-3.2/dm800se/defconfig $def_path/linux-dreambox-3.2/defconfig
	cp -f Backup/images/dm800/en/* meta-openpli/recipes-openpli/images
	cp -f Backup/images/image-size/64m/* meta-dream/conf/machine/include/
	cp -f Backup/images/serviceapp/normal/enigma2.bbappend meta-dream/recipes-openpli/enigma2/
	cp -f Backup/images/serviceapp/normal/enigma2-plugin-systemplugins-serviceapp.bbappend meta-dream/recipes-openpli/enigma2-plugins/
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm800se make image
elif [ $MACHINESPECIFIC = "dm900" ]; then
        cp -f $def_path/linux-dreambox-3.14/dm900/defconfig $def_path/linux-dreambox-3.14/defconfig
	cp -f Backup/images/dm900/* meta-openpli/recipes-openpli/images
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm900 make image
elif [ $MACHINESPECIFIC = "dm920" ]; then
        cp -f $def_path/linux-dreambox-3.14/dm920/defconfig $def_path/linux-dreambox-3.14/defconfig
	cp -f Backup/images/dm900/* meta-openpli/recipes-openpli/images
	echo "Compiling $MACHINESPECIFIC image, please wait ..."
        MACHINE=dm920 make image
else
	echo "Please enter a correct choice"
fi
