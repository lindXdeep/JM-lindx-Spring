
public class Main {

  /**
   * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1,
   * 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
   */

  private static int arr[] = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

  public static void main(String[] args) {

    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] ^ 1;
    }

    for (int i : arr)
      System.out.print(i);
  }
}
