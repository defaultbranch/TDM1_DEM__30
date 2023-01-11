package ch.patchcode.tdm90

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class PositionTest {

    @Test
    fun tileNameN00E000() {
        val position = Position(longitude = 0.0, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00E000", geoTiffName)
    }

    @Test
    fun tileNameN05E000() {
        val position = Position(longitude = 0.0, latitude = 5.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N05E000", geoTiffName)
    }

    @Test
    fun tileNameN05E000_slightlyNorth() {
        val position = Position(longitude = 0.0, latitude = 5.1)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N05E000", geoTiffName)
    }

    @Test
    fun tileNameN25W001() {
        val position = Position(longitude = -1.0, latitude = 25.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N25W001", geoTiffName)
    }

}
