package util;

/**
 * @author Julien B.
 *
 * Classe regoupant des outils de conversion.
 */

public class Converter {
	public static String[] enumToStringArray(Class<?> enumeration) {
		String[] array = new String[enumeration.getEnumConstants().length];
		
		for (int i = 0; i < enumeration.getEnumConstants().length; i++) {
			array[i] = enumeration.getEnumConstants()[i].toString();
		}
		
		return array;
	}
}
