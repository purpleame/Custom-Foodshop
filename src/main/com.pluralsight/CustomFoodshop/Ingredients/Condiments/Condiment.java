package CustomFoodshop.Ingredients.Condiments;

import CustomFoodshop.Ingredients.Ingredient;

abstract public class Condiment extends Ingredient {
    enum CondimentForm { LIQUID, POWDER, PASTE }
    private CondimentForm condimentForm;

    enum ServingStyle { PACKET, CUP, DRIZZLED }
    private ServingStyle servingStyle;

    private double maxFreeServings;
    private boolean isOnSide;

    Condiment(int caloriesPerServing, int servings, double pricePerServing,
                        boolean isSeasoned, boolean isSpicy, double maxFreeServings, boolean isOnSide) {
        super(caloriesPerServing, servings, pricePerServing, isSeasoned, isSpicy);
        this.maxFreeServings = maxFreeServings;
        this.isOnSide = isOnSide;
    }

    public CondimentForm getCondimentForm() {return this.condimentForm;}
    public void setCondimentForm(CondimentForm condimentForm) {this.condimentForm = condimentForm;}
    public ServingStyle getServingStyle() {return this.servingStyle;}
    public void setServingStyle(ServingStyle servingStyle) {this.servingStyle = servingStyle;}
    public double getMaxFreeServings() {return this.maxFreeServings;}
    public void setMaxFreeServings(double maxFreeServings) {this.maxFreeServings = maxFreeServings;}
    public boolean getOnSide() {return this.isOnSide;}
    public void setIsOnSide(boolean isOnSide) {this.isOnSide = isOnSide;}

    public static Condiment createKetchup(int servings, boolean sideOrNot) {
        return new Sauce(15, servings, 0.25, 2, sideOrNot,
                CondimentForm.LIQUID, ServingStyle.PACKET, "Ketchup", false);
    }

    public static Condiment createGarlicPowder(int servings) {
        return new Herb(5, servings, 0.10, 0, false,
                CondimentForm.POWDER, ServingStyle.DRIZZLED, "Garlic Powder");
    }

    public static Condiment createRanchCup(int servings) {
        return new Dressing(50, servings, 0.50, 1, true,
                CondimentForm.LIQUID, ServingStyle.CUP, "Ranch");
    }

    public static Condiment createSaltPacket(int servings) {
        return new Seasoning(
                0, servings, 0.05, 2,
                false, CondimentForm.POWDER, ServingStyle.PACKET, "Salt"
        );
    }

    @Override
    public String toString() {
        return "Condiment" +
                "form = " + condimentForm +
                ", style = " + servingStyle +
                ", maxFree = " + maxFreeServings +
                ", isOnSide = " + isOnSide +
                ", calories = " + super.getCaloriesPerServing() +
                ", servings = " + getServings() +
                ", price = $" + getPricePerServing() +
                '}';
    }

}

class Seasoning extends Condiment {
    private String seasoningType;

    public Seasoning(int caloriesPerServing, int servings, double pricePerServing, double maxFreeServings,
                        boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                        String seasoningType) {

        super(caloriesPerServing, servings, pricePerServing, false, false,
                maxFreeServings, isOnSide);
        this.seasoningType = seasoningType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public String getSeasoningType() {return this.seasoningType;}
    public void setSeasoningType(String seasoningType) {this.seasoningType = seasoningType;}
}

class Sauce extends Condiment {
    private String sauceType;
    private boolean isExtraSauce;

    public Sauce(int caloriesPerServing, int servings, double pricePerServing, double maxFreeServings,
                    boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                    String sauceType, boolean isExtraSauce) {

        super(caloriesPerServing, servings, pricePerServing, false, false,
                maxFreeServings, isOnSide);
        this.sauceType = sauceType;
        this.isExtraSauce = isExtraSauce;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public String getSauceType() {return this.sauceType;}
    public void setSauceType(String sauceType) {this.sauceType = sauceType;}
    public boolean getExtraSauce() {return this.isExtraSauce;}
    public void setIsExtraSauce(boolean isExtraSauce) {this.isExtraSauce = isExtraSauce;}
}

class Dressing extends Condiment {
    private String dressingType;

    public Dressing(int caloriesPerServing, int servings, double pricePerServing, double maxFreeServings,
                       boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                       String dressingType) {

        super(caloriesPerServing, servings, pricePerServing, false, false,
                maxFreeServings, isOnSide);
        this.dressingType = dressingType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public String getDressingType() {return this.dressingType;}
    public void setDressingType(String dressingType) {this.dressingType = dressingType;}
}

class Herb extends Condiment {
    private String herbType;

    public Herb(int caloriesPerServing, int servings, double pricePerServing, double maxFreeServings,
                   boolean isOnSide, CondimentForm condimentForm, ServingStyle servingStyle,
                   String herbType) {

        super(caloriesPerServing, servings, pricePerServing, false, false,
                maxFreeServings, isOnSide);
        this.herbType = herbType;

        setCondimentForm(condimentForm);
        setServingStyle(servingStyle);
    }

    public String getHerbType() {return this.herbType;}
    public void setHerbType(String herbType) {this.herbType = herbType;}
}
