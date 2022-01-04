package sample.demo;

public class CreditCardValidator {

	public boolean validateCard(String creditCardNumber) {

		//The following is a credit card check algorithm:
		//From the last digit moving backwards, double every second digit
		//If the doubled number is greater than 9,
		//add its two digits together Sum all card digits together If the total ends in a zero,
		//then the number is a valid credit card

		final int[] toggle = {1};

		return creditCardNumber.chars()
				.filter(i->Character.isDigit(i))
				.map(i->i-'0')
				.map(i->i *(toggle[0]= toggle[0]==1?2:1))
				.map(i->i>9?i-9:i)
				.sum()%10==0;

	}

}
