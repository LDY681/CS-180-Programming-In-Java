/**
 * CS180 - Lab 03 - StringManipulator
 * <p>
 * TESTTTTTTTTTT SM
 *
 * @author Liu Dayu, liu1589@purdue.edu
 */

import static org.junit.Assert.*;

import org.junit.*;

/**
 * JUnit test case class for testing the functionality of methods from the StringManipulator class.
 */
public class StringManipulatorTest {
    private StringManipulator sm;

    @Before
    public void setUp() throws Exception {
        sm = new StringManipulator();
    }

    /**
     * Test the basic functionality of makeUserName.
     * Don't check for correct case.
     */
    @Test(timeout = 100)
    public void testMakeUserNameBasic() {
        String ret = sm.makeUserName("john doe");
        String message = "makeUserName(): check if username follows the basic Unix style structure";
        assertEquals(message, "jdoe", ret);
    }

    @Test(timeout = 100)
    public void testMakeUserNameLower() {
        String ret = sm.makeUserName("DAYU LIU");
        String message = "makeUserName(): check if username goes lowercase";
        assertEquals(message, "dliu", ret);
    }

    @Test(timeout = 100)
    public void testMakeEmail() {
        String ret = sm.makeEmail("dliu", "purdue.edu");
        String message = "makeEmail(): Generate email address appropriately";
        assertEquals(message, "dliu@purdue.edu", ret);
    }
}
