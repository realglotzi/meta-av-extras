SUMMARY = "VDR HD output device for Raspberry Pi"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"
COMPATIBLE_MACHINE = "raspberrypi"

SRCREV = "df5aeaf1c13fd8afa47fd3f023089444820b6d8e"
SRC_URI = "git://projects.vdr-developer.org/vdr-plugin-rpihddevice.git"

PR="r2"

SRC_URI += " \
	file://rpihddevice-opt-vc.diff \
"

S = "${WORKDIR}/git"

ASNEEDED = ""

DEPENDS = " \
	vdr \
	ffmpeg \
	freetype \
	virtual/libgl \
	virtual/libgles2 \
	virtual/egl \
"

EXTRA_OEMAKE = ' \
	SDKSTAGE="${STAGING_DIR_HOST}" \
'

do_install() {
	oe_runmake DESTDIR=${D} install
}

FILES_${PN} += " \
	${libdir}/vdr/* \
"

FILES_${PN}-dbg += " \
	${libdir}/vdr/.debug/* \
"
FILES_${PN}-locale = "${datadir}/locale"

