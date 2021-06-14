/**
 * Task 04
 */
public class Task004 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%s ", (i + j) % 2 == 0 ? '0' : '*');
      }
      System.out.println();
    }
  }
}
