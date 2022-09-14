import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean checkPrimaryArr(int[] arr)
    {
        boolean isFound = false;

        System.out.println("Индексы простых элементов:");

        for(int i = 0; i < arr.length; i++)
            if(checkPrimary(arr[i])) {
                System.out.print(i + " ");
                isFound = true;
            }

        return isFound;
    }

    private static boolean checkPrimary(int n)
    {
        if(n==1)
            return false;

        BigInteger big = BigInteger.valueOf(n);
        return big.isProbablePrime((int)Math.log(n));
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
        int arr[] = {1, 8, 4, 6, 4};
        int size = 0;

        System.out.println("Вы хотели бы ввести данные? Y или N");
        String ans = scanner.nextLine();

        if(ans.equals("Y")) {
            System.out.print("Введите размер: ");
            size = getCorrectNumber();
            arr = new int[size];

            System.out.println("Заполните массив поэлементо.");
            readArr(arr);
        }

        if(!checkPrimaryArr(arr))
            System.out.print("Нет простых элементов");

        scanner.close();
    }
}