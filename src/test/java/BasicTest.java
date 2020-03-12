import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicTest {
    @Test
    public void simpleTest() {
        Assertions.assertEquals(2, 1 + 1, "Simple test");
    }
}
