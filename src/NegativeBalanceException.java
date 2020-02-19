import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.io.PrintWriter;

public class NegativeBalanceException extends Exception{

	private BigDecimal negativeBalance = new BigDecimal("0"); //instance variable
	private static NumberFormat money = NumberFormat.getCurrencyInstance();
	
	public NegativeBalanceException() { //default constructor
		super("Error: negative balance"); //generic error message
	}

	public NegativeBalanceException(BigDecimal negativeBalance) { //parameter constructor
		
		super("Amount exceeds balance by " + money.format(negativeBalance));
		this.negativeBalance = negativeBalance;
		
		try {
			PrintWriter out; //from FileIO video
			out = new PrintWriter(new FileOutputStream(new File("C:\\Users\\keeganbean\\Desktop\\Java\\C11A2\\logfile.txt"), true)); 
			out.append("Amount exceeds balance by " + money.format(negativeBalance));
			out.println();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}

	@Override
	public String toString() { //toString
		return "Balance of " + money.format(negativeBalance) + " not allowed";
	}
	
	
}
