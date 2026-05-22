package CustomFoodshop.Ingredient;

public abstract class Ingredient {
    private int caloriesPerServing;
    private int servings;
    private double pricePerServing;
    private boolean isSeasoned;
    private boolean isSpicy;

    public Ingredient(int caloriesPerServing, int servings,
                      double pricePerServing, boolean isSeasoned, boolean isSpicy) {
        this.caloriesPerServing = caloriesPerServing;
        this.servings = servings;
        this.pricePerServing = pricePerServing;
        this.isSeasoned = isSeasoned;
        this.isSpicy = isSpicy;
    }

    public int CaloriesPerServing() {return this.caloriesPerServing;}

    public void setCaloriesPerServing(int caloriesPerServing) {this.caloriesPerServing = caloriesPerServing;}

    public int Servings() {return this.servings;}

    public void setServings(int servings) {this.servings = servings;}

    public double PricePerServing() {return this.pricePerServing;}

    public void setPricePerServing(double pricePerServing) {this.pricePerServing = pricePerServing;}

    public boolean isSeasoned() {return this.isSeasoned;}

    public void setIsSeasoned(boolean isSeasoned) {this.isSeasoned = isSeasoned;}

    public boolean isSpicy() {return this.isSpicy;}

    public void setIsSpicy(boolean isSpicy) {this.isSpicy = isSpicy;}
}
