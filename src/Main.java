import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static final String shamt = "00000";
	public static final String funct = "000000";

	public static void main(String[] args) throws IOException {
		

		FileReader ler = new FileReader(new File(args[0]));
		BufferedReader origem = new BufferedReader(ler);
		String linha = null;
		while ((linha = origem.readLine()) != null) { // Ler linha por linha do arquivo
			String[] argument = linha.split(" ");
			Functions.buildFunction(argument);
			
		}
		//System.out.printf(SwitchOp.getOpcode() + "01000" + "01001"+ "01010" + shamt, funct);
		
		//System.out.println("\n");
		//System.out.println(DecForBin.savedTemporaries("$s4"));
	}
	
	public static void error(String argumento) {
		System.out.println("*********************Warning**********************");
		System.out.println("Error on read: " + argumento);
		System.out.println("Please, check the notes!");
		System.out.println("**************************************************");
		System.exit(1);
	}
}