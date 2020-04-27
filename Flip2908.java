import java.io.IOException;
import java.util.Scanner;

public class Flip2908 {
    public static int a, b;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        compareNum(a, b);
    }

    public static void compareNum(int a, int b) {
        do {
            if (a % 10 > b % 10) {
                printReverse(a);
                break;
            } else if (a % 10 < b % 10) {
                printReverse(b);
                break;
            } else {
                System.out.print(a % 10);
            }
            a /= 10;
            b /= 10;
        } while (a != 0);
    }

    public static void printReverse(int a) {
        do {
            System.out.print(a % 10);
            a /= 10;
        } while (a != 0);
    }
}