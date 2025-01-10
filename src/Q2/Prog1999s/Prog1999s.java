package Q2.Prog1999s;

import DataStructures.BinarySearchTree;
import DataStructures.Queue;
import DataStructures.DoublyLinkedList;
import DataStructures.Stack;
import DataStructures.Deque;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog1999s {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1999s.txt"));

            BinarySearchTree<Recipe> recipeCatalog = new BinarySearchTree<Recipe>();
            int numRecipes = file.nextInt();
            file.nextLine();
            for (int i = 0; i < numRecipes; i++) {
                String[] curLine = file.nextLine().split(" ");
                ArrayList<IngredientBatch> ingredients = new ArrayList<>();
                for (int j = 1; j < curLine.length; j++) {
                    String[] curIngredient = curLine[j].split(":");
                    IngredientBatch ing = new IngredientBatch(curIngredient[0], Integer.parseInt(curIngredient[1]));
                    ingredients.add(ing);
                }
                Recipe curRecipe = new Recipe(curLine[0], ingredients);
                recipeCatalog.insert(curRecipe);
            }

            ArrayList<IngredientItem> ingredients = new ArrayList<>();
            int numIngredients = file.nextInt();
            file.nextLine();
            for (int i = 0; i < numIngredients; i++) {
                String name = file.next();
                int num = file.nextInt();
                ingredients.add(new IngredientItem(name, num));
            }

            DoublyLinkedList<IngredientBatch> shipments = new DoublyLinkedList();
            int numShipments = file.nextInt();
            int ingredientCount = 0;
            file.nextLine();
            for (int i = 0; i < numShipments; i++) {
                String[] splitLine = file.nextLine().split(" ");
                for (String s : splitLine) {
                    String[] doubleSplit = s.split(":");
                    String name = doubleSplit[0];
                    int num = Integer.parseInt(doubleSplit[1]);
                    shipments.add(new IngredientBatch(name, num));
                    ingredientCount++;
                }
            }
            System.out.println();
            for (int i = 0; i < ingredientCount; i++) {
                IngredientBatch ib = shipments.get(i);
                boolean found = false;
                for (IngredientItem ii : ingredients) {
                    if (ib.getName().equals(ii.getName())) {
                        found = true;
                        ii.amount += ib.getAmount();
                    }
                }
                if (!found) {
                    ingredients.add(new IngredientItem(ib.getName(), ib.getAmount()));
                }
            }
            shipments = new DoublyLinkedList<>();

            Queue<Recipe> orders = new Queue<>();
            int numOrders = file.nextInt();
            file.nextLine();
            for (int i = 0; i < numOrders; i++) {
                String recipeName = file.next();
                int amount = file.nextInt();
                Recipe realRecipe = recipeCatalog.getElement(new Recipe(recipeName, null));
                for (IngredientBatch ib : realRecipe.getIngredients()) {
                    for (IngredientItem ii : ingredients) {
                        if (ib.getName().equals(ii.getName())) {
                            ii.amount -= ib.getAmount() * amount;
                        }
                    }
                }
            }

            Deque<String> featuredMeals = new Deque<>();
            int numOperations = file.nextInt();
            file.nextLine();
            for (int i = 0; i < numOperations; i++) {
                String operation = file.next();
                if (operation.equalsIgnoreCase("ADD_FRONT")) {
                    featuredMeals.enqueueFront(file.next());
                } else if (operation.equalsIgnoreCase("ADD_BACK")) {
                    featuredMeals.enqueueRear(file.next());
                } else if (operation.equalsIgnoreCase("REMOVE_FRONT")) {
                    featuredMeals.dequeueFront();
                } else if (operation.equalsIgnoreCase("REMOVE_BACK")) {
                    featuredMeals.dequeueRear();
                }
            }

            Stack<String> recentlyViewed = new Stack<>();
            int numViews = file.nextInt();
            file.nextLine();
            for (int i = 0; i < numViews; i++) {
                file.next();
                recentlyViewed.push(file.next());
            }

            System.out.println("FINAL INVENTORY");
            for (IngredientBatch ib : ingredients) {
                System.out.println(ib.getName() + " " + ib.getAmount());
            }
            System.out.println();

            System.out.println("FEATURED MEALS");
            int featuredMealsNum = featuredMeals.size();
            for (int i = 0; i < featuredMealsNum; i++) {
                System.out.println(featuredMeals.dequeueFront());
            }
            System.out.println();

            System.out.println("TOP OF RECENTLY VIEWED");
            System.out.println(recentlyViewed.peek());


            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
FINAL INVENTORY
Pasta 6
Sauce 2
Cheese 1
Quinoa 2
Chickpeas 2
Herbs 4
Spinach 3
Lemons 4
Tortillas 4
Beans 4
Salsa 2

FEATURED MEALS
VeganBowl
SpicyTacos

TOP OF RECENTLY VIEWED
GrilledSalmon
 */