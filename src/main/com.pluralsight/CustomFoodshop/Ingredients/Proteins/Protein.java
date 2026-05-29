package CustomFoodshop.Ingredients.Proteins;

import CustomFoodshop.Ingredients.Ingredient;

abstract public class Protein extends Ingredient {
    public enum CookLevel { RARE, MEDIUM_RARE, MEDIUM, MEDIUM_WELL, WELL_DONE, PRE_COOKED }
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
        return new Beef(250, servings, true, false, 20, cookLevel, Beef.BeefCut.GROUND_BEEF);
    }

    public static Protein createGrilledChicken(int servings) {
        return new Chicken(150, servings, true, false, 25, CookLevel.PRE_COOKED, Chicken.ChickenMeatType.WHITE_MEAT, "Grilled");
    }

    public static Protein createCrispyBacon(int servings) {
        return new Bacon(80, servings, false, false, 5, CookLevel.PRE_COOKED, Bacon.BaconType.HICKORY_BAKED);
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
    public enum BeefCut {
        GROUND_BEEF(2.25), STEAK_STRIPS(3.50), MEATBALL(2.50), ROAST_BEEF(3.00);

        private final double basePrice;
        BeefCut(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private BeefCut beefCut;

    public Beef(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                int proteinPerServing, CookLevel cookLevel, BeefCut beefCut) {
        super(caloriesPerServing, servings, beefCut.getBasePrice(), isSeasoned, isSpicy, proteinPerServing);
        this.beefCut = beefCut;
        setCookLevel(cookLevel);
    }

    public BeefCut getBeefCut() {return this.beefCut;}
    public void setBeefCut(BeefCut beefCut) {this.beefCut = beefCut;}
}

class Chicken extends Protein {
    public enum ChickenMeatType {
        WHITE_MEAT(2.50), DARK_MEAT(2.00);

        private final double basePrice;
        ChickenMeatType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private ChickenMeatType chickenMeatType;
    private String preparationStyle;

    public Chicken(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                   int proteinPerServing, CookLevel cookLevel, ChickenMeatType chickenMeatType, String preparationStyle) {
        super(caloriesPerServing, servings, chickenMeatType.getBasePrice(), isSeasoned, isSpicy, proteinPerServing);
        this.chickenMeatType = chickenMeatType;
        this.preparationStyle = preparationStyle;
        setCookLevel(cookLevel);
    }

    public ChickenMeatType getChickenMeatType() {return this.chickenMeatType;}
    public void setChickenMeatType(ChickenMeatType chickenMeatType) {this.chickenMeatType = chickenMeatType;}
    public String getPreparationStyle() {return this.preparationStyle;}
    public void setPreparationStyle(String preparationStyle) {this.preparationStyle = preparationStyle;}
}

class Bacon extends Protein {
    public enum BaconType {
        SMOKED_BACON(1.50), HICKORY_BAKED(1.50), REGULAR_BACON(1.25);

        private final double basePrice;
        BaconType(double basePrice) { this.basePrice = basePrice; }
        public double getBasePrice() { return this.basePrice; }
    }

    private BaconType baconType;

    public Bacon(int caloriesPerServing, int servings, boolean isSeasoned, boolean isSpicy,
                 int proteinPerServing, CookLevel cookLevel, BaconType baconType) {
        super(caloriesPerServing, servings, baconType.getBasePrice(), isSeasoned, isSpicy, proteinPerServing);
        this.baconType = baconType;
        setCookLevel(cookLevel);
    }

    public BaconType getBaconType() {return this.baconType;}
    public void setBaconType(BaconType baconType) {this.baconType = baconType;}
}
