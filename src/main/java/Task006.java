/**
 * Task 06
 */
public class Task006 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {

        if (i == j) {
          System.out.printf("%2s", '*');
        } else {
          System.out.printf("%2s", (i > 0) & (i < SIZE - 1) & (j > 0) & (j < SIZE - 1) ? ' ' : '*');
        }
      }
      System.out.println();
    }
  }
}
