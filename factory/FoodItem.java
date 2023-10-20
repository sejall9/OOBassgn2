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
