package CustomFoodshop.Meal;

import CustomFoodshop.Ingredient.Ingredient;
import java.util.List;

public interface Meal {
    double calculateTotalPrice();
    double calculateTotalCalories();
    List<Ingredient> getIngredientList();
}