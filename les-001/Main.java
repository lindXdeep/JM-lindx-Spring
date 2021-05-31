import java.time.Year;
import java.util.Scanner;

public class Main {

  private static byte a;    // 8 bit
  private static short b;   // 16 bit
  private static int c;     // 32 bit
  private static long d;    // 64 bit

  private static float e;   // 32 bit
  private static double f;  // 64 bit

  private static char g;    // 16 bit

  private static boolean z; // 1 bit

  public static void main(String[] args) {

    // 2. Создать переменные всех пройденных типов данных, и инициализировать их
    // значения;

    a = 127;
    b = 32767;
    c = 2147000000;
    d = 9123456987L;
    e = 23345435.0f;
    f = 1233.321d;
    g = 'A';
    z = true;

    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);
    System.out.println(f);
    System.out.println(g);
    System.out.println(z);

    System.out.println("\n3:\t" + calc(a, b, c, d));

    System.out.println("4:\t" + twoNum(5, 6));

    System.out.println("5:\t" + positive(d));

    System.out.println("6:\t" + negative(300));

    hello("Tom");

    Scanner scanner = new Scanner(System.in);

    year(scanner.nextInt());

    scanner.close();

  }

  // 3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий
  // результат, где a, b, c, d – входные параметры этого метода;
  public static double calc(final byte a, final short b, final int c, final long d) {
    return a * (b + (c / d));
  }

  // 4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма
  // лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в
  // противном случае – false;
  public static boolean twoNum(final int a, final int b) {
    return (((a + b) >= 10) && ((a + b) <= 20)) ? true : false;
  }

  // 5. Написать метод, которому в качестве параметра передается целое число,
  // метод должен напечатать в консоль положительное число передали или
  // отрицательное (Замечание: ноль считаем положительным числом.);
  public static String positive(final long num) {
    return (num < 0) ? "Negative" : "Positive";
  }

  // 6. Написать метод, которому в качестве параметра передается целое число,
  // метод должен вернуть true, если число отрицательное;
  public static boolean negative(final long num) {
    return (num < 0) ? true : false;
  }

  // 7. Написать метод, которому в качестве параметра передается строка,
  // обозначающая имя, метод должен вывести в консоль сообщение «Привет,
  // указанное_имя!»;
  public static void hello(final String name) {
    System.out.println("«Привет, " + name + "!»");
  }

  // 8. *Написать метод, который определяет, является ли год високосным, и выводит
  // сообщение в консоль. Каждый 4-й год является високосным, кроме каждого
  // 100-го, при этом каждый 400-й – високосный.
  public static void year(final int year) {
    if ((year % 400 == 0) || ((year % 4 == 0) & (year % 100 != 0))) {
      System.out.println(year + " год является високосным");
    } else {
      System.out.println(year + " год високосныq");
    }
  }
}
