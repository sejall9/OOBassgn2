abstract class Item {
    protected int id;
    protected String name;
    protected double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract String toString();
}
