package util;

/**
 * Classe regoupant des outils de conversion.
 * 
 * @author Julien B.
 */

public class Converter {
	/**
	 * Convertion des constantes d'une Enum en tableau de String
	 * 
	 * @param enumeration	Classe de l'Enum (Enum.class)
	 * @return	Les constantes de l'Enum dans un tableau de String
	 */
	public static String[] enumToStringArray(Class<? extends Enum<?>> enumeration) {
		String[] array = new String[enumeration.getEnumConstants().length];
		
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			array[i] = enumeration.getEnumConstants()[i].toString();
		}
		
		return array;
	}
}
