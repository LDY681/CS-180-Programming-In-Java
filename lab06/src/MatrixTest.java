import static org.junit.Assert.*;

import org.junit.*;

public class MatrixTest {
    private Matrix a;

    @Before
    public void setUp() throws Exception {
        a = new Matrix();
    }

    /**
     * Test for isSymmetric
     */
    @Test(timeout = 100)
    public void testisSymmetric1() {
        int[][] matrix = {{9, 6, 3, 5}, {6, 13, 9, 8}, {3, 9, 21, 7}, {5, 8, 7, 99}};
        boolean sm1 = a.isSymmetric(matrix);
        String message = "isSymmetric(): if matrix is symmetric, should return true";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisSymmetric2() {
        int[][] matrix = {{9, 8, 3, 5}, {6, 13, 9, 8}, {3, 9, 21, 7}, {5, 8, 7, 99}};
        boolean sm1 = a.isSymmetric(matrix);
        String message = "isSymmetric(): if matrix is symmetric, should return false";
        assertFalse(message, sm1);
    }

    @Test(timeout = 100)
    public void testisSymmetric3() {
        int[][] matrix = {{9, 6, 3, 5}, {6, 13, 9, 8}, {3, 9, 21, 7}};
        boolean sm1 = a.isSymmetric(matrix);
        String message = "isSymmetric(): if matrix is symmetric, should return false";
        assertFalse(message, sm1);
    }

    /**
     * Test for isDiagonal
     */
    @Test(timeout = 100)
    public void testisDiagonal1() {
        int[][] matrix = {{9, 0, 0, 0}, {0, 13, 0, 0}, {0, 0, 21, 0}, {0, 0, 0, 99}};
        boolean sm1 = a.isDiagonal(matrix);
        String message = "isDiagonal(): if matrix is Diagonal, should return true";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisDiagonal2() {
        int[][] matrix = {{9, 1, 0, 0}, {0, 13, 0, 0}, {0, 0, 21, 0}, {0, 0, 0, 99}};
        boolean sm1 = a.isDiagonal(matrix);
        String message = "isDiagonal(): if matrix isDiagonal, should return false";
        assertFalse(message, sm1);
    }

    @Test(timeout = 100)
    public void testisDiagonal3() {
        int[][] matrix = {{9, 0, 0, 0}, {0, 13, 0, 0}, {0, 0, 21, 0}};
        boolean sm1 = a.isDiagonal(matrix);
        String message = "isDiagonal(): if matrix isDiagonal, should return false";
        assertFalse(message, sm1);
    }

    /**
     * Test for isIdentity
     */
    @Test(timeout = 100)
    public void testisIdentity1() {
        int[][] matrix = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        boolean sm1 = a.isIdentity(matrix);
        String message = "isIdentity(): if matrix is isIdentity, should return true";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisIdentity2() {
        int[][] matrix = {{9, 1, 0, 0}, {0, 13, 0, 0}, {0, 0, 21, 0}, {0, 0, 0, 99}};
        boolean sm1 = a.isIdentity(matrix);
        String message = "isIdentity(): if matrix is isIdentity, should return false";
        assertFalse(message, sm1);
    }

    @Test(timeout = 100)
    public void testisIdentity3() {
        int[][] matrix = {{9, 0, 0, 0}, {0, 13, 0, 0}, {0, 0, 21, 0}};
        boolean sm1 = a.isIdentity(matrix);
        String message = "isIdentity(): if matrix is isIdentity, should return false";
        assertFalse(message, sm1);
    }

    /**
     * Test for isUpperTriangular
     */
    @Test(timeout = 100)
    public void testisUpperTriangular1() {
        int[][] matrix = {{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 0}};
        boolean sm1 = a.isUpperTriangular(matrix);
        String message = "isUpperTriangular(): if matrix is isUpperTriangular, should return true";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisUpperTriangular2() {
        int[][] matrix = {{0, 3421, 0, 0}, {0, 0, 3421, 0}, {0, 0, 0, 142}, {0, 0, 0, 12}};
        boolean sm1 = a.isUpperTriangular(matrix);
        String message = "isUpperTriangular(): if matrix is isUpperTriangular, should return false";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisUpperTriangular3() {
        int[][] matrix = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        boolean sm1 = a.isUpperTriangular(matrix);
        String message = "isUpperTriangular(): if matrix is isUpperTriangular, should return false";
        assertTrue(message, sm1);
    }

    /**
     * Test for isUpperTriangular
     */
    @Test(timeout = 100)
    public void testisTriDiagonal1() {
        int[][] matrix = {{32, 32, 0, 0}, {20, 10, 1, 0}, {0, 43, 3, 1}, {0, 0, 20, 43}};
        boolean sm1 = a.isTriDiagonal(matrix);
        String message = "isTriDiagonal(): if matrix is isTriDiagonal, should return true";
        assertTrue(message, sm1);
    }

    @Test(timeout = 100)
    public void testisTriDiagonal2() {
        int[][] matrix = {{32, 32, 2, 0}, {20, 10, 1, 0}, {0, 043, 03, 1}, {0, 0, 20, 043}};
        boolean sm1 = a.isTriDiagonal(matrix);
        String message = "isTriDiagonal(): if matrix is isTriDiagonal, should return false";
        assertFalse(message, sm1);
    }

    @Test(timeout = 100)
    public void testisTriDiagonal3() {
        int[][] matrix = {{32, 32, 0, 0, 0}, {20, 10, 1, 0, 0}, {0, 043, 03, 1, 0}, {0, 0, 0, 20, 043}, {0, 0, 0, 32, 65}};
        boolean sm1 = a.isTriDiagonal(matrix);
        String message = "isTriDiagonal(): if matrix is isTriDiagonal, should return True";
        assertTrue(message, sm1);
    }
}







