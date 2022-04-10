package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata grafica pentru tabela product.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class ProductView extends JFrame {
    private JButton buttonAddProduct;
    private JButton buttonUpdateName;
    private JButton buttonDelProd;
    private JTextField textAddProdID;
    private JTextField textDelProd;
    private JTextField textAddProdName;
    private JTextField textAddQuantity;
    private JLabel labelQuantity;
    private JLabel labelNameProduct;
    private JLabel labelIDAddProduct;
    private JLabel labelDelProd;
    private JTextField textUpdateQuantity;
    private JLabel labelNewQuantity;
    private JButton buttonUpdateQuantity;
    private JButton buttonFindID;
    private JLabel labelFindIDProd;
    private JTextField textFindIDProd;
    private JButton buttonFindAllProd;
    private JLabel labelPriceProd;
    private JTextField textAddPrice;
    private JLabel labelUpdateName;
    private JTextField textUpdateName;
    private JButton buttonUpdatePrice;
    private JTextField textUpdatePrice;
    private JLabel labelUpdatePrice;
    private JLabel textIDProd;
    private JTextField textIDUpdateName;
    private JLabel labelQuantityID;
    private JTextField textIDUpdateQuantity;
    private JLabel labelPriceID;
    private JTextField textIDUpdatePrice;

    /**
     * Implementarea ferestrei grafice.
     */
    public ProductView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(650,360);
        setPreferredSize (new Dimension(624, 335));
        this.setTitle("Product View");

        buttonAddProduct = new JButton ("ADD");
        buttonUpdateName = new JButton ("UPDATE");
        buttonDelProd = new JButton ("DEL");
        textAddProdID = new JTextField (5);
        textDelProd = new JTextField (5);
        textAddProdName = new JTextField (5);
        textAddQuantity = new JTextField (5);
        labelQuantity = new JLabel ("Qunatity:");
        labelNameProduct = new JLabel ("Name:");
        labelIDAddProduct = new JLabel ("ID:");
        labelDelProd = new JLabel ("ID:");
        textUpdateQuantity = new JTextField (5);
        labelNewQuantity = new JLabel ("Quantity:");
        buttonUpdateQuantity = new JButton ("UPDATE");
        buttonFindID = new JButton ("FIND");
        labelFindIDProd = new JLabel ("ID:");
        textFindIDProd = new JTextField (5);
        buttonFindAllProd = new JButton ("FIND ALL");
        labelPriceProd = new JLabel ("Price:");
        textAddPrice = new JTextField (5);
        labelUpdateName = new JLabel ("Name:");
        textUpdateName = new JTextField (5);
        buttonUpdatePrice = new JButton ("UPDATE");
        textUpdatePrice = new JTextField (5);
        labelUpdatePrice = new JLabel ("Price:");
        textIDProd = new JLabel ("ID:");
        textIDUpdateName = new JTextField (5);
        labelQuantityID = new JLabel ("ID:");
        textIDUpdateQuantity = new JTextField (5);
        labelPriceID = new JLabel ("ID:");
        textIDUpdatePrice = new JTextField (5);

        setPreferredSize (new Dimension(624, 335));
        setLayout (null);

        this.add (buttonAddProduct);
        this.add (buttonUpdateName);
        this.add (buttonDelProd);
        this.add (textAddProdID);
        this.add (textDelProd);
        this.add (textAddProdName);
        this.add (textAddQuantity);
        this.add (labelQuantity);
        this.add (labelNameProduct);
        this.add (labelIDAddProduct);
        this.add (labelDelProd);
        this.add (textUpdateQuantity);
        this.add (labelNewQuantity);
        this.add (buttonUpdateQuantity);
        this.add (buttonFindID);
        this.add (labelFindIDProd);
        this.add (textFindIDProd);
        this.add (buttonFindAllProd);
        this.add (labelPriceProd);
        this.add (textAddPrice);
        this.add (labelUpdateName);
        this.add (textUpdateName);
        this.add (buttonUpdatePrice);
        this.add (textUpdatePrice);
        this.add (labelUpdatePrice);
        this.add (textIDProd);
        this.add (textIDUpdateName);
        this.add (labelQuantityID);
        this.add (textIDUpdateQuantity);
        this.add (labelPriceID);
        this.add (textIDUpdatePrice);

        buttonAddProduct.setBounds (35, 10, 65, 25);
        buttonUpdateName.setBounds (35, 80, 90, 25);
        buttonDelProd.setBounds (35, 40, 65, 25);
        textAddProdID.setBounds (130, 10, 50, 25);
        textDelProd.setBounds (130, 40, 50, 25);
        textAddProdName.setBounds (235, 10, 100, 25);
        textAddQuantity.setBounds (405, 10, 100, 25);
        labelQuantity.setBounds (350, 10, 55, 25);
        labelNameProduct.setBounds (195, 10, 40, 25);
        labelIDAddProduct.setBounds (110, 10, 20, 25);
        labelDelProd.setBounds (110, 40, 20, 25);
        textUpdateQuantity.setBounds (185, 120, 100, 25);
        labelNewQuantity.setBounds (130, 120, 55, 25);
        buttonUpdateQuantity.setBounds (35, 120, 90, 25);
        buttonFindID.setBounds (35, 200, 90, 25);
        labelFindIDProd.setBounds (135, 200, 20, 25);
        textFindIDProd.setBounds (185, 200, 50, 25);
        buttonFindAllProd.setBounds (250, 285, 90, 25);
        labelPriceProd.setBounds (525, 10, 40, 25);
        textAddPrice.setBounds (560, 10, 50, 25);
        labelUpdateName.setBounds (135, 80, 40, 25);
        textUpdateName.setBounds (185, 80, 100, 25);
        buttonUpdatePrice.setBounds (35, 160, 90, 25);
        textUpdatePrice.setBounds (185, 160, 100, 25);
        labelUpdatePrice.setBounds (135, 160, 40, 25);
        textIDProd.setBounds (305, 80, 20, 25);
        textIDUpdateName.setBounds (325, 80, 50, 25);
        labelQuantityID.setBounds (305, 120, 20, 25);
        textIDUpdateQuantity.setBounds (325, 120, 50, 25);
        labelPriceID.setBounds (305, 160, 20, 25);
        textIDUpdatePrice.setBounds (325, 160, 50, 25);

    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de adaugare a unui produs.
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonAddProductButtonListener(ActionListener actionListener){
        this.buttonAddProduct.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonAddProduct() {
        return buttonAddProduct;
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonUpdateName() {
        return buttonUpdateName;
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonDelProd() {
        return buttonDelProd;
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonUpdateQuantity() {
        return buttonUpdateQuantity;
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonFindID() {
        return buttonFindID;
    }

    /**
     * Metoda care returneaza un anumit buton
     *
     * @return JButton returneaza un anumit buton.
     */
    public JButton getButtonFindAllProd() {
        return buttonFindAllProd;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonUpdatePrice() {
        return buttonUpdatePrice;
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de stergere a unui produs.
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonDelProductButtonListener(ActionListener actionListener){
        this.buttonDelProd.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de actualozare a numelui unui produs
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonUpdateNameProdButtonListener(ActionListener actionListener){
        this.buttonUpdateName.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de actualozare a cantitaii unui produs
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonUpdateQuantityButtonListener(ActionListener actionListener){
        this.buttonUpdateQuantity.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de actualozare a pretului unui produs
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonUpdatePriceButtonListener(ActionListener actionListener){
        this.buttonUpdatePrice.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de cautare a unui produs.
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonFindProductButtonListener(ActionListener actionListener){
        this.buttonFindID.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de cautare a tuturor produselor.
     *
     * @param actionListener Ascultatorul.
     */
    public void addButtonFindAllProdButtonListener(ActionListener actionListener){
        this.buttonFindAllProd.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza id-ul unui produs adaugat.
     *
     * @return JTextField id-ul data de catre utilizator.
     */
    public JTextField getTextAddProdID() {
        return textAddProdID;
    }

    /**
     * Metoda care returneaza id-ul unui produs care trebuie scos din tabela.
     *
     * @return JTextField id-ul data de catre utilizator.
     */
    public JTextField getTextDelProd() {
        return textDelProd;
    }

    /**
     * Metoda care returneaza numele unui produs adaugat.
     *
     * @return JTextField numele data de catre utilizator.
     */
    public JTextField getTextAddProdName() {
        return textAddProdName;
    }

    /**
     * Metoda care returneaza cantitatea unui produs adaugat.
     *
     * @return JTextField cantitatea data de catre utilizator.
     */
    public JTextField getTextAddQuantity() {
        return textAddQuantity;
    }

    /**
     * Metoda care returneaza noua cantitate unui produs deja existent.
     *
     * @return JTextField cantitatea data de catre utilizator.
     */
    public JTextField getTextUpdateQuantity() {
        return textUpdateQuantity;
    }

    /**
     * Metoda care returneaza id-ul produsului cautat.
     *
     * @return JTextField id-ul data de catre utilizator.
     */
    public JTextField getTextFindIDProd() {
        return textFindIDProd;
    }

    /**
     * Metoda care returneaza pretul unui produs adaugat.
     *
     * @return JTextField pretul data de catre utilizator.
     */
    public JTextField getTextAddPrice() {
        return textAddPrice;
    }

    /**
     * Metoda care returneaza nouul nume a unui produs deja existent.
     *
     * @return JTextField numele dat de catre utilizator.
     */
    public JTextField getTextUpdateName() {
        return textUpdateName;
    }

    /**
     * Metoda care returneaza noul pret unui produs deja existent.
     *
     * @return JTextField pret-ul data de catre utilizator.
     */
    public JTextField getTextUpdatePrice() {
        return textUpdatePrice;
    }

    /**
     * Metoda care returneaza id-ul unui produs care trebuie sa i se schimbe numele
     *
     * @return JTextField numele data de catre utilizator.
     */
    public JTextField getTextIDUpdateName() {
        return textIDUpdateName;
    }

    /**
     * Metoda care returneaza id-ul unui produs care trebuie sa i se schimbe cantitatea.
     *
     * @return JTextField id-ul dat de catre utilizator.
     */
    public JTextField getTextIDUpdateQuantity() {
        return textIDUpdateQuantity;
    }


    /**
     * Metoda care returneaza id-ul unui produs care trebuie sa i se schimbe pretul.
     *
     * @return JTextField pretul data de catre utilizator.
     */
    public JTextField getTextIDUpdatePrice() {
        return textIDUpdatePrice;
    }
}
