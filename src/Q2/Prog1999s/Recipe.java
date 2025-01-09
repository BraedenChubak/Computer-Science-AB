package Q2.Prog1999s;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<IngredientBatch> ingredients;
    public Recipe(String s, ArrayList<IngredientBatch> i) {
        name = s;
        ingredients = i;
    }

    public String getName() { return name; }
    public ArrayList<IngredientBatch> getIngredients() { return ingredients; }
}
