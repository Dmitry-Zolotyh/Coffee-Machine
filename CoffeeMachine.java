import java.util.Scanner;

public class CoffeeMachine {
    //Starting values
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int disposableCups = 9;
    public static int money = 550;

    public static void main(String[] args) {
        while (true) {
            boolean run = true;
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            scanner.close();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printMachineState();
                    break;
                case "exit":
                    run = false;
                    break;
            }
            if (!run) break;
        }
    }

    public static void printMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        scanner.close();
        if ("back".equals(userInput))
            return;
        int coffeeType = Integer.parseInt(userInput);
        if (isEnoughIngredients(coffeeType)) {
            switch (coffeeType) {
                case 1:
                    water -= 250;
                    beans -= 16;
                    disposableCups -= 1;
                    money += 4;
                    break;
                case 2:
                    water -= 350;
                    beans -= 20;
                    milk -= 75;
                    disposableCups -= 1;
                    money += 7;
                    break;
                case 3:
                    water -= 200;
                    beans -= 12;
                    milk -= 100;
                    disposableCups -= 1;
                    money += 6;
                    break;
            }
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCups += scanner.nextInt();
        scanner.close();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static boolean isEnoughIngredients(int coffeeType) {
        if (water < 250 && coffeeType == 1 || water < 350 && coffeeType == 2 || water < 200 && coffeeType == 3) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < 75 && coffeeType == 2 || milk < 100 && coffeeType == 3) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans < 16 && coffeeType == 1 || beans < 20 && coffeeType == 2 || beans < 12 && coffeeType == 3) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        return disposableCups > 0;
    }
}