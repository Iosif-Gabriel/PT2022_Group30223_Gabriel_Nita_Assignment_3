package bll;

import dao.RequestDAO;
import model.Request;

import java.sql.SQLException;
import java.util.List;

/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela request.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class RequestBll {
    private final RequestDAO orderDAO;

    public RequestBll() {
        this.orderDAO = new RequestDAO();
    }

    /**
     * Metoda care gaseste o comanda dupa un id dat prin apelarea metodei din clasa orderDAO.
     *
     * @param id Id-ul comenzii care trebuie cautata.
     * @return Comanda gasita.
     */
    public Request findOrderById(int id) throws NoSuchFieldException {
        return orderDAO.findById(id);
    }

    /**
     * Metoda care adauga o comanda in tabela prin apelarea metodei din clasa orderDAO.
     *
     * @param or Comanda care trebuie adaugata.
     */
    public void insertOrder(Request or){
        orderDAO.insert(or);
    }

    /**
     * Metoda care sterge o comanda din tabela prin apelarea metodei din clasa orderDAO.
     *
     * @param id Id-ul comenzii care trebuie stearsa.
     */
    public void deleteOrder(int id){
        orderDAO.deleteBasedOnId(id);
    }

    /**
     * Metoda care modifica numele unui client dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO.
     *
     * @param id   Id-ul comenzii care trebuie modificata.
     * @param newName Noul nume cu care se schimba numele clientului din comanda actuala.
     */
    public void updateProdName(int id,String newName ) throws SQLException {
        orderDAO.updateProductName(id, newName);
    }

    /**
     * Metoda care modifica numele unui produs dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO.
     *
     * @param id   Id-ul comenzii care trebuie modificata.
     * @param newName Noul nume cu care se schimba numele produsului din comanda actuala.
     */
    public void updateCustomerName(int id, String newName) throws SQLException {
        orderDAO.updateCustomerName(id,newName);
    }

    /**
     * Metoda care modifica pretul unei comanzi in functie de id prin apelarea metodei din clasa orderDAO.
     *
     * @param id    Id-ul comenzii care trebuie modificata.
     * @param newPrice Noul pretul cu care se schimba pretul comenzii actuale.
     */
    public void updateProdPrice(int id,double newPrice) throws SQLException{
        orderDAO.updatePrice(id,newPrice);
    }

    /**
     * Metoda care modifica cantitatea unui produs dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO.
     *
     * @param id       Id-ul comenzii care trebuie modificata.
     * @param newQuantity Noua cantitate cu care se schimba cantitatea produsului din comanda actuala.
     */
    public void updateProdQuantity(int id,int newQuantity) throws SQLException{
        orderDAO.updateQuantity(id,newQuantity);
    }

    /**
     * Metoda care gaseste toate comenzile prin apelarea metodei din clasa orderDAO.
     *
     * @return Lista de comenzi gasite.
     */
    public List<Request> findAllOrders(){
        return orderDAO.findAll();
    }
}
