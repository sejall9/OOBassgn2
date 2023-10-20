import java.io.IOException;

class Store extends AbstractStore {
    /**
     * @throws IOException
     *
     */
    public void demo() throws IOException {
        // Create items using factories and add them to the store
        ItemFactory foodItemFactory = new FoodItemFactory();
        ItemFactory electronicItemFactory = ElectronicItemFactory.getInstance();
        ItemFactory serviceItemFactory = ServiceItemFactory.getInstance();

        {
            java.util.List<String> foodItemLines = FileUtil.readLines("FoodItemCSV.txt");
            for (String line : foodItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                FoodItem foodItem = (FoodItem) foodItemFactory.createItem(id, name, price);
                addItem(foodItem);
            }

            java.util.List<String> electronicItemLines = FileUtil.readLines("ElectronicItemCSV.txt");
            for (String line : electronicItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                ElectronicItem electronicItem = (ElectronicItem) electronicItemFactory.createItem(id, name, price);
                addItem(electronicItem);
            }

            java.util.List<String> serviceItemLines = FileUtil.readLines("ServiceItemCSV.txt");
            for (String line : serviceItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                ServiceItem serviceItem = (ServiceItem) serviceItemFactory.createItem(id, name, price);
                addItem(serviceItem);
            }
        }

        // Sort items by ID, Name, and Price
        sortItemsByID();
        System.out.println("Sorted Items by ID:");
        items.forEach(System.out::println);

        sortItemsByName();
        System.out.println("\nSorted Items by Name:");
        items.forEach(System.out::println);

        sortItemsByPrice();
        System.out.println("\nSorted Items by Price:");
        items.forEach(System.out::println);
    }

    @Override
    public void sortItemsByID() {
        items.sort((item1, item2) -> Integer.compare(item1.id, item2.id));
    }

    @Override
    public void sortItemsByName() {
        items.sort((item1, item2) -> item1.name.compareTo(item2.name));
    }

    @Override
    public void sortItemsByPrice() {
        items.sort((item1, item2) -> Double.compare(item1.price, item2.price));
    }
}
