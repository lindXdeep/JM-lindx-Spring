public class Main {

  /**
   * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
   * значениями 0 3 6 9 12 15 18 21;
   * 
   */

  private static int i;
  private static int[] arr = new int[8];

  public static void main(String[] args) {

    while ((i += 3) / 3 < arr.length) {
      arr[i / 3] = i;
    }

    for (int a : arr) {
      System.out.print(a + " ");
    }
  }
}
