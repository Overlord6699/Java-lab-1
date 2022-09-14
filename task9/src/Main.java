import java.awt.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static Ball getNewBall()
    {
        System.out.println("Введите вес мяча: ");
        float weight = Float.parseFloat(scanner.nextLine());

        System.out.println(
            "Введите цвет мяча:\n" +
            "G - GREEN\n" +
            "R - RED\n" +
            "B - BLUE\n" +
            "Ваш выбор:"
        );

        String colorStr = scanner.nextLine();
        Color color = null;
        switch(colorStr)
        {
            case "R":
                color = Color.RED;
                break;
            case "G":
                color = Color.GREEN;
                break;
            case "B":
                color = Color.BLUE;
                break;
        }

        return new Ball(weight, color);
    }

    private static void outputMenu()
    {
        System.out.println(
                "Меню:\n" +
                        "1: Добавить мячик\n" +
                        "2: Удалить все мячики\n" +
                        "3: Посчитать вес корзины\n" +
                        "4: Посчитать кол-во мячей нужного цвета\n" +
                        "5: Убрать последний мяч из корзины\n" +
                        "0 : Выход из программы\n"
        );
    }

    private  static void processUserChoice(Busket busket)
    {
        String ans;

        outputMenu();

        do {
            System.out.println("Введите ваш выбор:");
            ans = scanner.nextLine();

            switch (ans) {
                case "1":
                    busket.add(getNewBall());
                    break;
                case "2":
                    System.out.println("Корзина пустая");
                    busket.clear();
                    break;
                case "3":
                    System.out.println("Суммарная масса корзины: " + busket.calculateWeight());
                    break;
                case "4":
                    System.out.println("Было найдено " + busket.calculateBallByColor(Color.blue) + " мячей синего цвета ");
                    break;
                case "5":
                    busket.pop();
                    break;
                case "0":
                    break;

            }
        }while (!ans.equals("0"));
    }

    public static void main(String[] args) {
        Busket busket = new Busket();

        String ans;

        System.out.println("Заполнить корзину автоматически? Y или N");
        ans = scanner.nextLine();
        if(ans.equals("Y")){
            busket.add(new Ball(0.5f, Color.blue));
            busket.add(new Ball(0.1f, Color.red));
            busket.add(new Ball(0.8f, Color.blue));
            busket.add(new Ball(1.8f, Color.blue));
            busket.add(new Ball(0.2f, Color.green));
        }

        processUserChoice(busket);

        scanner.close();
    }
}