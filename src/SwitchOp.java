
public class SwitchOp {

	private static String opcode;
	private static String format;

	private static void switchOp(String argument) {
		switch (argument) {
		case "add": {
			format = "R";
			opcode = "100000";
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
		case "mult": {
			opcode = "011000";
			break;
		}
		case "div": {
			format = "R";
			opcode = "011010";
			break;
		}
		case "neg": {
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
			format = "R";
			opcode = "000000";
			break;
		}
		case "srl": {
			format = "R";
			opcode = "000010";
			break;
		}
		case "lw": {
			format = "I";
			opcode = "100011";
			break;
		}
		case "sw": {
			format = "I";
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
			format = "R";
			opcode = "001000";
			break;
		}
		case "jal": {
			format = "J";
			opcode = "000011";
			break;
		}
		case "nop": {
			opcode = "000000";
			break;
		}
		default: {
			Label.setLabel(argument);
			break;
		}
		}
	}

	public static void setOpcode(String operador) {
		switchOp(operador);
	}

	public static String getOpcode() {
		return opcode;
	}

	public static String getFormat() {
		return format;
	}
}
