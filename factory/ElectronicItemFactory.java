class ElectronicItemFactory implements ItemFactory {
    private static ElectronicItemFactory instance;

    private ElectronicItemFactory() {}

    public static ElectronicItemFactory getInstance() {
        if (instance == null) {
            instance = new ElectronicItemFactory();
        }
        return instance;
    }

    @Override
    public Item createItem(int id, String name, double price) {
    
        // Logic to create ElectronicItem from CSV data
        // ...
        return new ElectronicItem(id, name, price, name);
    }
}