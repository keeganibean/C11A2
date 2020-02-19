import java.math.BigDecimal; //EC

public class ATM {

	private BankAccount bankAccount = new BankAccount(new BigDecimal("500")); //instance variable
	
	public void handleTransactions() throws NegativeBalanceException { //instance method
		try {
			bankAccount.withdraw(new BigDecimal("600")); //calls withdraw
		} catch (NegativeBalanceException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}	
		try {
			bankAccount.quickWithdraw(new BigDecimal("600")); //calls quickWithdraw
		} catch (NegativeBalanceException e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws NegativeBalanceException { //main function
		ATM output = new ATM();
		output.handleTransactions();
	}

}
