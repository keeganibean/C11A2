import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal; //EC
import java.text.NumberFormat; //EC
import java.io.PrintWriter;

public class NegativeBalanceException extends Exception{

	private BigDecimal negativeBalance = new BigDecimal("0000"); //instance variable BigDecimal EC
	private static NumberFormat money = NumberFormat.getCurrencyInstance(); //NumberFormat EC
	
	public NegativeBalanceException() { //default constructor
		super("The balance cannot be negative"); //generic error message
	}

	public NegativeBalanceException(BigDecimal negativeBalance) { //parameter constructor
		
		super("Amount exceeds balance by: " + money.format(negativeBalance));
		this.negativeBalance = negativeBalance;
		
		try {
			PrintWriter out; //from FileIO video
			out = new PrintWriter(new FileOutputStream(new File("C:\\Users\\keeganbean\\Desktop\\Java\\C11A2\\logfile.txt"), true)); 
			out.append("Amount exceeds balance by: " + money.format(negativeBalance));
			out.println();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found please input correctly");
		}
		
	}

	@Override
	public String toString() { //toString
		return "Balance: " + money.format(negativeBalance) + " not allowed";
	}
	
	
}
