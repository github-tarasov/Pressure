package example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PressureTest {

    private static final double DELTA = 1e-15;

    @Test
    public void testSuccess()
    {
        Pressure pressure = new Pressure(1d);

        assertEquals("Wrong w(0, 0) result", 0d, pressure.w(0, 0), DELTA);

        assertEquals("Wrong w(1, 0) result", 0.5d, pressure.w(1, 0), DELTA);
        assertEquals("Wrong w(1, 1) result", 0.5d, pressure.w(1, 1), DELTA);

        assertEquals("Wrong w(2, 0) result", 0.75d, pressure.w(2, 0), DELTA);
        assertEquals("Wrong w(2, 1) result", 1.5d, pressure.w(2, 1), DELTA);
        assertEquals("Wrong w(2, 2) result", 0.75d, pressure.w(2, 2), DELTA);

        assertEquals("Wrong w(3, 0) result", 0.875d, pressure.w(3, 0), DELTA);
        assertEquals("Wrong w(3, 1) result", 2.125d, pressure.w(3, 1), DELTA);
        assertEquals("Wrong w(3, 2) result", 2.125d, pressure.w(3, 2), DELTA);
        assertEquals("Wrong w(3, 3) result", 0.875d, pressure.w(3, 3), DELTA);

        assertEquals("Wrong w(322, 156) result", 306.48749781747574d, pressure.w(322, 156), DELTA);
    }

    @Test
    public void testException()
    {
        Pressure pressure = new Pressure(1d);
        boolean thrown;

        thrown = false;
        try {
            pressure.w(10, -1);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);

        thrown = false;
        try {
            pressure.w(10, 11);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}
