package CustomFoodshop.UserInterface;

import CustomFoodshop.Ingredients.Ingredient;
import CustomFoodshop.Meals.SingleItems.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static CustomFoodshop.UserInterface.ItemCreator.*;

public class ShopInterface {
    Scanner scanner = new Scanner(System.in);

    public static void customizeItem() {

    }

    public static SingleItem createCustomFood(Scanner scanner) {
        System.out.println("\n=== Create a New Item ===");
        System.out.println("1. Design Custom Burger");
        System.out.println("2. Design Custom Pizza");
        System.out.println("3. Design Custom Pasta Plate");
        System.out.print("Select a base culinary style: ");

        String choice = scanner.nextLine();
        SingleItem customFood = null;

        switch (choice) {
            case "1":
                customFood = createBurger(scanner);
                break;
            case "2":
                customFood = createPizza(scanner);
                break;
            case "3":
                customFood = createPasta(scanner);
                break;
            default:
                System.out.println("Invalid selection.");
                return null;
        }

        return customFood;
    }

    private static void addProteinOption(SingleItem singleItem) {
        System.out.println("\n[Protein selections]: 1. Burger Patty ($2.00) |" +
                " 2. Crispy Bacon ($1.20) | 3. Grilled Chicken ($1.75)");
    }


}
