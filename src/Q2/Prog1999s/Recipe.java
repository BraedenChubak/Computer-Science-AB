package Q2.Prog1999s;

import java.util.ArrayList;

public class Recipe implements Comparable<Recipe> {
    private String name;
    private ArrayList<IngredientBatch> ingredients;
    public Recipe(String s, ArrayList<IngredientBatch> i) {
        name = s;
        ingredients = i;
    }

    public String getName() { return name; }
    public ArrayList<IngredientBatch> getIngredients() { return ingredients; }

    @Override
    public int compareTo(Recipe o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        String finished = name + ": ";
        for (IngredientBatch i : ingredients) {
            finished += i.getAmount() + " " + i.getName() + ", ";
        }
        finished = finished.substring(0, finished.length()-2);
        return finished;
    }
}
