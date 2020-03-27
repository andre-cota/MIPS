
public class Functions {


	public static final String shamt = "00000";
	public static final String funct = "000000";
	static String line;
	static int temp;

	static String functionR(String opcode, String rd, String rs, String rt) { // Monta na ordem correta funções do tipo R (salvo exceções tratadas mais abaixo)
		String function = funct + rs + rt + rd + shamt + opcode;
		return function;
	}

	static String functionI(String opcode, String rt, String rs, String immediate) { // Monta na ordem correta funções do tipo I (salvo exceções tratadas mais abaixo)
		String function = opcode + rs + rt + immediate;
		return function;
	}

	static String functionJ(String opcode, String address) { // Monta na ordem correta funções do tipo J
		String function = opcode + address;
		return function;
	}

	static String functionW(String opcode, String rs, String offset, String base) { // Monta na ordem correta as funções Load Word(lw) e Store Word(sw)
		String function = opcode + base + rs + offset;
		return function;
	}
	
	static String functionM(String opcode, String rs, String rt) { // Monta na ordem correta funções mult e div
		String function = funct + rs + rt + shamt + shamt + opcode;
		return function;
	}
	static String functionS(String opcode, String rd, String rt, String sa) { // Monta na ordem correta funções sll e srl
		String function = funct  + shamt + rt + rd + sa + opcode;
		return function;
	}
	static String functionJr(String opcode, String rs) { // Monta na ordem correta função jr
		String function = funct  + rs + shamt + shamt + shamt + opcode;
		return function;
	}

	static String buildFunction(String[] arguments) {

		try {
			SwitchOp.setOpcode(arguments); 	// Seta o opcode para dar base aos próximos métodos
			switch (SwitchOp.getFormat()) {
			case "R": 						// Trata das funções do tipo R, com exceções
				line = functionR(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.switchVariable(arguments[3]));
				break;
			
			case "I": 					// Trata das funções do tipo I, com exceções
				temp = Integer.parseInt(arguments[3]);
				line = functionI(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.immediateTreatment(DecForBin.binary(temp)));
				break;
			
			case "J":  					// Trata das funções do tipo J
				temp = Integer.parseInt(arguments[1]);
				line = functionJ(SwitchOp.getOpcode(), DecForBin.addressTreatment(DecForBin.binary(temp)));
				break;
			
			
			//Funções que tiveram que ser tratadas diferentes por suas peculiaridades
			
			case "W": 					// Trata das funções lw e sw
				line = functionW(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.baseOffsetTreatment(arguments[2], true), DecForBin.baseOffsetTreatment(arguments[2], false));
				break;
			
			case "M": 						// Trata das funções mult e div
				line = functionM(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]));
				break;
			
			case "S": 						// Trata das funções sll e srl
				temp = Integer.parseInt(arguments[3]);
				line = functionS(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.saTreatment(DecForBin.binary(temp)));
				break;
			
			case "Jr": 						// Trata das funções do tipo R, com exceções
				line = functionJr(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]));
				break;
			
			}
		}
			catch(java.lang.NumberFormatException exception) {
				SwitchOp.error(exception.getMessage() + "\non line: " + arguments[0] + " " + arguments[1] + "[...]");
			}
		return line;
}
}
