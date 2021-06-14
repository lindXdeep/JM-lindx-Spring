/**
 * Task 07
 */
public class Task007 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    // AND
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%2s", (j > 0) & (i < SIZE - 1) & (i != j) ? ' ' : '*');
      }
      System.out.println();
    }

    // OR
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%2s", (j < 1) | (i > SIZE - 2) | (i == j) ? '*' : ' ');
      }
      System.out.println();
    }
  }
}
