public class Main {

  /**
   * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом,
   * и числа, меньшие 6, умножить на 2;
   */

  private static int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

  public static void main(String[] args) {

    int i = arr.length - 1;

    do {
      arr[i] = (arr[i] % 6 == arr[i]) ? arr[i] * 6 : arr[i];
    } while (i-- > 0);

    for (int a : arr) {
      System.out.print(a + " ");
    }
  }
}
