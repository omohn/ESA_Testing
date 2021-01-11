package kuehlschrank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class KuehlschrankTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void passeKuehlStufeAn() {
        Sensor sensorMock = mock(Sensor.class);
        when(sensorMock.getTemperatur()).thenReturn(6);

        Kuehlschrank ks = new Kuehlschrank(sensorMock, 4);
        assertEquals(4, ks.passeKuehlStufeAn());
        Kuehlschrank ks2 = new Kuehlschrank(sensorMock, 8);
        assertEquals(2, ks2.passeKuehlStufeAn());
        Kuehlschrank ks3 = new Kuehlschrank(sensorMock, 6);
        assertEquals(3, ks3.passeKuehlStufeAn());
    }
}