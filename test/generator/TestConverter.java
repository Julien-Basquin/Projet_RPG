package generator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import util.Converter;

public class TestConverter {
	
	private enum TestConverterEnum {
		A, B, C;
	}
	
	@Test
	void testConverter() {
		String[] array = new String[TestConverterEnum.values().length];
		array = Converter.enumToStringArray(TestConverterEnum.class);
		String[] expected = {"A","B","C"};
		
		assertArrayEquals(expected, array, "Arrays not equals");
	}
}
