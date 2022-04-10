package bll;

import dao.CustomerDAO;
import model.Customer;

import java.sql.SQLException;
import java.util.List;
/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela customer.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class CustomerBll {
    private final CustomerDAO customerDAO;

    public CustomerBll(){
        customerDAO=new CustomerDAO();
    }

    /**
     * Metoda care gaseste un client dupa un id dat prin apelarea metodei din clasa clientDAO.
     *
     * @param id Id-ul clientului care trebuie cautat.
     * @return Clientul gasit.
     */
    public Customer findClientById(int id) throws NoSuchFieldException {
        return customerDAO.findById(id);
    }

    /**
     * Metoda care adauga un client in tabela prin apelarea metodei din clasa clientDAO.
     *
     * @param cus Clientul care trebuie adaugat.
     */
    public void insertCustomer(Customer cus){
        customerDAO.insert(cus);
    }

    /**
     * Metoda care sterge un client din tabela prin apelarea metodei din clasa clientDAO.
     *
     * @param id Id-ul clientului care trebuie sters.
     */
    public void deleteCustomer(int id){
        customerDAO.deleteBasedOnId(id);
    }

    /**
     * Metoda care modifica numele unui client in functie de id prin apelarea metodei din clasa clientDAO.
     *
     * @param id   Id-ul clientului.
     * @param newName Noul numele cu care se schimba numele clientului actual.
     */
    public void updateName(int id, String newName){
        customerDAO.updateNameProdCus(id,newName);
    }

    /**
     * Metoda care modifica adresa unui client in functie de id prin apelarea metodei din clasa clientDAO.
     *
     * @param id      Id-ul clientului.
     * @param newAddress Noua adresa cu care se schimba adresa clientului actual.
     */
    public void updateAddress(int id,String newAddress) throws SQLException {
        customerDAO.updateAddress(id,newAddress);
    }

    /**
     * Metoda care gaseste toti clientii prin apelarea metodei din clasa clientDAO.
     *
     * @return Lista de clienti gasiti.
     */
    public List<Customer> findAllCustomers(){
        return customerDAO.findAll();
    }
}
