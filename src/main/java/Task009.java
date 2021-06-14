/**
 * Task 09
 */
public class Task009 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%2s", (i < SIZE - 2) & (j < SIZE - 2) || (j > 1) & (i > 1) ? '*' : ' ');
      }
      System.out.println();
    }
  }
}
