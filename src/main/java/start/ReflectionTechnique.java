package start;

import java.lang.reflect.Field;
/**
 * Clasa care folosete tehnica reflexiei pentru a extrage proprietatile si valorile din baza de date
 *
 * @author Nita Iosif-Gabriel
 * @version 10.04
 * @since 10.04.2022
 */
public class ReflectionTechnique {
	/**
	 * Metoda care extrage proprietatile unui obiect.
	 *
	 * @param obj Obiectul caruia vrem sa ii extragem proprietatile.
	 * @return String[] Vectorul de proprietati ai obiectului primit ca parametru.
	 */

	public static String[] retrieveFieldProperties(Object obj) {
		String[] sub = new String[obj.getClass().getDeclaredFields().length];
		int k = 0;
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				sub[k] = f.getName();
				k++;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return sub;
	}

	/**
	 * Metoda care extrage valorile proprietatilor unui obiect.
	 *
	 * @param obj Obiectul caruia vrem sa ii extragem valorile proprietatilor.
	 * @return String[] Vectorul de valori ale proprietatilor obiectului primit ca parametru.
	 */
	public static String[] retrieveValueProperties(Object obj) {
		String[] sub = new String[obj.getClass().getDeclaredFields().length];
		int k = 0;
		for (Field f : obj.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			Object value;
			try {
				value = f.get(obj);
				sub[k] = "" + value;
				k++;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sub;
	}
}



