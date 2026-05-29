package CustomFoodshop.OrderSystem;

import CustomFoodshop.Meals.Meal;
import CustomFoodshop.Orders.PendingOrder;
import CustomFoodshop.Ingredients.Ingredient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class ReceiptFileManager {

    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    public static void saveReceipt(PendingOrder order) {
        String fileName = order.getTimestamp().format(FILE_NAME_FORMATTER) + ".csv";

        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        File receiptFile = new File(directory, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            writer.write("Record Type|ID/Name|Detail/Topping|Price/Total\n");

            writer.write("ORDER|" + order.getOrderId() + "|" + order.getTimestamp() + "|\n");

            for (Meal meal : order.getOrderedItems()) {
                writer.write("ITEM|" + meal.getName() + "||" + String.format("%.2f", meal.calculateTotalPrice()) + "\n");

                var toppings = meal.getIngredientList();
                for (Ingredient topping : toppings) {
                    writer.write("TOPPING||" + topping.getClass().getSimpleName() + "|\n");
                }
            }

            writer.write("TOTAL||| " + String.format("%.2f", order.calculateSubtotal()) + "\n");

            System.out.println(": Pipe-Delimited Receipt saved to directory: receipts/" + fileName);

        } catch (IOException e) {
            System.out.println("Error: Failed to save receipt CSV file: " + e.getMessage());
        }
    }
}
