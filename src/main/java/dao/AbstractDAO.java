package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * Clasa care contine metoda de accesare a bazei de date.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	/**
	 * Metoda care creaza query-ul de modificare a unui camp de pe un rand in functie de o coloana.
	 *
	 * @param coulumn Campul care se vrea modificat.
	 * @param field  Coloana dupa care se cauta randul care trebuie modificat.
	 * @return String query-ul.
	 */
	public String createUpdateQuery(String coulumn, String field){
		return "UPDATE " +
				type.getSimpleName() +
				" SET " + coulumn + " =? " +
				" WHERE " + field + " =? ";
	}

	/**
	 * Metoda care creaza query-ul de selectare dupa o anumita coloana.
	 *
	 * @return String query-ul.
	 */
	private String createSelectQuery() {
		return "SELECT " +
				" * " +
				" FROM " +
				type.getSimpleName() +
				" WHERE " + "id" + " =?";
	}

	/**
	 * Metoda care creaza query-ul de selectare a tuturor elementelor dintr-o tabela.
	 *
	 * @return String query-ul.
	 */
	private String createSelectAllQuery() {
		return " SELECT " +
				" * " +
				" FROM " +
				type.getSimpleName();
	}

	/**
	 * Metoda care creaza query-ul de stergere a unui rand dintr-o tabela.
	 *
	 * @return String query-ul.
	 */
	private String deleteFromQuery(){
		return " DELETE " +
				"FROM " +
				type.getSimpleName() +
				" WHERE " + "id" + " =?";
	}

	/**
	 * Metoda care creaza query-ul de modificare a unui camp de pe un rand in functie de o coloana.
	 *
	 * @param column Campul care se vrea modificat.
	 * @param field  Coloana dupa care se cauta randul care trebuie modificat.
	 * @return String query-ul.
	 */
	public String updateQuery(String column, String field){
		return " UPDATE " +
				type.getSimpleName() +
				" SET " + column + "=?" +
				" WHERE " + field + "=?";
	}

	/**
	 * Metoda care insereaza un rand intr-o tabela.
	 *
	 * @return String query-ul.
	 */
	private String insertQuery(){
		StringBuilder builder=new StringBuilder();
		builder.append("INSERT INTO ");
		builder.append(type.getSimpleName());
		builder.append(" (");
		int j=0;
		for (Field f: type.getDeclaredFields()){
			String fname=f.getName();
			j++;
			if(j==type.getDeclaredFields().length){
				builder.append(fname+")");
			}else{
				builder.append(fname + ",");
			}
		}
		builder.append(" VALUES");
		builder.append(" (");
		for(int k=0; k<j; k++){
			if(k==j-1){
				builder.append("?)");
			}
			else{
				builder.append("?,");
			}
		}
		return builder.toString();
	}

	/**
	 * Metoda care gaseste toate elementele dintr-o tabela.
	 *
	 * @return Lista de elemente din tabela.
	 */
	public List<T> findAll() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String query= createSelectAllQuery();
		try {
		connection=ConnectionFactory.getConnection();
		preparedStatement=connection.prepareStatement(query);
		resultSet=preparedStatement.executeQuery();
		return createObjects(resultSet);
		} catch (SQLException e) {
		LOGGER.log(Level.WARNING, type.getName() + "DAO:findALL " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(preparedStatement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Metoda care cauta un element intr-o tabela dupa id.
	 *
	 * @param id Id-ul elementului cautat.
	 * @return Elementul cautat.
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Metoda care sterge un element dintr-o tabela in functie de id.
	 *
	 * @param id Id-ul elementului care se vrea sters.
	 */
	public void deleteBasedOnId(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		String q=deleteFromQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(q);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteBaseOnId " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

	}

	/**
	 * Metoda care creeaza o lista de elemente care se afla intr-o anumita tabela in functie de rezultatul returnat de query.
	 *
	 * @param resultSet Rezultatul returnat de query-ul efectuat.
	 * @return Lista de elemente gasite in rezultatul returnat de query.
	 */
	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		Constructor[] ctors = type.getDeclaredConstructors();
		Constructor ctor = null;
		for (int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericParameterTypes().length == 0)
				break;
		}
		try {
			while (resultSet.next()) {
				ctor.setAccessible(true);
				T instance = (T)ctor.newInstance();
				for (Field field : type.getDeclaredFields()) {
					String fieldName = field.getName();
					Object value = resultSet.getObject(fieldName);
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Metoda care adauga un element intr-o tabela.
	 *
	 * @param t Elementul care trebuie adaugat.
	 * @return Elementul primit ca parametru.
	 */
	public T insert(T t) {
		Connection con=null;
		PreparedStatement stat=null;
		String q=insertQuery();
		try{
			con=ConnectionFactory.getConnection();
			stat=con.prepareStatement(q);
			int j=1;
			for (Field f : type.getDeclaredFields()){
				PropertyDescriptor descriptor=new PropertyDescriptor(f.getName(),type);
				Method m=descriptor.getReadMethod();
				stat.setObject(j++, m.invoke(t));
			}
			stat.executeUpdate();
			return t;
		}catch(SQLException | IntrospectionException e){
			LOGGER.log(Level.WARNING, type.getName() + "DAO:Insert " + e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(stat);
			ConnectionFactory.close(con);
		}
		return null;
	}

	/**
	 * Metoda care modifica numele unui client sau a unui produs.
	 *
	 * @param id   Id-ul clientului/produsului caruia i se vrea schimbat numele.
	 * @param newName Noul nume cu care se vrea sa fie schimbat numele existent.
	 */
	public void updateNameProdCus(int id,String newName){
		Connection connection = null;
		PreparedStatement statement = null;
		String q=updateQuery("name","id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(q);
			statement.setString(1,newName);
			statement.setInt(2,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:updateName " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
