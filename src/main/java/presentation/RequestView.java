package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata grafica pentru tabela request
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class RequestView extends JFrame {
    private JButton buttonPlaceOrder;
    private JButton buttonUpdateInfo;
    public JComboBox productsList;
    public JComboBox customerList;
    private JLabel labelProduct;
    private JLabel labelCustomer;
    private JLabel labelQuantity;
    private JTextField textQuantity;

    /**
     * Implementarea ferestrei grafice.
     */
    public RequestView(){
        this.setTitle("Order View");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(650,360);


        buttonPlaceOrder = new JButton ("Place Order");
        buttonUpdateInfo = new JButton ("Update Products/Customers");
        productsList = new JComboBox ();
        customerList = new JComboBox ();
        productsList.setToolTipText("Products");
        customerList.setToolTipText("Customers");
        labelProduct = new JLabel ("Product:");
        labelCustomer = new JLabel ("Customer:");
        labelQuantity = new JLabel ("Quantity:");
        textQuantity = new JTextField ();

        setPreferredSize (new Dimension(624, 335));
        setLayout (null);

        this.add (buttonPlaceOrder);
        this.add (buttonUpdateInfo);
        this.add (productsList);
        this.add (customerList);
        this.add (labelProduct);
        this.add (labelCustomer);
        this.add (labelQuantity);
        this.add (textQuantity);

        buttonPlaceOrder.setBounds (240, 230, 105, 20);
        buttonUpdateInfo.setBounds (195, 265, 200, 25);
        productsList.setBounds (250, 135, 100, 25);
        customerList.setBounds (250, 105, 100, 25);
        labelProduct.setBounds (195, 135, 55, 25);
        labelCustomer.setBounds (185, 105, 60, 25);
        labelQuantity.setBounds (195, 165, 55, 25);
        textQuantity.setBounds (250, 165, 100, 25);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de suprascriere a listelor cu clientii si produsele existente in tabele.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateInfoButtonListener(ActionListener actionListener){
        this.buttonUpdateInfo.addActionListener(actionListener);
    }
    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de plasare a unei comenzi.
     *
     * @param actionListener Ascultatorul.
     */
    public void addPlaceOrderButtonListener(ActionListener actionListener){
        this.buttonPlaceOrder.addActionListener(actionListener);
    }
    /**
     * Metoda care returneaza cantitatea produsului care se vrea sa fie achizitionat de client.
     *
     * @return JTextField cantitatea data de catre utilizator.
     */
    public JTextField getTextQuantity() {
        return textQuantity;
    }

}
