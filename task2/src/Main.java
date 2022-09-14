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

    private static boolean checkPoint(double x, double y)
    {
        final int LEFT_BORDER1 = -4, RIGHT_BORDER1 = 4, LEFT_BORDER2 = -6,RIGHT_BORDER2=6;
        final int UPPER_BORDER1 = 5, DOWN_BORDER1 = 0, DOWN_BORDER2 = -3, UPPER_BORDER2 = 0;

        if((x >= LEFT_BORDER1 && x <= RIGHT_BORDER1 && y >= DOWN_BORDER1 && y <= UPPER_BORDER1) ||
                (x >= LEFT_BORDER2 && x <= RIGHT_BORDER2 && y >= DOWN_BORDER2 && y <= UPPER_BORDER2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Введите координату х:");
        double x = getCorrectNumber();

        System.out.println("Введите координату y:");
        double y = getCorrectNumber();

        System.out.println( checkPoint(x,y)? "Да" : "Нет");
        scanner.close();
    }
}