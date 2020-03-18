
public class SwitchOp {
	
	private static String op;
	
	private static void switchOp(String operador) {
		switch (operador) {
		case "add": {
			System.out.println("A função '" + operador + "' é uma soma");
			op = "100000";
			break;
		}
		case "addi": {
			System.out.println("A função '" + operador + "' é uma soma imedita");
			op = "001000";
			break;
		}
		case "sub": {
			System.out.println("A função '" + operador + "' é uma subtração");
			op = "100010";
			break;
		}
		case "mult": {
			System.out.println("A função '" + operador + "' é uma multiplicação");
			op = "011000";
			break;
		}
		case "div": {
			System.out.println("A função '" + operador + "' é uma divisão");
			op = "011010";
			break;
		}
		case "neg": {
			System.out.println("A função '" + operador + "' é uma negação");
			op = "000111";
			break;
		}
		case "and": {
			System.out.println("A função '" + operador + "' é um 'E'");
			op = "100100";
			break;
		}
		case "andi": {
			System.out.println("A função '" + operador + "' é uma 'E' imediato");
			op = "001100";
			break;
		}
		case "or": {
			System.out.println("A função '" + operador + "' é um ou");
			op = "100101";
			break;
		}
		case "ori": {
			System.out.println("A função '" + operador + "' é um ou imediato");
			op = "001101";
			break;
		}
		case "xor": {
			System.out.println("A função '" + operador + "' é um ou exclusivo");
			op = "100110";
			break;
		}
		case "nor": {
			System.out.println("A função '" + operador + "' é um ou com negação");
			op = "100111";
			break;
		}
		case "slt": {
			System.out.println("A função '" + operador + "' é um armazena 1 se menor");
			op = "101010";
			break;
		}
		case "slti": {
			System.out.println("A função '" + operador + "' é um armazena 1 se menor imediato");
			op = "001010";
			break;
		}
		case "sll": {
			System.out.println("!");
			op = "000000";
			break;
		}
		case "srl": {
			System.out.println("!");
			op = "000010";
			break;
		}
		case "lw": {
			System.out.println("A função '" + operador + "' é um carregamento de palavra");
			op = "100011";
			break;
		}
		case "sw": {
			System.out.println("A função '" + operador + "' é um armazenamento de palavra");
			op = "101011";
			break;
		}
		case "beq": {
			System.out.println("A função '" + operador + "' é um desvio se igual");
			op = "000100";
			break;
		}
		case "bne": {
			System.out.println("A função '" + operador + "' é um desvio se diferente");
			op = "000101";
			break;
		}
		case "j": {
			System.out.println("A função '" + operador + "' é um salto");
			op = "000010";
			break;
		}
		case "jr": {
			System.out.println("A função '" + operador + "' é um salto de registrador");
			op = "001000";
			break;
		}
		case "jal": {
			System.out.println("A função '" + operador + "' é uma chamda de função");
			op = "000011";
			break;
		}
		case "nop": {
			System.out.println("!");
			op = "000000";
			break;
		}
		default: {
			//chamar função de rótulos
		}
		}
	}

	public static void setOp(String operador) {
		switchOp(operador);
	}

	public static String getOp() {
		return op;
	}
}
