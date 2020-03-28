
public class SwitchOp {

	private static String opcode;
	private static String format;

	private static void switchOp(String[] argument) {
		switch (argument[0]) { //De acordo com a funcao, sera dado um tipo para ser tratado e o opcode correspondente
		case "add": {
			opcode = "100000";
			format = "R";
			break;
		}
		case "addi": {
			format = "I";
			opcode = "001000";
			break;
		}
		case "sub": {
			format = "R";
			opcode = "100010";
			break;
		}
		case "mult": { //precisou ser tratada de modo diferente as outras do tipo R
			opcode = "011000";
			format = "M";
			break;
		}
		case "div": { //precisou ser tratada de modo diferente as outras do tipo R
			format = "M";
			opcode = "011010";
			break;
		}
		case "neg": {
			format = "M"; //sera montada como as funcoes mult e div
			opcode = "000111";
			break;
		}
		case "and": {
			format = "R";
			opcode = "100100";
			break;
		}
		case "andi": {
			format = "I";
			opcode = "001100";
			break;
		}
		case "or": {
			format = "R";
			opcode = "100101";
			break;
		}
		case "ori": {
			format = "I";
			opcode = "001101";
			break;
		}
		case "xor": {
			opcode = "100110";
			break;
		}
		case "nor": {
			format = "R";
			opcode = "100111";
			break;
		}
		case "slt": {
			format = "R";
			opcode = "101010";
			break;
		}
		case "slti": {
			format = "I";
			opcode = "001010";
			break;
		}
		case "sll": {
			format = "S"; //precisou ser tratada de modo diferente as outras do tipo R
			opcode = "000000";
			break;
		}
		case "srl": {
			format = "S"; //precisou ser tratada de modo diferente as outras do tipo R
			opcode = "000010";
			break;
		}
		case "lw": {
			format = "W"; //precisou ser tratada de modo diferente as outras do tipo I
			opcode = "100011";
			break;
		}
		case "sw": {
			format = "W"; //precisou ser tratada de modo diferente as outras do tipo I
			opcode = "101011";
			break;
		}
		case "beq": {
			format = "I";
			opcode = "000100";
			break;
		}
		case "bne": {
			format = "I";
			opcode = "000101";
			break;
		}
		case "j": {
			format = "J";
			opcode = "000010";
			break;
		}
		case "jr": {
			format = "Jr"; //precisou ser tratada de modo diferente as outras do tipo R
			opcode = "001000";
			break;
		}
		case "jal": {
			format = "J";
			opcode = "000011";
			break;
		}
		case "nop": {
			format = "N";
			opcode = "000000";
			break;
		}
		default: {
			error(argument[0]);
			break;
		}
		}
	}

	public static void setOpcode(String[] argument) {
		switchOp(argument);
	}

	public static String getOpcode() {
		return opcode;
	}

	public static String getFormat() {
		return format;
	}
	
	public static void error(String argumento) {
		System.out.println("*********************Warning**********************");
		System.out.println(argumento);
		System.out.println("Please, check the notes!");
		System.out.println("**************************************************");
		System.exit(1);
	}
}
