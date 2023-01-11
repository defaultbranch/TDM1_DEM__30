package ch.patchcode.tdm90

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class PositionTest {

    @Test
    fun tileNameZeroZero() {
        val position = Position(longitude = 0.0, latitude = 0.0)
        val geoTiffName = position.tileName()
        assertEquals("TDM1_DEM__30_N00E000", geoTiffName)
    }
}
