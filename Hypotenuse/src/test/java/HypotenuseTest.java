import example.test.Hypotenuse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;

public class HypotenuseTest {
    @Test
    void invalidParameterExceptionTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            Hypotenuse.getHypotenuse(-3.0, 4.0);
        });
    }

    @Test
    void getHypotenuseTest() {
        double testVal = Hypotenuse.getHypotenuse(3.0, 4.0);
        Assertions.assertEquals(5.0, testVal);

        testVal = Hypotenuse.getHypotenuse(6.0, 8.0);
        Assertions.assertEquals(10, testVal);
    }
}
