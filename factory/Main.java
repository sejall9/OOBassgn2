import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * @param filePath
     * @param lines
     * @throws IOException
     */
    public static void writeLines(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }

    /**
     * @param filePath
     * @return
     * @throws IOException
     */
    public static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}

class FoodItem extends Item {
    private String expiryDate;

    public FoodItem(int id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}

class ElectronicItem extends Item {
    private String brand;

    public ElectronicItem(int id, String name, double price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ElectronicItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}

class ServiceItem extends Item {
    private String serviceType;

    public ServiceItem(int id, String name, double price, String serviceType) {
        super(id, name, price);
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "ServiceItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}

class FileUtil {
    public static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public static void writeLines(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }
}

interface ItemFactory {
    Item createItem(int id, String name, double price);
}

class FoodItemFactory implements ItemFactory {
    @Override
    public Item createItem(int id, String name, double price) {
        
    
        // Logic to create FoodItem from CSV data
        // ...
        return new FoodItem(id, name, price, name);
    }
}

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

abstract class AbstractStore {
    protected List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public abstract void sortItemsByID();

    public abstract void sortItemsByName();

    public abstract void sortItemsByPrice();
}

class Store extends AbstractStore {
    public void demo() {
        // Create items using factories and add them to the store
        ItemFactory foodItemFactory = new FoodItemFactory();
        ItemFactory electronicItemFactory = ElectronicItemFactory.getInstance();
        ItemFactory serviceItemFactory = ServiceItemFactory.getInstance();

        try {
            List<String> foodItemLines = FileUtil.readLines("FoodItemCSV.txt");
            for (String line : foodItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                FoodItem foodItem = (FoodItem) foodItemFactory.createItem(id, name, price);
                addItem(foodItem);
            }

            List<String> electronicItemLines = FileUtil.readLines("ElectronicItemCSV.txt");
            for (String line : electronicItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                ElectronicItem electronicItem = (ElectronicItem) electronicItemFactory.createItem(id, name, price);
                addItem(electronicItem);
            }

            List<String> serviceItemLines = FileUtil.readLines("ServiceItemCSV.txt");
            for (String line : serviceItemLines) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                ServiceItem serviceItem = (ServiceItem) serviceItemFactory.createItem(id, name, price);
                addItem(serviceItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
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

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.demo();
    }
}
