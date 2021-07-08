
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    Function functions = new Function();
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");

    }
    @BeforeEach
    public void setUp(){
        logger.info("Test begins!");
    }
    @Test
    void testNegative() {
        boolean result = functions.isNumberEven(8);
        Assertions.assertTrue(result);
    }

    @Test
    public void isPrimePositiveTest() {
        Assertions.assertTrue(functions.isNumberEven(13));

    }
        @AfterAll
        static void afterAllTests() {
            logger.info("After all tests");
        }
}
