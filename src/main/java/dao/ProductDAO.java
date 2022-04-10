package dao;

import connection.ConnectionFactory;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clasa care contine metoda de accesare a bazei de date product.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class ProductDAO extends AbstractDAO<Product>{
    /**
     * Metoda care modifica pretul unui produs din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea adresei.
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
     * Metoda care modifica cantitatea unui produs din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea adresei.
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
