package ch.patchcode.tdm90

data class Position(val longitude: Double, val latitude: Double) {

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
}
