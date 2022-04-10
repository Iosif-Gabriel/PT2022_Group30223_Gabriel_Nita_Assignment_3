package model;
/**
 * Clasa care reprezinta tabela request.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class Request {

    private int id=0;
    private String customer;
    private String product;
    private int quantity;
    private double price;

    public Request(){

    }

    public Request(int id, String customer, String product, int quantity, double price) {
        this.setId(id);
        this.setCustomer(customer);
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order " +
                "id" + this.getId() +
                ", Name client:'" + this.getCustomer() + '\'' +
                ", product:'" + this.getProduct() + '\'' +
                ", quantity:" + this.getQuantity() +
                ", price:" + this.getPrice() +
                ' ';
    }
}
