package bll.validators;

import model.Product;

/**
 * Clasa care cotine metoda de validare a pretului unui produs.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class PriceValidator implements Validator<Product> {
    private static final double MIN_PRICE=10;
    private static final double MAX_PRICE=510;

    /**
     * Metoda care verifica daca pretul introdus se afla in intervalul dat.
     *
     * @param product Produsul pentru care se face validarea.
     */
    @Override
    public void validate(Product product) {
        if(product.getPrice() < MIN_PRICE || product.getPrice()> MAX_PRICE){
            throw new IllegalArgumentException("The price limit is not respected!\nMIN: " + MIN_PRICE + "\nMAX:"  + MAX_PRICE);
        }
    }
}
