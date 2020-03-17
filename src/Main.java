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
			String operador = function[0];
			switch(operador) {
			case "add":{
				System.out.println("A função '" + function[0] + "' é uma soma");
				break;
			}
			case "addi":{
				System.out.println("A função '" + function[0] + "' é uma soma imedita");
				break;
			}
			case "sub":{
				System.out.println("A função '" + function[0] + "' é uma subtração");
				break;
			}
			case "mult":{
				System.out.println("A função '" + function[0] + "' é uma multiplicação");
				break;
			}
			case "div":{
				System.out.println("A função '" + function[0] + "' é uma divisão");
				break;
			}
			case "neg":{
				System.out.println("A função '" + function[0] + "' é uma negação");
				break;
			}
			case "and":{
				System.out.println("A função '" + function[0] + "' é um 'E'");
				break;
			}
			case "andi":{
				System.out.println("A função '" + function[0] + "' é uma 'E' imediato");
				break;
			}
			case "or":{
				System.out.println("A função '" + function[0] + "' é um ou");
				break;
			}
			case "ori":{
				System.out.println("A função '" + function[0] + "' é um ou imediato");
				break;
			}
			case "xor":{
				System.out.println("A função '" + function[0] + "' é um ou exclusivo");
				break;
			}
			case "nor":{
				System.out.println("A função '" + function[0] + "' é um ou com negação");
				break;
			}
			case "slt":{
				System.out.println("A função '" + function[0] + "' é um armazena 1 se menor");
				break;
			}
			case "slti":{
				System.out.println("A função '" + function[0] + "' é um armazena 1 se menor imediato");
				break;
			}
			case "sll":{
				System.out.println("!");
				break;
			}
			case "srl":{
				System.out.println("!");
				break;
			}
			case "lw":{
				System.out.println("A função '" + function[0] + "' é um carregamento de palavra");
				break;
			}
			case "sw":{
				System.out.println("A função '" + function[0] + "' é um armazenamento de palavra");
				break;
			}
			case "beq":{
				System.out.println("A função '" + function[0] + "' é um desvio se igual");
				break;
			}
			case "bne":{
				System.out.println("A função '" + function[0] + "' é um desvio se diferente");
				break;
			}
			case "j":{
				System.out.println("A função '" + function[0] + "' é um salto");
				break;
			}
			case "jr":{
				System.out.println("A função '" + function[0] + "' é um salto de registrador");
				break;
			}
			case "jal":{
				System.out.println("A função '" + function[0] + "' é uma chamda de função");
				break;
			}
			case "nop":{
				System.out.println("!");
				break;
			}
			
			
				
			}
		}
	}
}
