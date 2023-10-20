class ServiceItemFactory implements ItemFactory {
    private static final ServiceItemFactory instance = new ServiceItemFactory();

    private ServiceItemFactory() {}

    public static ServiceItemFactory getInstance() {
        return instance;
    }

    @Override
    public Item createItem(int id, String name, double price) {
    
        // Logic to create ServiceItem from CSV data
        // ...
        return new ServiceItem(id, name, price, name);
    }
}
