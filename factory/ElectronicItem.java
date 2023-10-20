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