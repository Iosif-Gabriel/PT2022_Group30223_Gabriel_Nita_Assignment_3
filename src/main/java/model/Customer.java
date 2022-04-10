package model;

/**
 * Clasa care reprezinta tabela customer.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class Customer {

    private int id;
    private String name;
    private String address;

    public Customer(){

    }

    public Customer(int id, String name,String address){
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer " +
                "id: " + this.getId() +
                ", name:'" + this.getName() + '\'' +
                ", address:'" + this.getAddress() + '\'' +
                ' ';
    }
}
