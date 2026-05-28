package CustomFoodshop.Ingredients.Proteins;

import CustomFoodshop.Ingredients.Ingredient;

abstract public class Protein extends Ingredient {
    enum CookLevel { RARE, MEDIUM_RARE, MEDIUM, MEDIUM_WELL, WELL_DONE, PRE_COOKED }
    private CookLevel cookLevel;
    private int proteinPerServing;

    Protein (int caloriesPerServing, int servings, double pricePerServing,
             boolean isSeasoned, boolean isSpicy, int proteinPerServing) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.proteinPerServing = proteinPerServing;
    }

    public CookLevel getCookLevel() {return this.cookLevel;}
    public void setCookLevel(CookLevel cookLevel) {this.cookLevel = cookLevel;}
    public int getProteinPerServing() {return this.proteinPerServing;}
    public void setProteinPerServing(int proteinPerServing) {this.proteinPerServing = proteinPerServing;}

    public static Protein createBurgerPatty(int servings, CookLevel cookLevel) {
        return new Beef(250, servings, 2.00, true, false, 20,
                cookLevel, "Ground Beef");
    }

    public static Protein createGrilledChicken(int servings) {
        return new Chicken(150, servings, 1.75, true, false, 25,
                CookLevel.PRE_COOKED, "Breast", "Grilled");
    }

    public static Protein createCrispyBacon(int servings) {
        return new Bacon(80, servings, 1.20, false, false, 5,
                CookLevel.PRE_COOKED, "Hickory Smoked");
    }

    @Override
    public String toString() {
        return "Protein{" +
                "cookLevel = " + cookLevel +
                ", proteinPerServing = " + proteinPerServing + "g" +
                ", calories = " + super.getCaloriesPerServing() +
                ", servings = " + getServings() +
                ", price = $" + getPricePerServing() +
                '}';
    }
}

class Beef extends Protein {
    private String beefCut;

    public Beef(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
         int proteinPerServing, CookLevel cookLevel, String beefCut) {

        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, proteinPerServing);
        this.beefCut = beefCut;
        setCookLevel(cookLevel);
    }

    public String getBeefCut() {return this.beefCut;}
    public void setBeefCut(String beefCut) {this.beefCut = beefCut;}
}

class Chicken extends Protein {
    private String chickenMeatType;
    private String preparationStyle;

    public Chicken(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
            int proteinPerServing, CookLevel cookLevel, String chickenMeatType, String preparationStyle) {

        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, proteinPerServing);
        this.chickenMeatType = chickenMeatType;
        this.preparationStyle = preparationStyle;
        setCookLevel(cookLevel);
    }

    public String getChickenMeatType() {return this.chickenMeatType;}
    public void setChickenMeatType(String chickenMeatType) {this.chickenMeatType = chickenMeatType;}
    public String getPreparationStyle() {return this.preparationStyle;}
    public void setPreparationStyle(String preparationStyle) {this.preparationStyle = preparationStyle;}
}

class Bacon extends Protein {
    private String baconType;

    public Bacon(int caloriesPerServing, int servings, double pricePerServing, boolean isSeasoned, boolean isSpicy,
          int proteinPerServing, CookLevel cookLevel, String baconType) {

        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy, proteinPerServing);
        this.baconType = baconType;
        setCookLevel(cookLevel);
    }

    public String getBaconType() {return this.baconType;}
    public void setBaconType(String baconType) {this.baconType = baconType;}
}

