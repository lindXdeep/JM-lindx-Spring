public class Main {

  /**
   * Написать метод, в который передается не пустой одномерный целочисленный
   * массив, метод должен вернуть - true, если в массиве есть место, в котором
   * сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, ||
   * 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, ||
   * 10]) → true, граница показана символами ||, эти символы в массив не входят;
   */

  private static int[] arr1 = { 1, 1, 1, 1, 2, 2 }; // true
  private static int[] arr2 = { 2, 1, 1, 2, 1 }; // false

  public static void main(String[] args) {
    System.out.println(checkBalance(arr1));
    System.out.println(checkBalance(arr2));
  }

  private static boolean checkBalance(final int[] arr) {

    int sum = 0;
    for (int i : arr)
      sum += i;

    if (sum % 2 != 0)
      return false;

    int left = 0;
    int right = 0;
    int mediana = arr.length / 2;

    do {
      left = 0;
      right = 0;

      int r = mediana;
      int l = r - 1;

      while (l >= 0)
        left += arr[l--];
      while (r < arr.length)
        right += arr[r++];

      if (left != right) {
        mediana = (left < right) ? mediana + 1 : mediana - 1;
      }
    } while (left != right);

    for (int i = 0; i < mediana; i++)
      System.out.print(arr[i] + " ");
    System.out.print("| ");
    for (int i = mediana; i < arr.length; i++)
      System.out.print(arr[i] + " ");

    return true;
  }
}
