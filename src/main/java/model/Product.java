package model;

/**
 * Clasa care reprezinta tabela product.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(){

    }

    public Product(int id,String name,int quantity,double price){
        this.setId(id);
        this.setName(name);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Product:" +
                "id" + this.getId() +
                ", name:'" + this.getName() + '\'' +
                ", quantity:" + this.getQuantity()+
                ", price:" + this.getPrice() +
                ' ';
    }
}
