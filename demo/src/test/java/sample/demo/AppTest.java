package sample.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AppTest {

	CreditCardValidator creditCardValidator= new CreditCardValidator();

	@ParameterizedTest
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
	public void should__check_creditCardValidator_test(boolean expected, String given) {
		Assertions.assertEquals(expected, creditCardValidator.validateCard(given), given);
	}

}
