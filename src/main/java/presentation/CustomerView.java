package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Clasa care implementeaza interfata grafica pentru tabela customer.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class CustomerView extends JFrame {
    private JButton buttonAddCus;
    private JButton buttonUpdateName;
    private JButton buttonDelCustomer;
    private JTextField textAddCusID;
    private JTextField textDelCustomer;
    private JTextField textAddCusName;
    private JTextField textAddCusAddress;
    private JLabel labelAddress;
    private JLabel labelName;
    private JLabel labelIDAdd;
    private JLabel labelDelCus;
    private JTextField textUpdateName;
    private JLabel labelNewName;
    private JButton buttonUpdateAddress;
    private JTextField textUpdateAddress;
    private JLabel labesNewAdress;
    private JButton buttonFindID;
    private JLabel labelFindID;
    private JTextField textFindID;
    private JButton buttonFindAll;
    private JLabel labelFindAll;
    private JLabel updateNameId;
    private JLabel updateAdressId;
    private JTextField textUpdateNameId;
    private JTextField textUpdateAddressId;

    /**
     * Implementarea ferestrei grafice.
     */
    public CustomerView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(650,360);
        this.setTitle("Customer View");

        buttonAddCus = new JButton ("ADD");
        buttonUpdateName = new JButton ("UPDATE");
        buttonDelCustomer = new JButton ("DEL");
        textAddCusID = new JTextField (5);
        textDelCustomer = new JTextField (5);
        textAddCusName = new JTextField (5);
        textAddCusAddress = new JTextField (5);
        labelAddress = new JLabel ("Address:");
        labelName = new JLabel ("Name:");
        labelIDAdd = new JLabel ("ID:");
        labelDelCus = new JLabel ("ID:");
        textUpdateName = new JTextField (5);
        labelNewName = new JLabel ("Name:");
        buttonUpdateAddress = new JButton ("UPDATE");
        textUpdateAddress = new JTextField (5);
        labesNewAdress = new JLabel ("Address:");
        buttonFindID = new JButton ("FIND");
        labelFindID = new JLabel ("ID:");
        textFindID = new JTextField (5);
        buttonFindAll = new JButton ("FIND ALL");
        updateAdressId= new JLabel("ID: ");
        updateNameId=new JLabel("ID: ");
        textUpdateAddressId=new JTextField(5);
        textUpdateNameId=new JTextField(5);
        //labelFindAll = new JLabel ("Find all customers");

        setPreferredSize (new Dimension(624, 335));
        setLayout (null);

       this.add (buttonAddCus);
       this.add (buttonUpdateName);
       this.add (buttonDelCustomer);
       this.add (textAddCusID);
       this.add (textDelCustomer);
       this.add (textAddCusName);
       this.add (textAddCusAddress);
       this.add (labelAddress);
       this.add (labelName);
       this.add (labelIDAdd);
       this.add (labelDelCus);
       this.add (textUpdateName);
       this.add (labelNewName);
       this.add (buttonUpdateAddress);
       this.add (textUpdateAddress);
       this.add (labesNewAdress);
       this.add (buttonFindID);
       this.add (labelFindID);
       this.add (textFindID);
       this.add (buttonFindAll);
       //this.add (labelFindAll);
       this.add (updateNameId);
       this.add (updateAdressId);
       this.add (textUpdateNameId);
       this.add (textUpdateAddressId);

        buttonAddCus.setBounds (35, 10, 65, 25);
        buttonUpdateName.setBounds (165, 70, 90, 25);
        buttonDelCustomer.setBounds (35, 40, 65, 25);
        textAddCusID.setBounds (130, 10, 50, 25);
        textDelCustomer.setBounds (130, 40, 50, 25);
        textAddCusName.setBounds (235, 10, 100, 25);
        textAddCusAddress.setBounds (405, 10, 100, 25);
        labelAddress.setBounds (350, 10, 55, 25);
        labelName.setBounds (195, 10, 40, 25);
        labelIDAdd.setBounds (110, 10, 20, 25);
        labelDelCus.setBounds (110, 40, 20, 25);
        textUpdateName.setBounds (315, 70, 100, 25);
        labelNewName.setBounds (260, 70, 40, 25);
        updateNameId.setBounds(430,70,50,25);
        textUpdateNameId.setBounds(450,70,50,25);
        buttonUpdateAddress.setBounds (165, 100, 90, 25);
        textUpdateAddress.setBounds (315, 100, 100, 25);
        updateAdressId.setBounds(430,100,50,25);
        textUpdateAddressId.setBounds(450,100,50,25);
        labesNewAdress.setBounds (260, 100, 55, 25);

        buttonFindID.setBounds (165, 160, 90, 25);
        labelFindID.setBounds (260, 160, 20, 25);
        textFindID.setBounds (275, 160, 50, 25);
        buttonFindAll.setBounds (165, 215, 90, 25);
        //labelFindAll.setBounds (260, 215, 110, 25);

    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de adaugare a unui client.
     *
     * @param actionListener Ascultatorul.
     */
    public void addCustomerAddButtonListener(ActionListener actionListener){
        this.buttonAddCus.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de actualozare a numelui unui client.
     *
     * @param actionListener Ascultatorul.
     */
    public void addCustomerUpdateNameButtonListener(ActionListener actionListener){
        this.buttonUpdateName.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de actualozare a adresei unui client.
     *
     * @param actionListener Ascultatorul.
     */
    public void addCustomerUpdateAddressButtonListener(ActionListener actionListener){
        this.buttonUpdateAddress.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de stergere a unui client.
     *
     * @param actionListener Ascultatorul.
     */
    public void addDeleteCustomerButtonListener(ActionListener actionListener){
        this.buttonDelCustomer.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de cautare a unui client.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindCustomerButtonListener(ActionListener actionListener){
        this.buttonFindID.addActionListener(actionListener);
    }

    /**
     * Metoda de adaugarea a unui ascultator pentru butonul de cautare a tuturor clientilor.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindAllCusteomerButtonListener(ActionListener actionListener){
        this.buttonFindAll.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza id-ul unui client care trebuie sa fie adaugat.
     *
     * @return JTextField id data de catre utilizator.
     */
    public JTextField getTextAddCusID() {
        return textAddCusID;
    }

    /**
     * Metoda care returneaza id-ul unui client care trebuie sa fie sters din tabela.
     *
     * @return JTextField id data de catre utilizator.
     */
    public JTextField getTextDelCustomer() {
        return textDelCustomer;
    }

    /**
     * Metoda care returneaza numele unui client.
     *
     * @return JTextField nume data de catre utilizator.
     */
    public JTextField getTextAddCusName() {
        return textAddCusName;
    }

    /**
     * Metoda care returneaza adresa unui client.
     *
     * @return JTextField adresa data de catre utilizator.
     */
    public JTextField getTextAddCusAddress() {
        return textAddCusAddress;
    }

    /**
     * Metoda care returneaza numele unui client care trebuie schimbat.
     *
     * @return JTextField nume data de catre utilizator.
     */
    public JTextField getTextUpdateName() {
        return textUpdateName;
    }

    /**
     * Metoda care returneaza adresa care trebuie schimbata
     *
     * @return JTextField adresa data de catre utilizator.
     */
    public JTextField getTextUpdateAddress() {
        return textUpdateAddress;
    }

    /**
     * Metoda care returneaza id-ul unui client cautat in baza de date.
     *
     * @return JTextField nume data de catre utilizator.
     */
    public JTextField getTextFindID() {
        return textFindID;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonAddCus() {
        return buttonAddCus;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonUpdateName() {
        return buttonUpdateName;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonDelCustomer() {
        return buttonDelCustomer;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonUpdateAddress() {
        return buttonUpdateAddress;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonFindID() {
        return buttonFindID;
    }

    /**
     * Metoda care returneaza un anumit buton.
     *
     * @return JButton returneaza un anumit buton
     */
    public JButton getButtonFindAll() {
        return buttonFindAll;
    }

    /**
     * Metoda care returneaza id-ul unui client care trebuie sa i se schimbe numele.
     *
     * @return JTextField nume data de catre utilizator.
     */
    public JTextField getTextUpdateNameId() {
        return textUpdateNameId;
    }

    /**
     * Metoda care returneaza id-ul unui Client care trebuie sa i se schimbe adresa.
     *
     * @return JTextField adresa data de catre utilizator.
     */
    public JTextField getTextUpdateAddressId() {
        return textUpdateAddressId;
    }
}
