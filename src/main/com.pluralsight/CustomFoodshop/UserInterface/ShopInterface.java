package CustomFoodshop.UserInterface;

import CustomFoodshop.Ingredients.Proteins.Protein;
import CustomFoodshop.Meals.ComboMeals.ComboMeal;
import CustomFoodshop.Meals.Meal;
import CustomFoodshop.Meals.SingleItems.*;
import CustomFoodshop.Ingredients.*;
import CustomFoodshop.OrderSystem.OrderManager;
import CustomFoodshop.Orders.PendingOrder;
import CustomFoodshop.Ingredients.Toppings;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static CustomFoodshop.Ingredients.Condiments.Condiment.createKetchup;
import static CustomFoodshop.Ingredients.Condiments.Condiment.createRanchCup;
import static CustomFoodshop.OrderSystem.ReceiptFileManager.saveReceipt;
import static CustomFoodshop.UserInterface.ItemCreator.*;

public class ShopInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderManager orderManager = new OrderManager();
    private static int ticketCounter = 1;

    public static void runShopLoop() {
        boolean running = true;

        while (running) {

            System.out.println("\n   CUSTOM FOODSHOP ORDER TERMINAL  ");
            System.out.println("                                     ");
            System.out.println("1. Create New Custom Food Item");
            System.out.println("2. View Current Active Orders");
            System.out.println("3. Bundle a New Combo Meal Bundle");
            System.out.println("4. Shut Down Terminal");
            System.out.print("Select an operation: ");

            String mainChoice = scanner.nextLine();
            switch (mainChoice) {
                case "1" -> {
                    SingleItem newlyCreatedFood = createCustomFood(scanner);

                    if (newlyCreatedFood != null) {
                        addExtraToppings(scanner, newlyCreatedFood);

                        PendingOrder customerOrder = new PendingOrder(
                                "TICKET_" + String.format("%03d", ticketCounter++),
                                null,
                                new ArrayList<>(java.util.List.of(newlyCreatedFood)),
                                LocalDateTime.now(),
                                null
                        );

                        orderManager.addOrder(customerOrder.getOrderId(), customerOrder);
                        System.out.println("\n Success: Sent " + newlyCreatedFood.getName() + " to " + customerOrder.getOrderId());
                        printOrderDetailsReceipt(customerOrder);
                        saveReceipt(customerOrder);
                    }
                }
                case "2" -> {
                    System.out.println("\n--- In-Progress Queue ---");
                    var items = orderManager.getOrdersByStatus(PendingOrder::isInProgress);
                    if (items.isEmpty()) {
                        System.out.println("(No pending orders found)");
                    } else {
                        items.forEach(order -> System.out.println("Order ID: " + order.getOrderId() +
                                " | Timestamp: " + order.getTimestamp()));
                    }
                }
                case "3" -> {
                    ComboMeal bundleMeal = ComboMeal.createComboMeal(scanner);

                    if (bundleMeal != null) {
                        packComboBundle(scanner, bundleMeal);

                        PendingOrder customerOrder = new PendingOrder(
                                "TICKET_" + String.format("%03d", ticketCounter++),
                                null,
                                new ArrayList<>(java.util.List.of(bundleMeal)),
                                LocalDateTime.now(),
                                null
                        );

                        orderManager.addOrder(customerOrder.getOrderId(), customerOrder);
                        System.out.println("\n✓ Success: Sent Bundle Deal [" + bundleMeal.getName() + "] to " + customerOrder.getOrderId());
                        printOrderDetailsReceipt(customerOrder);
                        saveReceipt(customerOrder);
                    }
                }
                case "4" -> {
                    running = false;
                    System.out.println("Terminal shutting down. Goodbye!");
                }
                default -> System.out.println("Invalid selection option. Try again.");
            }
        }
    }

    public static SingleItem createCustomFood(Scanner scanner) {
        System.out.println("\n=== Create a New Item ===");
        System.out.println("1. Design Custom Burger");
        System.out.println("2. Design Custom Pizza");
        System.out.println("3. Design Custom Pasta Plate");
        System.out.println("4. Add Drink");
        System.out.println("5. Add Fries");
        System.out.println("6. Add Cheesecake");
        System.out.print("Select a choice: ");

        String choice = scanner.nextLine();
        SingleItem customFood = null;

        switch (choice) {
            case "1" -> customFood = createBurger(scanner);
            case "2" -> customFood = createPizza(scanner);
            case "3" -> customFood = createPasta(scanner);
            case "4" -> customFood = createFountainSoda(scanner);
            case "5" -> customFood = createFrenchFries(scanner);
            case "6" -> customFood = createCheesecake(scanner);
            default -> {
                System.out.println("Invalid selection.");
                return null;
            }
        }

        return customFood;
    }

    private static void addExtraToppings(Scanner scanner, SingleItem singleItem) {
        boolean adding = true;

        while (adding) {
            System.out.println("\n--- Add Extra Toppings to: " + singleItem.getName() + " ---");
            System.out.println("1. Add Bacon Slice");
            System.out.println("2. Add Extra Cheese");
            System.out.println("3. Add Sausage");
            System.out.println("4. Add Pepperoni");
            System.out.println("5. Done Adding Toppings");
            System.out.print("Select choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    singleItem.addIngredient(Protein.createCrispyBacon(1));
                    System.out.println("Bacon added.");
                }
                case "2" -> {
                    singleItem.addIngredient(new Toppings(50, 1, 0.50,
                            false, false));
                    System.out.println("Extra cheese added.");
                }
                case "3" -> {
                    singleItem.addIngredient(new Toppings(100, 1, 1,
                            true, true));
                    System.out.println("Sausage added.");
                }
                case "4" -> {
                    singleItem.addIngredient(new Toppings(80, 1, 2,
                            true, true));
                    System.out.println("Pepperoni added.");
                }
                case "5" -> adding = false;
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    private static void packComboBundle(Scanner scanner, ComboMeal combo) {
        boolean assemblingBundle = true;

        while (assemblingBundle) {
            System.out.println("\n--- Building Bundle: [" + combo.getName() + "] ---");
            System.out.println("Current Bundle Item Quantity: " + combo.getItems().size());
            System.out.println("1. Pack a new Custom Single Food Item into this Combo Bundle");
            System.out.println("2. Save Bundle & Finish Checkout Process");
            System.out.print("Select action: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    SingleItem dynamicFoodComponent = createCustomFood(scanner);
                    if (dynamicFoodComponent != null) {
                        addExtraToppings(scanner, dynamicFoodComponent);
                        combo.getItems().add(dynamicFoodComponent);
                        System.out.println("Success: Added " + dynamicFoodComponent.getName() + " to " + combo.getName());
                    }
                }
                case "2" -> {
                    if (combo.getItems().isEmpty()) {
                        System.out.println("A bundle cannot be saved completely empty. Please add at least 1 item.");
                    } else {
                        assemblingBundle = false;
                    }
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }
    }

    private static void printOrderDetailsReceipt(PendingOrder order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Time:     " + order.getTimestamp());
        System.out.println("ITEMS ORDERED:");

        for (Meal meal : order.getOrderedItems()) {
            System.out.printf("- %s (Base: $%.2f)\n", meal.getName(), meal.calculateTotalPrice());

            var toppings = meal.getIngredientList();
            if (toppings.isEmpty()) {
                System.out.println("    (No extra toppings added)");
            } else {
                System.out.println("    Toppings/Ingredients:");
                for (Ingredient topping : toppings) {
                    System.out.println("     + " + topping.getClass().getSimpleName());
                }
            }
        }
        System.out.printf("TOTAL ORDER COST: $%.2f\n", order.calculateSubtotal());
    }

}
