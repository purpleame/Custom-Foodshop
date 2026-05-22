package CustomFoodshop.Ingredient;

public class Toppings extends Ingredient {
    private enum ToppingType { SAUSAGE, PEPPERONI, CHEESE, BACON };
    private ToppingType toppingType;

    public Toppings(int caloriesPerServing, int servings, double pricePerServing,
                    boolean isSeasoned, boolean isSpicy, ToppingType toppingType) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.toppingType = toppingType;
    }

    public ToppingType ToppingType() {return this.toppingType;}

    public void setToppingType(ToppingType toppingType) {this.toppingType = toppingType;}
}
