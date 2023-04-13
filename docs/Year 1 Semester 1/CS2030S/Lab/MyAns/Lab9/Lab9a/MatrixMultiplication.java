import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.lang.Math;

class MatrixMultiplication extends RecursiveTask<Matrix> {

  /** The fork threshold. */
  private static final int FORK_THRESHOLD = (int) Math.pow(2, 8); // Find a good threshold

  /** The first matrix to multiply with. */
  private final Matrix m1;

  /** The second matrix to multiply with. */
  private final Matrix m2;

  /** The starting row of m1. */
  private final int m1Row;

  /** The starting col of m1. */
  private final int m1Col;

  /** The starting row of m2. */
  private final int m2Row;

  /** The starting col of m2. */
  private final int m2Col;

  /**
   * The dimension of the input (sub)-matrices and the size of the output
   * matrix.
   */
  private int dimension;

  /**
   * A constructor for the Matrix Multiplication class.
   * 
   * @param m1        The matrix to multiply with.
   * @param m2        The matrix to multiply with.
   * @param m1Row     The starting row of m1.
   * @param m1Col     The starting col of m1.
   * @param m2Row     The starting row of m2.
   * @param m2Col     The starting col of m2.
   * @param dimension The dimension of the input (sub)-matrices and the size
   *                  of the output matrix.
   */
  MatrixMultiplication(Matrix m1, Matrix m2, int m1Row, int m1Col, int m2Row,
      int m2Col, int dimension) {
    this.m1 = m1;
    this.m2 = m2;
    this.m1Row = m1Row;
    this.m1Col = m1Col;
    this.m2Row = m2Row;
    this.m2Col = m2Col;
    this.dimension = dimension;
  }

  @Override
  public Matrix compute() {
    if (dimension < FORK_THRESHOLD) {
      return Matrix.nonRecursiveMultiply(m1, m2, m1Row, m1Col, m2Row, m2Col, dimension);
    }
    Matrix result = new Matrix(dimension);

    MatrixMultiplication a11b11 = new MatrixMultiplication(m1, m2, m1Row, m1Col, m2Row, m2Col, dimension / 2);
    a11b11.fork();

    MatrixMultiplication a12b21 = new MatrixMultiplication(m1, m2, m1Row, m1Col + dimension / 2,
        m2Row + dimension / 2, m2Col, dimension / 2);
    a12b21.fork();

    Matrix na12b21 = a12b21.join();
    Matrix na11b11 = a11b11.join();
    for (int i = 0; i < dimension / 2; i++) {
      double[] m1m = na11b11.m[i];
      double[] m2m = na12b21.m[i];
      double[] r1m = result.m[i];
      for (int j = 0; j < dimension / 2; j++) {
        r1m[j] = m1m[j] + m2m[j];
      }
    }

    MatrixMultiplication a11b12 = new MatrixMultiplication(m1, m2, m1Row, m1Col, m2Row, m2Col + dimension / 2,
        dimension / 2);
    a11b12.fork();

    MatrixMultiplication a12b22 = new MatrixMultiplication(m1, m2, m1Row, m1Col + dimension / 2,
        m2Row + dimension / 2, m2Col + dimension / 2, dimension / 2);
    a12b22.fork();

    Matrix na12b22 = a12b22.join();
    Matrix na11b12 = a11b12.join();
    for (int i = 0; i < dimension / 2; i++) {
      double[] m1m = na11b12.m[i];
      double[] m2m = na12b22.m[i];
      double[] r1m = result.m[i];
      for (int j = 0; j < dimension / 2; j++) {
        r1m[j + dimension / 2] = m1m[j] + m2m[j];
      }
    }

    MatrixMultiplication a21b11 = new MatrixMultiplication(m1, m2, m1Row + dimension / 2, m1Col, m2Row, m2Col,
        dimension / 2);
    a21b11.fork();

    MatrixMultiplication a22b21 = new MatrixMultiplication(m1, m2, m1Row + dimension / 2, m1Col + dimension / 2,
        m2Row + dimension / 2, m2Col, dimension / 2);
    a22b21.fork();

    Matrix na22b21 = a22b21.join();
    Matrix na21b11 = a21b11.join();
    for (int i = 0; i < dimension / 2; i++) {
      double[] m1m = na21b11.m[i];
      double[] m2m = na22b21.m[i];
      double[] r1m = result.m[i + dimension / 2];
      for (int j = 0; j < dimension / 2; j++) {
        r1m[j] = m1m[j] + m2m[j];
      }
    }

    MatrixMultiplication a21b12 = new MatrixMultiplication(m1, m2, m1Row + dimension / 2, m1Col, m2Row,
        m2Col + dimension / 2, dimension / 2);
    a21b12.fork();

    MatrixMultiplication a22b22 = new MatrixMultiplication(m1, m2, m1Row + dimension / 2, m1Col + dimension / 2,
        m2Row + dimension / 2, m2Col + dimension / 2, dimension / 2);
    a22b22.fork();

    Matrix na22b22 = a22b22.join();
    Matrix na21b12 = a21b12.join();
    for (int i = 0; i < dimension / 2; i++) {
      double[] m1m = na21b12.m[i];
      double[] m2m = na22b22.m[i];
      double[] r1m = result.m[i + dimension / 2];
      for (int j = 0; j < dimension / 2; j++) {
        r1m[j + dimension / 2] = m1m[j] + m2m[j];
      }
    }

    return result;
  }
}
