abstract class AbstractStore {
    protected List<Item> items = new List<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public abstract void sortItemsByID();

    public abstract void sortItemsByName();

    public abstract void sortItemsByPrice();
}