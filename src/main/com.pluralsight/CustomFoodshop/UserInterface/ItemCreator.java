package CustomFoodshop.UserInterface;

import CustomFoodshop.Ingredients.Ingredient;
import CustomFoodshop.Meals.SingleItems.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemCreator {
    public static Burger createBurger(Scanner scanner) {
        String name;
        double totalPrice;
        List<Ingredient> ingredients;
        Burger.BunType bunType;
        boolean isDoublePatty;

        System.out.print("Enter base price: ");
        try {
            totalPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            totalPrice = 5.99;
        }

        ingredients = new ArrayList<>();

        System.out.println("Select Bun Type: 1. BRIOCHE | 2. SESAME");
        String bunChoice = scanner.nextLine();
        bunType = "2".equals(bunChoice) ? Burger.BunType.SESAME : Burger.BunType.BRIOCHE;

        System.out.print("Is this a double patty? (true/false): ");
        try {
            isDoublePatty = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            isDoublePatty = false;
        }

        name = bunType.name() + " Burger";

        return new Burger(name, totalPrice, ingredients, bunType, isDoublePatty);
    }

    public static Cheesecake createCheesecake(Scanner scanner) {
        String name;
        double totalPrice;
        java.util.List<Ingredient> ingredients;
        Cheesecake.CakeSize size;

        System.out.print("Enter base price: ");
        try {
            totalPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            totalPrice = 4.50;
        }


        ingredients = new java.util.ArrayList<>();

        System.out.println("Select Cake Size: 1. SM | 2. MED | 3. LRG");
        String sizeChoice = scanner.nextLine();
        size = switch (sizeChoice) {
            case "1" -> Cheesecake.CakeSize.SM;
            case "3" -> Cheesecake.CakeSize.LRG;
            default -> Cheesecake.CakeSize.MED;
        };

        name = size.name() + " Cheesecake";

        return new Cheesecake(name, totalPrice, ingredients, size);
    }

    public static Drink createFountainSoda(Scanner scanner) {
        String name;
        double totalPrice;
        java.util.List<Ingredient> ingredients;
        Drink.DrinkSize size;
        boolean hasIce;

        System.out.println("Select Drink Size: 1. SM ($1.99) | 2. MED ($2.49) | 3. LRG ($2.99)");
        String sizeChoice = scanner.nextLine();
        size = switch (sizeChoice) {
            case "1" -> Drink.DrinkSize.SM;
            case "3" -> Drink.DrinkSize.LRG;
            default -> Drink.DrinkSize.MED;
        };

        totalPrice = switch (size) {
            case SM -> 1.99;
            case LRG -> 2.99;
            case MED -> 2.49;
        };

        name = size.name() + " Soda";

        ingredients = new java.util.ArrayList<>();

        System.out.print("Include ice? (true/false): ");
        try {
            hasIce = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            hasIce = true;
        }

        return new Drink(name, totalPrice, ingredients, size, hasIce);
    }

    public static Fries createFrenchFries(Scanner scanner) {
        String name;
        double totalPrice;
        java.util.List<CustomFoodshop.Ingredients.Ingredient> ingredients;
        Fries.FriesSize size;

        System.out.println("Select Fries Size: 1. SM ($1.75) | 2. MED ($2.25) | 3. LRG ($2.75)");
        String sizeChoice = scanner.nextLine();
        size = switch (sizeChoice) {
            case "1" -> Fries.FriesSize.SM;
            case "3" -> Fries.FriesSize.LRG;
            default -> Fries.FriesSize.MED;
        };

        totalPrice = switch (size) {
            case SM -> 1.75;
            case LRG -> 2.75;
            case MED -> 2.25;
        };

        name = size.name() + " Fries";

        ingredients = new java.util.ArrayList<>();

        return new Fries(name, totalPrice, ingredients, size);
    }

    public static Pasta createPasta(Scanner scanner) {
        String name;
        double totalPrice;
        java.util.List<CustomFoodshop.Ingredients.Ingredient> ingredients;
        Pasta.PastaMealType mealType;
        Pasta.PastaMealSize size;
        boolean hasBreadBowl;

        System.out.println("Select Pasta Type: 1. CHICKEN_ALFREDO | 2. BACON_CHEESE | 3. REGULAR");
        String typeChoice = scanner.nextLine();
        mealType = switch (typeChoice) {
            case "1" -> Pasta.PastaMealType.CHICKEN_ALFREDO;
            case "2" -> Pasta.PastaMealType.BACON_CHEESE;
            default -> Pasta.PastaMealType.REGULAR;
        };

        System.out.println("Select Pasta Size: 1. SM ($9.50) | 2. MED ($11.50) | 3. LRG ($13.50)");
        String sizeChoice = scanner.nextLine();
        size = switch (sizeChoice) {
            case "1" -> Pasta.PastaMealSize.SM;
            case "3" -> Pasta.PastaMealSize.LRG;
            default -> Pasta.PastaMealSize.MED;
        };

        totalPrice = switch (size) {
            case SM -> 9.50;
            case LRG -> 13.50;
            case MED -> 11.50;
        };

        name = mealType.name() + " Pasta";

        ingredients = new java.util.ArrayList<>();

        System.out.print("Include bread bowl? (true/false): ");
        try {
            hasBreadBowl = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            hasBreadBowl = false;
        }

        if (hasBreadBowl) {
            totalPrice += 2.00;
        }

        return new Pasta(name, totalPrice, ingredients, mealType, size, hasBreadBowl);
    }

    public static Pizza createPizza(Scanner scanner) {
        String name;
        double totalPrice;
        java.util.List<CustomFoodshop.Ingredients.Ingredient> ingredients;
        Pizza.PizzaSize size;
        boolean hasStuffedCrust;


        System.out.println("Select Pizza Size: 1. SM ($6.99) | 2. MED ($9.99) | 3. LRG ($13.99)");
        String sizeChoice = scanner.nextLine();
        size = switch (sizeChoice) {
            case "1" -> Pizza.PizzaSize.SM;
            case "3" -> Pizza.PizzaSize.LRG;
            default -> Pizza.PizzaSize.MED;
        };

        totalPrice = switch (size) {
            case SM -> 6.99;
            case LRG -> 13.99;
            case MED -> 9.99;
        };

        name = size.name() + " Pizza";

        ingredients = new java.util.ArrayList<>();

        System.out.print("Include stuffed crust? (true/false): ");
        try {
            hasStuffedCrust = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            hasStuffedCrust = false;
        }

        if (hasStuffedCrust) {
            totalPrice += 2.00;
        }

        return new Pizza(name, totalPrice, ingredients, size, hasStuffedCrust);
    }

}
