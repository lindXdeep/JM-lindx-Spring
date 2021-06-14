/**
 * Task 02
 */
public class Task003 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    // OR
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%s ", (i < 1) | (i > SIZE - 2) | (j < 1) | (j > SIZE - 2) ? '0' : '*');
      }
      System.out.println();
    }

    // AND
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%s ", (i > 0) & (i < SIZE - 1) & (j > 0) & (j < SIZE - 1) ? '*' : '0');
      }
      System.out.println();
    }
  }
}
