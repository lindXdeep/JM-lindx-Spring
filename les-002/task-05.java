public class Main {

  /**
   * Задать одномерный массив и найти в нем минимальный и максимальный элементы
   * (без помощи интернета);
   */

  private static int[] arr = { 4, 9, 2, 8, 4, 10, 7, 5, 6 };

  private static int min = arr[0];
  private static int max = arr[0];

  public static void main(String[] args) {

    int i = 0;
    while (i++ < arr.length - 1) {
      min = (arr[i] < min) ? arr[i] : min;
      max = (arr[i] > max) ? arr[i] : max;
    }

    System.out.println("Min: " + min + "\nMax: " + max);
  }
}
