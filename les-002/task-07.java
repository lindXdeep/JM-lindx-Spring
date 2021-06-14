public class Main {

  /**
   * Написать метод, которому на вход подается одномерный массив и число n (может
   * быть положительным или отрицательным), при этом метод должен сместить все
   * элементы массива на n позиций. Нельзя пользоваться вспомогательными
   * массивами.
   */

  private static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

  public static void main(String[] args) {

    moveOn(arr, -3);

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  public static void moveOn(final int[] arr, final int n) {

    int i = 0;
    int j = (n < 0) ? -n : n;
    int size = arr.length;

    if (n < 0) {
      while (i < size & j < size) {
        arr[i++] = arr[j++];
      }
    }

    if (n > 0) {

      i = size - 1;
      j = size - n;

      while (i > 0 & j > 0) {
        arr[i--] = arr[j--];
      }
    }

    if (n < 0) {
      while (i < size) {
        arr[i++] = 0;
      }
    } else {
      while (j <= i) {
        arr[j++] = 0;
      }
    }
  }
}
