package CustomFoodshop.Ingredient.Protein;

import CustomFoodshop.Ingredient.Ingredient;

public abstract class Protein extends Ingredient {
    private enum CookLevel { RARE, MEDIUM_RARE, MEDIUM,
        MEDIUM_WELL, WELL_DONE, PRE_COOKED }
    private CookLevel cookLevel;
    private int proteinPerServing;

    public Protein(int caloriesPerServing, int servings, double pricePerServing,
                   boolean isSeasoned, boolean isSpicy, CookLevel cookLevel, int proteinPerServing) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.cookLevel = cookLevel;
        this.proteinPerServing = proteinPerServing;
    }

    public CookLevel CookLevel() {return this.cookLevel;}

    public void setCookLevel(CookLevel cookLevel) {this.cookLevel = cookLevel;}

    public int ProteinPerServing() {return this.proteinPerServing;}

    public void setProteinPerServing(int proteinPerServing) {this.proteinPerServing = proteinPerServing;}
}
