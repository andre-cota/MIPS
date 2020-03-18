import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		FileReader ler = new FileReader(new File(args[0]));
		BufferedReader origem = new BufferedReader(ler);
		String linha = null;
		while ((linha = origem.readLine()) != null) { // Ler linha por linha do arquivo
			String[] function = linha.split(" ");
			SwitchOp.setOp(function[0]);

		}
	}
}