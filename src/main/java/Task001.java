/**
 * Main
 */
public class Task001 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.printf("%s ", '*');
      }
      System.out.println();
    }
  }
}
