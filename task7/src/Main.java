import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void shellSort(int n, int arr[])
    {
        int i, j, step;
        int temp;
        for (step = n / 2; step > 0; step /= 2)
            for (i = step; i < n; i++)
            {
                temp = arr[i];

                for (j = i; j >= step; j -= step)
                {
                    if (temp < arr[j - step])
                        arr[j] = arr[j - step];
                    else
                        break;
                }
                arr[j] = temp;
            }
    }

    private static void outputArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
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
        int[] arr = {1,5,0,4,8};

        System.out.println("Вы хотите ввести данные самостоятельно?Y или N");
        String ans = scanner.nextLine();

        if(ans.equals("Y")) {
            System.out.println("Введите размер массива: ");
            int size = getCorrectNumber();
            arr = new int[size];

            System.out.println("Введите массив по элементам: ");
            readArr(arr);
        }

        shellSort(arr.length, arr);
        outputArray(arr);

        scanner.close();
    }
}