package dao;

import connection.ConnectionFactory;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clasa care contine metoda de accesare a bazei de date customer.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class CustomerDAO extends AbstractDAO<Customer> {
    /**
     * Metoda care modifica adresa unui client din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea adresei.
     * @param newAddress Noua Adresa care inlocuieste adresa existenta pentru clientul dat.
     */
    public void updateAddress(int id,String newAddress) throws SQLException {
        Connection connection=null;
        PreparedStatement statement=null;
        String query=createUpdateQuery("address", "id");
        connection= ConnectionFactory.getConnection();
        statement=connection.prepareStatement(query);
        statement.setString(1, newAddress);
        statement.setInt(2, id);
        statement.executeUpdate();
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }

}
