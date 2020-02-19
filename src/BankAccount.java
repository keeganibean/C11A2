import java.math.BigDecimal;

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
		}
	}
	
	public void quickWithdraw(BigDecimal amount) throws NegativeBalanceException { //second instance
		if (amount.compareTo(balance) == 1) { //if amount is greater than balance
			throw new NegativeBalanceException(); //
		} else {
			balance.subtract(amount); //updates amount
		}
	}
}
