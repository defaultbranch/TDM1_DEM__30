package ch.patchcode.tdm90

import kotlin.math.abs
import kotlin.math.floor

data class Position(val longitude: Double, val latitude: Double) {

    init {
        require(latitude <= 90 && latitude >= -90) { "please normalize latitude" }
        require(longitude <= 180 && longitude >= -180) { "please normalize longitude" }
    }

    /**
     * GeoTIFF vertical resolution per pixel.
     */
    fun longitudePixelSpacingInArcSec(): Double {
        if (latitude > 85 || latitude < -85) return 30.0
        if (latitude > 80 || latitude < -80) return 15.0
        if (latitude > 70 || latitude < -70) return 9.0
        if (latitude > 60 || latitude < -60) return 6.0
        if (latitude > 50 || latitude < -50) return 4.5
        return 3.0
    }

    /**
     * GeoTIFF vertical coverage in degrees.
     *
     * Most files cover 1° in longitude and latitude. Approaching poles,
     * the lateral coverage doubles to 2° or quadruples to 4°.
     */
    fun longitudeFileCoverageInDeg(): Int {
        if (latitude > 80 || latitude < -80) return 4
        if (latitude > 60 || latitude < -60) return 2
        return 1
    }

    /**
     * Base for any related TDM90 data tiles, as nominally defined by DLR.
     *
     * Some conventions apply:
     * - round to the equator
     * - round to the east
     */
    fun tileName(): String {
        // the variable names match the product PDF
        val b = "N"
        val x = if (longitude >= 0 && longitude < 180) "E" else "W"
        val bb = "%02.0f".format(floor(abs(latitude)))
        val xxx = "%03.0f".format(abs(floor(longitude)))
        return "TDM1_DEM__30_$b$bb$x$xxx"
    }
}
