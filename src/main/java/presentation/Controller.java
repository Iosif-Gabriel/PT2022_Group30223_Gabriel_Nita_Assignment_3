package presentation;

import bll.CustomerBll;
import bll.RequestBll;
import bll.ProductBll;
import model.Customer;
import model.Request;
import model.Product;
import start.ReflectionTechnique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Clasa care se ocupa cu legarea componentelor implementate.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */

public class Controller {
    private static int id=0;
    private ProductView productView;
    private CustomerView customerView;
    private RequestView orderView;
    private CustomerBll customerBll;
    private RequestBll orderBll;
    private ProductBll productBll;


    /**
     * Constructorul clasei care contine instantierea parametrilor si implementarea metodelor ascultatoare din cele 3 interfete.
     *
     * @param customerView Obiectul responsabil de interfata tabelei Customer.
     * @param productView Obiectul responsabil de interfata tabelei Product.
     * @param orderView Obiectul responsabil de interfata tabelei Request.
     */
    public Controller(ProductView productView, CustomerView customerView, RequestView orderView) {
        this.productView = productView;
        this.customerView = customerView;
        this.orderView = orderView;
        customerBll=new CustomerBll();
        orderBll=new RequestBll();
        productBll=new ProductBll();
        customerView.addCustomerAddButtonListener(new AddCustomer());
        customerView.addDeleteCustomerButtonListener(new DeleteCustomer());
        customerView.addCustomerUpdateNameButtonListener(new UpdateNameCustomer());
        customerView.addCustomerUpdateAddressButtonListener(new UpdateAddressCustomer());
        customerView.addFindCustomerButtonListener(new FindCustomer());
        customerView.addFindAllCusteomerButtonListener(new FindAllCustomer());
        productView.addButtonAddProductButtonListener(new AddProduct());
        productView.addButtonDelProductButtonListener(new DeleteProduct());
        productView.addButtonUpdateNameProdButtonListener(new UpdateProductName());
        productView.addButtonUpdatePriceButtonListener(new UpdateProductPrice());
        productView.addButtonUpdateQuantityButtonListener(new UpdateProductQuantity());
        productView.addButtonFindProductButtonListener(new FindProduct());
        productView.addButtonFindAllProdButtonListener(new FindAllProducts());
        orderView.addUpdateInfoButtonListener(new UpdateInfo());
        orderView.addPlaceOrderButtonListener(new PlaceOrder());
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class AddCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care adauga un client in tabela.
         * @param e Apasarea butonului de insert.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            String name,address;
            if(e.getSource()==customerView.getButtonAddCus()){
                id=Integer.parseInt(customerView.getTextAddCusID().getText());
                name=customerView.getTextAddCusName().getText();
                address=customerView.getTextAddCusAddress().getText();
                Customer cus=new Customer(id,name,address);
                try {
                    customerBll.insertCustomer(cus);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class DeleteCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care sterge un client in tabela.
         * @param e Apasarea butonului DEL.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            if(e.getSource()==customerView.getButtonDelCustomer()){
                id=Integer.parseInt(customerView.getTextDelCustomer().getText());
                customerBll.deleteCustomer(id);
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateNameCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care updateaza numele unui client in tabela.
         * @param e Apasarea butonului UPDATE.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            String newName;
            if(e.getSource()==customerView.getButtonUpdateName()){
                id=Integer.parseInt(customerView.getTextUpdateNameId().getText());
                newName=customerView.getTextUpdateName().getText();
                customerBll.updateName(id,newName);
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateAddressCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care actualizeaza adresa unui client.
         * @param e Apasarea butonului UPDATE
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            String newAddress;
            if(e.getSource()==customerView.getButtonUpdateAddress()){
                id=Integer.parseInt(customerView.getTextUpdateAddressId().getText());
                newAddress=customerView.getTextUpdateAddress().getText();
                try {
                    customerBll.updateAddress(id,newAddress);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class FindCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care cauta un Client dupa id.
         * @param e Apasarea butonului FIND.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            if(e.getSource()==customerView.getButtonFindID()){
                id=Integer.parseInt(customerView.getTextFindID().getText());
                try {
                   Customer c=customerBll.findClientById(id);
                   JOptionPane.showMessageDialog(null,c.toString());
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class FindAllCustomer implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care cauta toti clinetii din tabela si ii afiseaza.
         * @param e Apasarea butonului FINDALL.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==customerView.getButtonFindAll()){
                List<Customer> listOfCustomers= customerBll.findAllCustomers();
                String[] col;
                String[][] data;
                col= ReflectionTechnique.retrieveFieldProperties(listOfCustomers.get(0));
                data =new String[listOfCustomers.size()][col.length];
                int j=0;
                for(Customer cus: listOfCustomers){
                    data[j]=ReflectionTechnique.retrieveValueProperties(cus);
                    j++;
                }
                JFrame customersTable=new JFrame("All Customers");
                JTable jTable=new JTable(data,col);
                JScrollPane jScrollPane=new JScrollPane(jTable);
                customersTable.add(jScrollPane);
                customersTable.setBounds(600,500,400,300);
                customersTable.setVisible(true);
            }
        }
    }

    //ProductView
    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class AddProduct implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care adauga un produs in tabela
         * @param e Apasarea butonului ADD.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id, quantity;
            String name;
            double price;
            if(e.getSource()==productView.getButtonAddProduct()){
                id=Integer.parseInt(productView.getTextAddProdID().getText());
                name=productView.getTextAddProdName().getText();
                quantity=Integer.parseInt(productView.getTextAddQuantity().getText());
                price=Double.parseDouble(productView.getTextAddPrice().getText());
                Product prod=new Product(id,name,quantity,price);
                productBll.insertProduct(prod);
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class DeleteProduct implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care sterge un produs din tabela
         * @param e Apasarea butonului DEL.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            if(e.getSource()==productView.getButtonDelProd()){
                id=Integer.parseInt(productView.getTextDelProd().getText());
                productBll.deleteProduct(id);
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateProductName implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care actualizeaza numele unui produs.
         * @param e Apasarea butonului UPDATE.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            String newName;
            if(e.getSource()==productView.getButtonUpdateName()){
                id=Integer.parseInt(productView.getTextIDUpdateName().getText());
                newName=productView.getTextUpdateName().getText();
                productBll.updateName(id,newName);
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateProductPrice implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care actualizeaza pretul unui produs .
         * @param e Apasarea butonului UPDATE.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            double newprice;
            if(e.getSource()==productView.getButtonUpdatePrice()){
                id=Integer.parseInt(productView.getTextIDUpdatePrice().getText());
                newprice=Double.parseDouble(productView.getTextUpdatePrice().getText());
                try {
                    productBll.updatePrice(id,newprice);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateProductQuantity implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care actualizeaza cantitatea produsului
         * @param e Apasarea butonului de UPDATE.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id,quantity;
            if(e.getSource()==productView.getButtonUpdateQuantity()){
                id=Integer.parseInt(productView.getTextIDUpdateQuantity().getText());
                quantity=Integer.parseInt(productView.getTextUpdateQuantity().getText());
                try {
                    productBll.updateQuantity(id,quantity);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class FindProduct implements ActionListener{
        /**
         * Implementarea metodei ascultatoare de plasare a unei comenzi.
         * @param e Apasarea butonului de FIND.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            int id;
            if(e.getSource()==productView.getButtonFindID()){
                id=Integer.parseInt(productView.getTextFindIDProd().getText());
                try {
                    Product prod=productBll.findProductById(id);
                    JOptionPane.showMessageDialog(null,prod.toString());
                } catch (NoSuchFieldException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class FindAllProducts implements ActionListener{
        /**
         * Implementarea metodei ascultatoare care gaseste toate prdusele din tabela si le afiseaza
         * @param e Apasarea butonului de FINDALL.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==productView.getButtonFindAllProd()){
                List<Product> listOfProducts= productBll.findAllProducts();
                String[] col;
                String[][] data;
                col= ReflectionTechnique.retrieveFieldProperties(listOfProducts.get(0));
                data =new String[listOfProducts.size()][col.length];
                int j=0;
                for(Product prod: listOfProducts){
                    data[j]=ReflectionTechnique.retrieveValueProperties(prod);
                    j++;
                }
                JFrame customersTable=new JFrame("All Products");
                JTable jTable=new JTable(data,col);
                JScrollPane jScrollPane=new JScrollPane(jTable);
                customersTable.add(jScrollPane);
                customersTable.setBounds(600,500,400,300);
                customersTable.setVisible(true);
            }
        }
    }

    //Order
    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class UpdateInfo implements ActionListener{
        /**
         * Implementarea metodei ascultatoare de care actualizeaza lista de clienti si de produse din interfata.
         * @param e Apasarea butonului de Update Products/Customers.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Product> productList=productBll.findAllProducts();
            List<Customer> customerList=customerBll.findAllCustomers();
                for(Product prod:productList){
                    orderView.productsList.addItem(prod.getName());
                }
                for(Customer cus:customerList){
                    orderView.customerList.addItem(cus.getName());
                }
        }
    }

    /**
     * Clasa secundara care ajuta la implmentarea ascultatorilor din interfata grafica
     */
    class PlaceOrder implements ActionListener{
        /**
         * Implementarea metodei ascultatoare de plasare a unei comenzi.
         * @param e Apasarea butonului de place order.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Product> productList=productBll.findAllProducts();
            int quantity=0,prodquantity=0,idprod=0;
            double price=0;
            prodquantity=Integer.parseInt(orderView.getTextQuantity().getText());
            String prod=(String) orderView.productsList.getSelectedItem();
            for(Product product:productList){
                if(product.getName().equals(prod)){
                    quantity=product.getQuantity();
                    price=product.getPrice();
                    idprod=product.getId();
                }
            }
            if(prodquantity>quantity){
                JOptionPane.showMessageDialog(orderView, "Only " + quantity + " left in stock!", "Stock Error", 0);
            }else {
                id++;
                Request or=new Request(id,(String)orderView.customerList.getSelectedItem(),(String)orderView.productsList.getSelectedItem(),prodquantity,price *prodquantity);
                orderBll.insertOrder(or);
                JOptionPane.showMessageDialog(orderView,or.toString(),"Order Placed",1);
                try {
                    productBll.updateQuantity(idprod,quantity-prodquantity);
                    createBILL(or.toString(),id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Metoda responsabila cu scrierea fiecarei comenzi intr-un fisier diferit.
     *
     * @param order     Comanda care trebuie scrisa in fisier.
     * @param id        id-ul care trebuie adaugat la numele fisierului txt.
     */
    public void createBILL(String order,int id){
        try {
            File f = new File("Bill" + id + ".txt");
            FileWriter wr = new FileWriter(f);
            wr.write(order);
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
