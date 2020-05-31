require linux_3.14.inc

do_configure_prepend() {
        sed -e "/^SUBLEVEL = /d" -i ${S}/Makefile
}

KERNEL_ENABLE_CGROUPS = "1"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_kernel = "kernel"
PKG_kernel-base = "kernel-base"
PKG_kernel-image = "kernel-image"
PKG_kernel-image-zimage = "kernel-image"
RPROVIDES_kernel = "kernel-${LINUX_VERSION}"
RPROVIDES_kernel-base = "kernel-${KERNEL_VERSION}"
RPROVIDES_kernel-image = "kernel-image-${KERNEL_VERSION}"
#RPROVIDES_kernel-image-zimage = "kernel-image"
RDEPENDS_kernel-image = "kernel-devicetree flash-scripts"

pkg_postinst_kernel-image () {
#!/bin/sh
if [ -z "$D" ]; then
    if [ `uname -r | grep 3.14 | grep dm900 | wc -l` == 1 ]; then
        dd if=/boot/zImage-3.14-1.17-dm900 of=/dev/mmcblk0p1
    elif [ `uname -r | grep 3.14 | grep dm920 | wc -l` == 1 ]; then
        dd if=/boot/zImage-3.14-1.17-dm920 of=/dev/mmcblk0p1
    fi
fi
}

