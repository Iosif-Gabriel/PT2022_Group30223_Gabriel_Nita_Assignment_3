package bll.validators;

/**
 * Interfata care contine metoda de validare.
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public interface Validator<T> {
	/**
	 * Metoda de validare a unui obiect.
	 *
	 * @param t Obiectul de validat.
	 */
	public void validate(T t);
}
