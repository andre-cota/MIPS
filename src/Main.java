import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {
			FileReader openIn = new FileReader(new File(args[0]));
			BufferedReader in = new BufferedReader(openIn);
			BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
			
			String linha = null;
			while ((linha = in.readLine()) != null) { // Ler linha por linha do arquivo
				String[] argument = linha.split(" ");
				out.write(Functions.buildFunction(argument));
				out.newLine();
			}
			in.close();
			out.close();

		} catch (IOException exception) {
			System.out.println("*********************Warning**********************");
			System.out.println(exception.getMessage());
			System.out.println("Please, check the notes!");
			System.out.println("**************************************************");
		}
	}

}