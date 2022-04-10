package start;

import java.sql.SQLException;
import java.util.logging.Logger;

import presentation.Controller;
import presentation.CustomerView;
import presentation.RequestView;
import presentation.ProductView;
/**
 * Clasa care cotine metoda main
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
	/**
	 * Metoda main contine instantieri ale claselor responsabil de interfata grafica a aplicatiei si instantierea controller-ului.
	 *
	 * @param args Parametrul specific metodei MAIN.
	 */
	public static void main(String[] args) throws SQLException {
		CustomerView customerView= new CustomerView();
		ProductView productView=new ProductView();
		RequestView orderView=new RequestView();
		Controller controller=new Controller(productView,customerView,orderView);
		orderView.setVisible(true);
		customerView.setVisible(true);
		productView.setVisible(true);

	}

}
