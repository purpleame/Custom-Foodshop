package CustomFoodshop.Ingredient.Condiment;

import CustomFoodshop.Ingredient.Ingredient;

public abstract class Condiment extends Ingredient {
    private enum CondimentForm {LIQUID, POWDER, PASTE};
    private CondimentForm condimentForm;
    private enum ServingStyle {PACKET, CUP, DRIZZLED};
    private ServingStyle servingStyle;
    private double maxFreeServings;
    private boolean isOnSide;

    public Condiment(int caloriesPerServing, int servings, double pricePerServing,
                     boolean isSeasoned, boolean isSpicy, CondimentForm condimentForm,
                     ServingStyle servingStyle, double maxFreeServings, boolean isOnSide) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.condimentForm = condimentForm;
        this.servingStyle = servingStyle;
        this.maxFreeServings = maxFreeServings;
        this.isOnSide = isOnSide;
    }
}
