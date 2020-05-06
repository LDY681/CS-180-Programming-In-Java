/**
 * CS180 - LAB 06 - Matrix
 * Matrix LAB things
 *
 * @author Liu Dayu
 * @version 1 2/18/2016
 */

public class Matrix {

    /**
     * Its a constructor O_o
     */
    public Matrix() {
    }

    /**
     * Decide whether its a valid matrix or not
     *
     * @param matrix
     * @return
     */
    public boolean isValid(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length) {
            return false;
        }
        return true;
    }


    /**
     * Decide if the matrix is symmetric or not
     *
     * @param matrix input matrix
     * @return isSymmetric or not
     */
    public boolean isSymmetric(int[][] matrix) {
        if (!isValid(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Decide whether matrix is diagonal matrix or not
     *
     * @param matrix input matrix
     * @return isDiagonal or not
     */
    public boolean isDiagonal(int[][] matrix) {
        if (!isValid(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Decide whether matrix is Identity matrix or not
     *
     * @param matrix input matrix
     * @return isIdentity or not
     */
    public boolean isIdentity(int[][] matrix) {
        if (!isValid(matrix)) {
            return false;
        }

        if (!isDiagonal(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Decide whether matrix is UpperTriangular matrix or not
     *
     * @param matrix input matrix
     * @return isUpperTriangular or not
     */
    public boolean isUpperTriangular(int[][] matrix) {
        if (!isValid(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Decide whether matrix is TriDiagonal matrix or not
     *
     * @param matrix input matrix
     * @return isTriDiagonal or not
     */
    public boolean isTriDiagonal(int[][] matrix) {
        if (!isValid(matrix)) {
            return false;
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j + 1 && i != j && i != j - 1) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
