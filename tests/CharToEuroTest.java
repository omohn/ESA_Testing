import esa.Gratification;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharToEuroTest {

    Gratification grati;
    private String fourtyEightChars;
    private String moreChars;
    private String fuenfBilder;
    private String zwoelfBilder;

    @Before
    public void setUp() throws Exception {
        grati = new Gratification();

    }

    @Test
    public void calcEuro() {

        fourtyEightChars = "Cras ultricies mi eu turpis hendrerit fringilla.";
        assertEquals("48 / 10",4.8, grati.calcEuro(fourtyEightChars), .001);  // Delta = 0,001 für Genauigkeit der Übereinstimmung

        moreChars = "Fusce a quam. Curabitur blandit mollis lacus. Aliquam eu nunc. " +
                "Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. " +
                "Etiam rhoncus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend " +
                "ac, enim. Vestibulum fringilla pede sit amet augue. Sed a libero. " +
                "Vestibulum rutrum, mi nec elementum vehicula, eros quam gravida " +
                "nisl, id fringilla neque ante vel mi.";
        assertEquals("374 / 10",37.4, grati.calcEuro(moreChars), .001);

        assertEquals("0 / 10", 0, grati.calcEuro(""), .001);

        assertThrows("Exception expected", IllegalArgumentException.class, () -> grati.calcEuro(null));

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