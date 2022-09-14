import java.util.Scanner;

public class Main {
    private  static Scanner scanner = new Scanner(System.in);

    private static int findMaxSubArrLength(int[] a)
    {
        int n = a.length;
        int[] d = new int[n];

        for (int i=0; i<n; ++i) {
            d[i] = 1;
            for (int j=0; j<i; ++j)
                if (a[j] < a[i])
                    d[i] = Math.max(d[i], 1 + d[j]);
        }

        int ans = d[0];
        for (int i=0; i<n; ++i)
            ans = Math.max (ans, d[i]);

        return ans;
    }

    private static int[] transformMatrix(int[][] matrix)
    {
        int[] temp = new int[matrix.length * matrix[0].length];
        int index = 0;

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                temp[index] = matrix[i][j];
                index++;
            }


        return temp;
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

    private static void readMatrix(int[][] mat)
    {
        for(int i = 0; i < mat.length; i++) {
            System.out.println("Строка " + i + " :");
            readArr(mat[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,8,6},
                {7,8,9},
        };

        System.out.println("Вы хотите ввести данные самостоятельно?Y или N");
        String ans = scanner.nextLine();

        if(ans.equals("Y")) {
            System.out.println("Введите размер матрицы: ");
            int size = getCorrectNumber();
            matrix = new int[size][size];

            System.out.println("Введите матрицу по элементам: ");
            readMatrix(matrix);
        }

        int[] arr = transformMatrix(matrix);
        int len = findMaxSubArrLength(arr);
        System.out.print("Нужно  удалить " + (arr.length - len) + " элементов");

        scanner.close();
    }
}