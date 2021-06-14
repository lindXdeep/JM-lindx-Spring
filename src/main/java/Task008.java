/**
 * Task 08
 */
public class Task008 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    // AND
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%2s", (i > 1) & (i < SIZE - 2) & (j > 1) & (j < SIZE - 2) ? ' ' : '*');
      }
      System.out.println();
    }
  }
}
