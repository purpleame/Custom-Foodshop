package CustomFoodshop.Ingredients;

public class Toppings extends Ingredient {
    private enum ToppingType { SAUSAGE, PEPPERONI, CHEESE, BACON };
    private ToppingType toppingType;

    public Toppings(int caloriesPerServing, int servings, double pricePerServing,
                    boolean isSeasoned, boolean isSpicy) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
    }

    public ToppingType getToppingType() {return this.toppingType;}
    public void setToppingType(ToppingType toppingType) {this.toppingType = toppingType;}
}
