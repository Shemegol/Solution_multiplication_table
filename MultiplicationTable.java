package Solution_multiplication_table;

import java.util.Scanner;

public class MultiplicationTable {

    private static Scanner sc = new Scanner(System.in).useDelimiter("[\r\n]+");

    private static int checkErr = 1;

    public static void main(String[] args) {
        System.out.println("Вывод на экран таблицы умножения от 1 до n.\n");
        if (args.length == 1) {
            try {
                byte n = Byte.parseByte(args[0]);
                if (n <= 0) {
                    byte n2 = readN();
                    printTable(n2);
                } else {
                    printTable(n);
                }
            } catch (Exception e) {
                byte n = readN();
                printTable(n);
            }
        } else {
            byte n = readN();
            printTable(n);
        }
    }

    private static byte readN() { //Ввод n с консоли.
        byte n;
        while (true) {
            System.out.println("Введите \"n\" и нажмите Enter:");
            if (sc.hasNextByte()) {
                n = sc.nextByte();
                if (n <= 0) {
                    System.out.println("\"n\" дожно быть целым положительным числом длинной не больше восьми бит!\n");
                    checkErr++;
                } else {
                    break;
                }
            } else {
                System.out.println("\"n\" дожно быть целым положительным числом длинной не больше восьми бит!\n");
                checkErr++;
                sc.next();
            }
            if (checkErr == 3) {
                System.out.println("Возможно вы не знаете, что такое целое положительное число длинной не больше восьми бит.\n" +
                        "Вам не нужна таблица умножения...");
                n = 0;
                break;
            }
        }
        return n;
    }

    private static void printTable(byte n) {
        if (n != 0) System.out.printf("Таблица умножения размером %dx%d:\n", n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", (i + 1) * (j + 1));
            }
            System.out.println();
        }
        if (n > 31) System.out.println("\nЗачем же такая большая!? Ничего же не разобрать!");
    }
}

