import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void insertArray(int [] array1, int [] array2) {
        for (int i = 0; i < array1.length; i++) {
            boolean isBiggestNum = true;

            for (int j = 0; j < array2.length; j++) {
                if (array1[i] < array2[j]) {
                    System.out.printf("%d елемент массива b вставить до %d элем. массива а\n", i, j);
                    isBiggestNum = false;
                    break;
                }
            }
            if (isBiggestNum)
                System.out.printf("%d елемент массива b вставить после последенго элем. массива а\n", i);
        }
    }

    private static int getCorrectNumber()
    {
        int elem = 0;
        boolean isIncorrect = true;

        do {
            isIncorrect = false;

            try {
                elem = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                isIncorrect = true;
                System.err.print("Введите верное число: ");
            }
        } while (isIncorrect);

        return elem;
    }

    private static void readArr(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print("Заполните элемент " + i + " :");
            arr[i] = getCorrectNumber();
        }
    }

    private static void processUserInput(int[] arr)
    {
        System.out.println("Вы хотите ввести данные самостоятельно?Y или N");
        String ans = scanner.nextLine();

        if(ans.equals("Y")) {
            System.out.println("Введите размер массива: ");
            int size = getCorrectNumber();
            arr = new int[size];

            System.out.println("Введите массив по элементам: ");
            readArr(arr);
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,3,5,9};
        int[] b = new int[]{0,2,4,6,7};

        System.out.println("Массив а: ");
        processUserInput(a);

        System.out.println("Массив b: ");
        processUserInput(b);

        insertArray(b, a);
    }
}