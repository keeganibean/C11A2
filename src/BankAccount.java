/*
 * @author Keegan Bean
 * @author Mark Baldwin
 * @author Cyndi Rader
 */

import java.math.BigDecimal; //EC

/*
 * BankAccount class
 * Class that implements both withdraw and quickWithdraw
 * Sets the balance of each for output
 */
public class BankAccount {
	private BigDecimal balance; //instance variable type double

	public BankAccount(BigDecimal balance) { //parameter constructor
		super();
		this.balance = balance;
	}
	
	public void withdraw(BigDecimal amount) throws NegativeBalanceException { //Instance method
		if (amount.compareTo(balance) == 1) { //if the amount is greater than the balance
			throw new NegativeBalanceException(balance.subtract(amount)); //if it is greater throw exception
		} else {
			balance.subtract(amount); //updates the balance
			BigDecimal newBalance = balance.subtract(amount); //updates newBalance for output
			System.out.println("Your new balance is: " + newBalance); //outputs when no exception is thrown to let them know their new balance
		}
	}
	
	public void quickWithdraw(BigDecimal amount) throws NegativeBalanceException { //second instance
		if (amount.compareTo(balance) == 1) { //if amount is greater than balance
			throw new NegativeBalanceException(); //throws with no parameters
		} else {
			balance.subtract(amount); //updates amount
			BigDecimal newBalance = balance.subtract(amount); //updates newBalance for output
			System.out.println("Your new balance is: " + newBalance); //outputs when no exception is thrown to let them know their new balance
		}
	}
}
