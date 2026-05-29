package CustomFoodshop.Meals.SingleItems;

import CustomFoodshop.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Pasta extends SingleItem {
    public enum PastaMealType { CHICKEN_ALFREDO, BACON_CHEESE, REGULAR };
    private PastaMealType mealType;
    public enum PastaMealSize { SM, MED, LRG };
    private PastaMealSize size;
    private boolean hasBreadBowl;

    public Pasta(String name, double totalPrice, List<Ingredient> ingredients,
                 PastaMealType mealType, PastaMealSize size, boolean hasBreadBowl) {
        super(name, totalPrice, ingredients);
        this.mealType = mealType;
        this.size = size;
        this.hasBreadBowl = hasBreadBowl;
    }

    public PastaMealType getMealType() {return this.mealType;}
    public void setMealType(PastaMealType mealType) {this.mealType = mealType;}
    public PastaMealSize getSize() {return this.size;}
    public void setSize(PastaMealSize size) {this.size = size;}
    public boolean getHasBreadBowl() {return this.hasBreadBowl;}
    public void setHasBreadBowl(boolean hasBreadBowl) {this.hasBreadBowl = hasBreadBowl;}

    public static Pasta createPasta() {
        return new Pasta("Pasta", 11.50, new ArrayList<>(),
                Pasta.PastaMealType.REGULAR, Pasta.PastaMealSize.MED, false);
    }
}
