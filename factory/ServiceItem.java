class ServiceItem extends Item {
    private String serviceType;

    /**
     * @param id
     * @param name
     * @param price
     * @param serviceType
     */
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