class FoodItemFactory implements ItemFactory {
    @Override
    public Item createItem(int id, String name, double price) {
        
    
        // Logic to create FoodItem from CSV data
        // ...
        return new FoodItem(id, name, price, name);
    }
}