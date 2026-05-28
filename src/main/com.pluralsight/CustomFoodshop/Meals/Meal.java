package CustomFoodshop.Meals;

import CustomFoodshop.Ingredients.Ingredient;
import java.util.List;

public interface Meal {
    double calculateTotalPrice();
    double calculateTotalCalories();
    List<Ingredient> getIngredientList();

}