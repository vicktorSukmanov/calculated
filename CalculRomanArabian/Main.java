package CalculRomanArabian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int operand1, operand2;
    static char operation;
    static int resault;

    public static void main(String[] arg) throws Exception {
        System.out.println("Введите выражение состоящие из двух арабских или римских чисел от 1 до 10 (Например:2+2,V-III)");
        String userIn = scanner.nextLine();
        char[] character = new char[10];
        for (int i = 0; i < userIn.length(); i++) {
            character[i] = userIn.charAt(i);
            if (character[i] == '+') {
                operation = '+';
            }
            if (character[i] == '-') {
                operation = '-';
            }
            if (character[i] == '*') {
                operation = '*';
            }
            if (character[i] == '/') {
                operation = '/';
            }
        }

        String characterString = String.valueOf(character);
        String[] block = characterString.split("[+-/*]");
        if (block.length != 2) throw new Exception("Должно быть два операнда и одна опрация(+,-,*,/)");
        String value01 = block[0];
        String value02 = block[1];
        String value03 = value02.trim();

        if (isRoman(String.valueOf(value01)) && isRoman(String.valueOf(value03))) {

            operand1 = romanArabian(value01);
            operand2 = romanArabian(value03);

            if (operand1 >= 1 && operand1 <= 10 && operand2 >= 1 && operand2 <= 10) {
                resault = calculated(operand1, operand2, operation);

                if (resault <= 0) {
                    System.out.println("Ошибка: в римской системе счисления нет отрицательных чисел");
                } else {
                    System.out.println(Roman.getRoman(resault));
                }

            } else {
                System.out.println("Ошибка: необходимо вводить число от 1 до 10");
            }


        } else if (!isRoman(String.valueOf(value01)) && !isRoman(String.valueOf(value03))) {
            operand1 = Integer.parseInt(value01);
            operand2 = Integer.parseInt(value03);

            if (operand1 >= 1 && operand1 <= 10 && operand2 >= 1 && operand2 <= 10) {
                resault = calculated(operand1, operand2, operation);
                System.out.println(resault);
            } else {
                System.out.println("Ошибка: необходимо вводить число от 1 до 10");
            }
        } else {
            System.out.println("Вводи числа в одной системе счисления");
        }
    }


    public static int romanArabian(String roman) {
        try {
            switch (roman) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return 0;
    }

    private static int calculated(int num1, int num2, char op) {
        int resault = 0;
        switch (op) {
            case '+':
                resault = num1 + num2;
                break;
            case '-':
                resault = num1 - num2;
                break;
            case '*':
                resault = num1 * num2;
                break;
            case '/':
                try {
                    resault = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception:" + e);
                    System.out.println("Деление на ноль");
                    break;
                }

        }
        return resault;
    }


    public static boolean isRoman(String value) {

        try {
            Roman.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    }
