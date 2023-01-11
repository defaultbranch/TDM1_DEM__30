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

    @Test
    fun tileNameN00E000_slightlyWest() {
        val position = Position(longitude = -0.1, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00W001", geoTiffName)
    }

    @Test
    fun tileNameN00W180() {
        val position = Position(longitude = 180.0, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00W180", geoTiffName)
    }

    @Test
    fun tileNameN00W180_negativeLongitude() {
        val position = Position(longitude = -180.0, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00W180", geoTiffName)
    }

    @Test
    fun tileNameN00W180_slightlyWest() {
        val position = Position(longitude = -179.9, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00W180", geoTiffName)
    }

    @Test
    fun tileNameN00W180_slightlyEast() {
        val position = Position(longitude = 179.9, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00E179", geoTiffName)
    }

}
