package bll.validators;

import model.Product;

/**
 * Clasa care cotine metoda de validare a cantitatii unui produs.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class QuantityValidator implements Validator<Product> {
	private static final int MIN_QUANTITY = 1;
	private static final int MAX_QUANTITY = 100;

	/**
	 * Metoda care verifica daca cantitatea introdus se afla in intervalul dat.
	 *
	 * @param product Produsul pentru care se face validarea.
	 */
	@Override
	public void validate(Product product) {
		if(product.getQuantity() < MIN_QUANTITY || product.getQuantity() >MAX_QUANTITY){
			throw new IllegalArgumentException("The quantity limit isn't respected!\nMIN: "+MIN_QUANTITY +"\nMAX: "+MAX_QUANTITY);
		}
	}
}
