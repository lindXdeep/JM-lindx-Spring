public class Main {

  /**
   * Создать квадратный двумерный целочисленный массив (количество строк и
   * столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные
   * элементы единицами;
   */

  private static int[][] cube = new int[10][10];

  public static void main(String[] args) {

    for (int i = 0; i < cube.length; i++) {

      int size = cube[i].length - i;

      for (int j = 0; j < size; j++) {
        cube[j][j] = 1;
        cube[i][size - 1] = 1;
      }
    }

    printCube(cube);
  }

  public static void printCube(final int[][] cube) {
    for (int i = 0; i < cube.length; i++) {
      for (int j = 0; j < cube[i].length; j++) {
        System.out.print(cube[i][j] + " ");
      }
      System.out.println();
    }
  }
}
