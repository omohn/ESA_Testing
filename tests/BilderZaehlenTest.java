import esa.Gratification;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BilderZaehlenTest {

    Gratification grati;
    String zwoelfBilder;
    String fuenfBilder;

    @Before
    public void setUp() throws Exception {
        grati = new Gratification();

    }

    @Test
    public void bilderZaehlen() {

        fuenfBilder = "Fusce.jpg a quam. Curabitur.jpg blandit bilder.jpg lacus. Aliquam eu nunc. " +
        "Vestibulum purus quam, scelerisque.jpg ut, mollis sed,.jpg nonummy id, metus. ";

        assertEquals("5", 5, grati.countImages(fuenfBilder));

        zwoelfBilder = "Fusce.jpg a quam. Curabitur.jpg blandit bilder.jpg lacus. Aliquam eu nunc. " +
                "Vestibulum purus quam, scelerisque.jpg ut, mollis sed,.jpg nonummy id, metus. " +
                "Etiam BILDER. Aenean.jpg leo ligula, porttitor bilder, consequat vitae, eleifend " +
                "ac, enim. Vestibulum.jpg fringilla.jpg Bilder sit amet augue. Sed a libero. " +
                "Vestibulum rutrum, mi nec elementum vehicula.jpg , eros.jpg quam gravida " +
                "nisl, id Bilder neque.jpg ante vel.jpg mi.";

        assertEquals("12", 12, grati.countImages(zwoelfBilder));

        assertEquals("0", 0, grati.countImages(""));

        assertThrows("Exception expected", IllegalArgumentException.class, () -> grati.countImages(null));

    }
}