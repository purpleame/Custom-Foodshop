package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.List;

public class Burger extends SingleItem {
    public enum BunType { BRIOCHE, SESAME };
    private BunType bunType;
    private boolean isDoublePatty;

    public Burger(String name, double totalPrice, List<Ingredient> ingredients,
                  BunType bunType, boolean isDoublePatty) {
        super(name, totalPrice, ingredients);
        this.bunType = bunType;
        this.isDoublePatty = isDoublePatty;
    }

    public BunType getBunType() {return this.bunType;}
    public void setBunType(BunType bunType) {this.bunType = bunType;}
    public boolean getDoublePatty() {return this.isDoublePatty;}
    public void setIsDoublePatty(boolean isDoublePatty) {this.isDoublePatty = isDoublePatty;}

}
