package Q2.Prog1999s;

public class IngredientBatch {
    private String name;
    protected int amount;
    public IngredientBatch(String name, int num) {
        this.name = name;
        this.amount = num;
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }
}
