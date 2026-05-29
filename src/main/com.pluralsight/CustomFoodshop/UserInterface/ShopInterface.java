package CustomFoodshop.UserInterface;

import CustomFoodshop.Ingredients.Proteins.Protein;
import CustomFoodshop.Meals.SingleItems.*;
import CustomFoodshop.Ingredients.*;
import CustomFoodshop.OrderSystem.OrderManager;
import CustomFoodshop.Orders.PendingOrder;
import CustomFoodshop.Orders.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static CustomFoodshop.Ingredients.Condiments.Condiment.createKetchup;
import static CustomFoodshop.Ingredients.Condiments.Condiment.createRanchCup;
import static CustomFoodshop.UserInterface.ItemCreator.*;

public class ShopInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderManager orderManager = new OrderManager();
    private static int ticketCounter = 1;

    public static void runShopLoop() {
        boolean running = true;

        while (running) {
            System.out.println("\n==================================");
            System.out.println("   CUSTOM FOOD SHOP ORDER TERMINAL  ");
            System.out.println("==================================");
            System.out.println("1. Create New Custom Food Item");
            System.out.println("2. View Current Active Orders");
            System.out.println("3. Shut Down Terminal");
            System.out.print("Select an operation: ");

            String mainChoice = scanner.nextLine();
            switch (mainChoice) {
                case "1" -> {
                    SingleItem newlyCreatedFood = createCustomFood(scanner);

                    if (newlyCreatedFood != null) {
                        addExtraToppings(scanner, newlyCreatedFood);

                        PendingOrder customerOrder = new PendingOrder(
                                "TICKET_" + String.format("%03d", ticketCounter++),
                                Order.OrderType.COMBO,
                                new ArrayList<>(java.util.List.of(newlyCreatedFood)),
                                LocalDateTime.now(),
                                PendingOrder.OrderStatus.IN_PROGRESS
                        );

                        orderManager.addOrder(customerOrder.getOrderId(), customerOrder);
                        System.out.println("\n Success: Sent " + newlyCreatedFood.getName() + " to " + customerOrder.getOrderId());
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

    private static void addExtraToppings(Scanner scanner, SingleItem singleItem) {
        boolean adding = true;

        while (adding) {
            System.out.println("\n--- Add Extra Toppings to: " + singleItem.getName() + " ---");
            System.out.println("1. Add Bacon Slice");
            System.out.println("2. Add Burger Patty");
            System.out.println("3. Add Ketchup Packet");
            System.out.println("4. Add Ranch Cup");
            System.out.println("5. Done Adding Toppings");
            System.out.print("Select choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    singleItem.addIngredient(Protein.createCrispyBacon(1));
                    System.out.println("Bacon added.");
                }
                case "2" -> {
                    singleItem.addIngredient(Protein.createBurgerPatty(1, Protein.CookLevel.MEDIUM));
                    System.out.println("Extra patty added.");
                }
                case "3" -> {
                    singleItem.addIngredient(createKetchup(1, false));
                    System.out.println("Ketchup added.");
                }
                case "4" -> {
                    singleItem.addIngredient(createRanchCup(1));
                    System.out.println("Ranch added.");
                }
                case "5" -> adding = false;
                default -> System.out.println("Invalid selection.");
            }
        }
    }
}
