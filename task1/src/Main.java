import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static double getCorrectNumber()
    {
        double elem = 0;
        boolean isIncorrect = true;

        do {
            isIncorrect = false;

            try {
                elem = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.err.print("Введите верное число: ");
            }
        } while (isIncorrect);

        return elem;
    }

    private static double sqr(double a)
    {
        return a*a;
    }

    private static double calculateFunc(double x, double y)
    {
        return (1 + sqr(Math.sin(x+y))) /
                (2 + Math.abs(x - 2*x / (1 + sqr(x*y)))) + x;
    }

    public static void main(String[] args) {
        System.out.print("Введите число x: ");
        double x = getCorrectNumber();

        System.out.print("Введите число y: ");
        double y = getCorrectNumber();

        System.out.println("Результат функции:" + calculateFunc(x,y));
        scanner.close();
    }
}