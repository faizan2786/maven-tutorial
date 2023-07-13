import example.test.Hypotenuse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HypotenuseTest {

    @Test
    void getHypotenuseTest() {
        double testVal = Hypotenuse.getHypotenuse(3.0, 4.0);
        Assertions.assertEquals(5.0, testVal);

        testVal = Hypotenuse.getHypotenuse(6.0, 8.0);
        Assertions.assertEquals(10, testVal);


    }
}
