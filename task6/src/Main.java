import java.util.Scanner;

public class Main {

    private  static Scanner scanner = new Scanner(System.in);

    private static int[][] createMatrix(int[] arr)
    {
        int n = arr.length;
        int[][] matrix = new int[n][n];
        int shift = 0;

        for(int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = arr[(j+shift)%n];
            shift++;
        }

        return matrix;
    }

    private static void outputMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println("Вы хотите ввести данные самостоятельно?Y или N");
        String ans = scanner.nextLine();

        if(ans.equals("Y")) {
            System.out.println("Введите размер массива: ");
            int size = getCorrectNumber();
            arr = new int[size];

            System.out.println("Введите массив по элементам: ");
            readArr(arr);
        }

        outputMatrix(createMatrix(arr));

        scanner.close();
    }
}