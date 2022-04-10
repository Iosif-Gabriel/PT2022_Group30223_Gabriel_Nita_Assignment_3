package bll;



import bll.validators.PriceValidator;
import bll.validators.QuantityValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela product.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class ProductBll {
    private final ProductDAO productDAO;
    private final List<Validator<Product>> validators;

    public ProductBll() {
        this.productDAO = new ProductDAO();
        validators = new ArrayList<>();
        validators.add(new QuantityValidator());
        validators.add(new PriceValidator());
    }

    /**
     * Metoda care gaseste un produs dupa un id dat prin apelarea metodei din clasa productDAO.
     *
     * @param id Id-ul produsului care trebuie cautat.
     * @return Produsul gasit.
     */
    public Product findProductById(int id) throws NoSuchFieldException {
        return productDAO.findById(id);
    }

    /**
     * Metoda care adauga un produs in tabela prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param prod Produsul care trebuie adaugat.
     */
    public void insertProduct(Product prod){
       productDAO.insert(prod);
    }

    /**
     * Metoda care sterge un produs din tabela prin apelarea metodei din clasa productDAO.
     *
     * @param id Id-ul produsului care trebuie sters.
     */
    public void deleteProduct(int id){
        productDAO.deleteBasedOnId(id);
    }

    /**
     * Metoda care modifica numele unui produs in functie de id prin apelarea metodei din clasa productDAO.
     *
     * @param id   Id-ul produsului care trebuie modificat.
     * @param newName Noul nume cu care se schimba numele produsului actual.
     */
    public void updateName(int id,String newName){
        productDAO.updateNameProdCus(id,newName);
    }

    /**
     * Metoda care modifica cantitatea unui produs in functie de id prin apelarea metodei din clasa productDAO.
     *
     * @param id       Id-ul produsului care trebuie modificat.
     * @param quantity Noua cantitate cu care se schimba cantitatea produsului actual.
     */
    public void updateQuantity(int id,int quantity) throws SQLException {
        productDAO.updateQuantity(id,quantity);
    }

    /**
     * Metoda care modifica pretul unui produs in functie de id prin apelarea metodei din clasa productDAO.
     *
     * @param id    Id-ul produsului care trebuie modificat.
     * @param newPrice Noul pret cu care se schimba pretul produsului actual.
     */
    public void updatePrice(int id,double newPrice) throws SQLException {
        productDAO.updatePrice(id,newPrice);
    }

    /**
     * Metoda care gaseste toate produsele prin apelarea metodei din clasa productDAO.
     *
     * @return Lista de produse gasite.
     */
    public List<Product> findAllProducts(){
        return productDAO.findAll();
    }


    /**
     * Metoda care obtine validatorii declarati pentru clasa curenta pentru a valida o intrare.
     *
     * @return Lista de validatori.
     */
    public List<Validator<Product>> getValidators() {
        return validators;
    }
}
