
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

  private static boolean SILLY_MODE = false;
  private static int SIZE = 5;

  private static char[][] field;

  private static char DOT_X = 'X';
  private static char DOT_O = 'O';
  private static char DOT_EMPTY = '•';

  private static boolean GAME = true;

  private static Scanner sc;

  // веса выигрышных позиций
  private static int[] ai_x_X = new int[SIZE];
  private static int[] ai_y_X = new int[SIZE];
  private static int ai_v_X = 0;
  private static int ai_z_X = 0;

  private static int[] ai_x_O = new int[SIZE];
  private static int[] ai_y_O = new int[SIZE];
  private static int ai_v_O = 0;
  private static int ai_z_O = 0;

  private static Random rand;

  public static void main(String[] args) {
    initMap();
    gameloop();
  }

  private static void gameloop() {
    while (GAME) {

      printMap();

      humanTurn();

      if (checkWin(DOT_X)) {
        printMap();
        System.out.println("\n\tВы победили!");
        break;
      }

      checkFieldAndFillWeights();

      computerTurn();

      System.out.println();

      if (checkWin(DOT_X)) {
        printMap();
        System.out.println("\n\tВы проиграли! =(");
        break;
      }
    }
  }

  private static boolean isDeadHeat() {

    for (char[] y : field)
      for (char x : y)
        if (x == DOT_EMPTY)
          return false;
    return true; 
  }

  private static boolean isWin(final boolean[] win_state) {

    int win_result = 0;

    for (int b = 0; b < win_state.length - 1; b++) {
      win_result = win_state[b] & win_state[b + 1] ? win_result + 1 : win_result;
    }

    return win_result == 4;
  }

  private static boolean checkWin(final char symbol) {

    boolean[] win_state = new boolean[SIZE];

    for (int x = 0; x < SIZE; x++) {

      Arrays.fill(win_state, false);

      for (int y = 0; y < SIZE; y++) {
        win_state[y] = field[x][y] == symbol;
      }

      if (isWin(win_state)) {
        return true;
      }
    }

    for (int y = 0; y < SIZE; y++) {

      Arrays.fill(win_state, false);

      for (int x = 0; x < SIZE; x++) {
        win_state[x] = field[x][y] == symbol;
      }

      if (isWin(win_state)) {
        return true;
      }
    }

    Arrays.fill(win_state, false);

    for (int x = 0; x < SIZE; x++) {
      win_state[x] = field[x][x] == symbol;
    }

    if (isWin(win_state)) {
      return true;
    }

    Arrays.fill(win_state, false);

    for (int x = 0; x < SIZE; x++) {
      win_state[x] = field[x][SIZE - x - 1] == symbol;
    }

    if (isWin(win_state)) {
      return true;
    }

    return false;
  }

  public static boolean isCorrectInput(final String x, final String y) {
    for (int i = 0; i < x.length(); i++) {
      if (!Character.isDigit(x.charAt(i))) {
        return false;
      }
    }

    for (int i = 0; i < y.length(); i++) {
      if (!Character.isDigit(y.charAt(i))) {
        return false;
      }
    }

    return (Integer.parseInt(x) >= 0 & Integer.parseInt(x) < SIZE)
        & (Integer.parseInt(y) >= 0 & Integer.parseInt(y) < SIZE);
  }

  public static boolean isCellValid(final int x, final int y) {

    return field[x][y] == DOT_EMPTY;
  }

  private static void humanTurn() {

    sc = new Scanner(System.in);

    String line_x = "";
    String line_y = "";

    boolean stepDuration = true;

    do {

      System.out.print("\nВведите координаты ячейки (X Y): ");

      line_x = sc.next();
      line_y = sc.next();

      if (!isCorrectInput(line_x, line_y)) {
        System.out.println("\nКоординаты [" + line_x + "] и [" + line_y + "] неверны!");
        System.out.println("\nВведите координаты через пробел границах от 0 до " + SIZE + ": ");
        stepDuration = true;
      } else {
        if (!isCellValid(Integer.parseInt(line_x), Integer.parseInt(line_y))) {
          System.out.println("\nЯчейка уже занята.");
          stepDuration = true;
        } else {
          System.out.println("\nВаш ход: [x = " + line_x + "] [y = " + line_y + "]");

          field[Integer.parseInt(line_x)][Integer.parseInt(line_y)] = DOT_X;

          stepDuration = false;
          break;
        }
      }
    } while (stepDuration);
  }

  private static void computerTurn() {
    if (SILLY_MODE) {

      int x = 0;
      int y = 0;

      rand = new Random();

      do {

        x = rand.nextInt(SIZE);
        y = rand.nextInt(SIZE);

        if (isCellValid(x, y)) {
          field[x][y] = DOT_O;
          break;
        }

      } while (GAME);

    } else {

      if (!checkPreWin()) {

        int[] pos = randomPosition();

        field[pos[0]][pos[1]] = DOT_O;
      }

      checkFieldAndFillWeights();
    }
  }

  private static void printMap() {

    System.out.print("\n     ");
    for (int i = 0; i < SIZE; i++) {
      System.out.printf("%2d ", i);
    }
    System.out.println();
    System.out.print("    ");

    int k = 0;
    while (k++ < SIZE) {
      System.out.print("___");
    }

    System.out.println();

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("%2d  |", i);
      for (int j = 0; j < SIZE; j++) {
        System.out.print(" " + field[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void initMap() {

    field = new char[SIZE][SIZE];

    int i = SIZE;
    while (i-- > 0) {
      int j = SIZE;
      while (j-- > 0) {
        field[i][j] = DOT_EMPTY;
      }
    }
  }

  private static void checkFieldAndFillWeights() {

    dropWeights();

    // проходим по осям Y и заполняем веса.
    for (int x = 0; x < SIZE; x++) {
      for (int y = 0; y < SIZE; y++) {
        ai_y_X[y] = (field[x][y] != DOT_EMPTY && field[x][y] == DOT_X) ? ai_y_X[y] + 1 : ai_y_X[y];
        ai_y_O[y] = (field[x][y] != DOT_EMPTY && field[x][y] == DOT_O) ? ai_y_O[y] + 1 : ai_y_O[y];
      }
    }

    // проходим по осям X и заполняем веса
    for (int y = 0; y < SIZE; y++) {
      for (int x = 0; x < SIZE; x++) {
        ai_x_X[y] = (field[y][x] != DOT_EMPTY && field[y][x] == DOT_X) ? ai_x_X[y] + 1 : ai_x_X[y];
        ai_x_O[y] = (field[y][x] != DOT_EMPTY && field[y][x] == DOT_O) ? ai_x_O[y] + 1 : ai_x_O[y];
      }
    }

    // проходим по оси V c лева на право
    for (int v = 0; v < SIZE; v++) {
      ai_v_X = (field[v][v] != DOT_EMPTY && field[v][v] == DOT_X) ? ai_v_X + 1 : ai_v_X;
      ai_v_O = (field[v][v] != DOT_EMPTY && field[v][v] == DOT_O) ? ai_v_O + 1 : ai_v_O;
    }

    // проходим по оси Z c права на лево
    for (int z = 0; z < SIZE; z++) {
      ai_z_X = (field[z][SIZE - z - 1] != DOT_EMPTY && field[z][SIZE - z - 1] == DOT_X) ? ai_z_X + 1 : ai_z_X;
      ai_z_O = (field[z][SIZE - z - 1] != DOT_EMPTY && field[z][SIZE - z - 1] == DOT_O) ? ai_z_O + 1 : ai_z_O;
    }
  }

  private static void dropWeights() {

    Arrays.fill(ai_x_X, 0);
    Arrays.fill(ai_y_X, 0);
    ai_v_X = 0;
    ai_v_O = 0;

    Arrays.fill(ai_x_O, 0);
    Arrays.fill(ai_y_O, 0);
    ai_z_X = 0;
    ai_z_O = 0;
  }

  private static boolean checkPreWin() {

    int[] pos;

    pos = checkPreWinPosition(ai_x_X, ai_y_X);
    System.out.println("set xy : " + pos[0] + " " + pos[1]);

    if (isCellValid(pos[0], pos[1])) {
      field[pos[1]][pos[0]] = DOT_O;
      return true;
    }

    pos = checkPreWinPosition(ai_y_X, ai_x_X);
    System.out.println("set yx : " + pos[0] + " " + pos[1]);
    if (isCellValid(pos[1], pos[0])) {
      field[pos[1]][pos[0]] = DOT_O;
      return true;
    }

    if (ai_v_X == SIZE - 1) {
      for (int i = 0; i < SIZE; i++) {
        if (isCellValid(i, i)) {
          field[i][i] = DOT_O;
          return true;
        }
      }
    }

    if (ai_z_X == SIZE - 1) {
      for (int i = 0; i < SIZE; i++) {
        if (isCellValid(i, SIZE - i - 1)) {
          field[i][SIZE - i - 1] = DOT_O;
          return true;
        }
      }
    }
    return false;
  }

  /**
   * return coordinate.
   * 
   * @param arrayX
   * @param arrayY
   * @return position[x][y]
   */
  public static int[] checkPreWinPosition(final int[] arrayX, final int[] arrayY) {

    int idx = 0;
    int[] position = new int[2];

    do {
      if (arrayY[idx] == SIZE - 1) {
        position[1] = idx;
        position[0] = getEmptyIdx(arrayX);
        break;
      }
    } while (idx++ < SIZE - 1);

    return position;
  }

  public static int getEmptyIdx(final int[] weightArray) {

    int idx = 0;

    while (idx < SIZE - 1) {
      if (weightArray[idx++] == 0) {
        break;
      }
    }

    return idx;
  }

  public static int[] randomPosition() {

    int[] pos = new int[2];

    rand = new Random();

    if (isDeadHeat()) {
      System.out.println("\n\tНичья!");
      GAME = false;
    }

    while (GAME) {
      pos[0] = rand.nextInt(SIZE);
      pos[1] = rand.nextInt(SIZE);
      System.out.println("pos: " + pos[0] + " " + pos[1]);
      if (isCellValid(pos[0], pos[1])) {
        break;
      }
    }

    return pos;
  }
}
