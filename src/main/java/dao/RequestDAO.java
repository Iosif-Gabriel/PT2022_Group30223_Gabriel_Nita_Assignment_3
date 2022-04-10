package dao;

import connection.ConnectionFactory;
import model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clasa care contine metoda de accesare a bazei de date request.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class RequestDAO extends AbstractDAO<Request>{
    /**
     * Metoda care modifica pretul unui produs din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea pretul.
     * @param newPrice Noul pret care inlocuieste pretul existent pentru produsul dat.
     */
    public void updatePrice(int id,double newPrice) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery("price", "id");
        connection= ConnectionFactory.getConnection();
        statement=connection.prepareStatement(query);
        statement.setDouble(1, newPrice);
        statement.setInt(2, id);
        statement.executeUpdate();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }

    /**
     * Metoda care modifica Numele unui produs pentru care se doreste modificarea numelui.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea numelui.
     * @param newName Noul nume care inlocuieste Numele existent pentru clientul dat.
     */
    public void updateCustomerName(int id,String newName) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery("customerName", "id");
        connection= ConnectionFactory.getConnection();
        statement=connection.prepareStatement(query);
        statement.setString(1, newName);
        statement.setInt(2, id);
        statement.executeUpdate();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }

    /**
     * Metoda care modifica Numele unui produs pentru care se doreste modificarea numelui.
     *
     * @param id      Id-ul produsului pentru care se doreste modificarea numelui.
     * @param newName Noul nume care inlocuieste Numele existent pentru produsul dat.
     */
    public void updateProductName(int id,String newName) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery("productName", "id");
        connection= ConnectionFactory.getConnection();
        statement=connection.prepareStatement(query);
        statement.setString(1, newName);
        statement.setInt(2, id);
        statement.executeUpdate();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }

    /**
     * Metoda care modifica cantitatea unui produs din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea cantitatii.
     * @param newQuantity Noua cantitate care inlocuieste cantitatea existent pentru produsul dat.
     */
    public void updateQuantity(int id,int newQuantity) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery("quantity", "id");
        connection= ConnectionFactory.getConnection();
        statement=connection.prepareStatement(query);
        statement.setInt(1, newQuantity);
        statement.setInt(2, id);
        statement.executeUpdate();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }
}
