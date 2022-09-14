import java.util.Scanner;

public class Main {
    private  static Scanner scanner = new Scanner(System.in);

    static final int TABLE_LENGTH = 11;
    static final int TABLE_CELL_LENGTH = 4;




    private static void drawSymbols(char sym,int startPos, int length)
    {
        for(int i = startPos; i < length; i++)
        {
            System.out.print(sym);
        }
    }

    private static void drawHeader(int tableLength, int numberLength)
    {
        drawSymbols('-',0,tableLength);
        System.out.println();

        System.out.print("|");
        drawSymbols(' ',0,(numberLength-1)/2);
        System.out.print("X");
        drawSymbols(' ', (numberLength-1)/2,numberLength-1);
        System.out.print("|");


        drawSymbols(' ', 0,(numberLength-4)/2);
        System.out.print("F(x)");
        drawSymbols(' ', (numberLength-4)/2,numberLength-4);
        System.out.println("|");

        drawSymbols('-', 0,tableLength);
        System.out.println();
    }

    private static int calcNumLength(double a)
    {
        int numberLength = 1;
        double temp = a;
        while(temp >= 10)
        {
            temp /= 10;
            numberLength++;
        }

        return numberLength;
    }

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


    private static void processFuncTable(double a, double b, double h)
    {
        int numberLength = calcNumLength(b);

        if(numberLength < TABLE_CELL_LENGTH)
            numberLength  = TABLE_CELL_LENGTH;

        int tableLength = numberLength * 2 + 3;

        drawHeader(tableLength, numberLength);


        while(a <= b)
        {
            System.out.print("|");
            System.out.print(a);
            System.out.print(" |");

            double y = Math.tan(a);

            System.out.printf("%.2f",y);
            System.out.println("|");
            drawSymbols('-', 0,tableLength);
            System.out.println();

            a += h;
        }
    }

    public static void main(String[] args) {
        System.out.print("Введите а: ");
        double a = getCorrectNumber();

        System.out.print("Введите b: ");
        double b = getCorrectNumber();

        System.out.print("Введите шаг h: ");
        double h = getCorrectNumber();

        processFuncTable(a, b, h);
        scanner.close();
    }
}