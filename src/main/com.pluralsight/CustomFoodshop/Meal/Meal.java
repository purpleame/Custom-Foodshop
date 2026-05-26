package CustomFoodshop.Meal;

import CustomFoodshop.Ingredients.Ingredient;
import java.util.List;

public interface Meal {
    double calculateTotalPrice(double totalPrice);
    double calculateTotalCalories();
    List<Ingredient> getIngredientList();
}