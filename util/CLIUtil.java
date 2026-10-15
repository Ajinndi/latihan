package util;

import java.util.Scanner;
import exception.EmptyInputException;
import exception.InvalidNumberException;

public class CLIUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine() throws EmptyInputException {
        String input = scanner.nextLine();

        if (input.equals("")) {
            throw new EmptyInputException("Input tidak boleh kosong.");
        }

        return input;
    }

    public static int readInt() throws EmptyInputException, InvalidNumberException {
        String input = scanner.nextLine();

        if (input.equals("")) {
            throw new EmptyInputException("Input tidak boleh kosong.");
        }

        Scanner pembaca = new Scanner(input);

        if (pembaca.hasNextInt()) {
            int angka = pembaca.nextInt();

            if (!pembaca.hasNext()) {
                pembaca.close();
                return angka;
            }
        }

        pembaca.close();
        throw new InvalidNumberException("Input harus berupa angka bulat.");
    }

    public static double readDouble() throws EmptyInputException, InvalidNumberException {
        String input = scanner.nextLine();

        if (input.equals("")) {
            throw new EmptyInputException("Input tidak boleh kosong.");
        }

        Scanner pembaca = new Scanner(input);

        if (pembaca.hasNextDouble()) {
            double angka = pembaca.nextDouble();

            if (!pembaca.hasNext()) {
                pembaca.close();
                return angka;
            }
        }

        pembaca.close();
        throw new InvalidNumberException("Input harus berupa angka.");
    }

    public static void close() {
        scanner.close();
    }
}