/**
 * Task 05
 */
public class Task005 {

  private static int SIZE = 6;

  public static void main(String[] args) {

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        
        if (i < j) {
          System.out.printf("%s ", '+');
        } else {
          System.out.printf("%s ", (i > j) ? '-' : '0');
        }
      }
      System.out.println();
    }
  }
}
