
public class Functions {


	public static final String shamt = "00000";
	public static final String funct = "000000";
	static String line;
	static int temp;

	static String functionR(String opcode, String rd, String rs, String rt) { // Monta na ordem correta funcoes do tipo R (salvo excecoes tratadas mais abaixo)
		String function = funct + rs + rt + rd + shamt + opcode;
		return function;
	}

	static String functionI(String opcode, String rt, String rs, String immediate) { // Monta na ordem correta funcoes do tipo I (salvo excecoes tratadas mais abaixo)
		String function = opcode + rs + rt + immediate;
		return function;
	}

	static String functionJ(String opcode, String address) { // Monta na ordem correta funcoes do tipo J
		String function = opcode + address;
		return function;
	}

	static String functionW(String opcode, String rs, String offset, String base) { // Monta na ordem correta as funcoes Load Word(lw) e Store Word(sw)
		String function = opcode + base + rs + offset;
		return function;
	}
	
	static String functionM(String opcode, String rs, String rt) { // Monta na ordem correta funcoes mult e div
		String function = funct + rs + rt + shamt + shamt + opcode;
		return function;
	}
	static String functionS(String opcode, String rd, String rt, String sa) { // Monta na ordem correta funcoes sll e srl
		String function = funct  + shamt + rt + rd + sa + opcode;
		return function;
	}
	static String functionJr(String opcode, String rs) { // Monta na ordem correta funcao jr
		String function = funct  + rs + shamt + shamt + shamt + opcode;
		return function;
	}

	static String buildFunction(String[] arguments) {

		try {
			SwitchOp.setOpcode(arguments); 	// Seta o opcode para dar base aos proximos metodos
			switch (SwitchOp.getFormat()) {
			case "R": 						// Trata das funcoes do tipo R, com exceções
				line = functionR(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.switchVariable(arguments[3]));
				break;
			
			case "I": 					// Trata das funcoes do tipo I, com excecoes
				temp = Integer.parseInt(arguments[3]);
				line = functionI(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.immediateTreatment(DecForBin.binary(temp)));
				break;
			
			case "J":  					// Trata das funcoes do tipo J
				temp = Integer.parseInt(arguments[1]);
				line = functionJ(SwitchOp.getOpcode(), DecForBin.addressTreatment(DecForBin.binary(temp)));
				break;
			
			
			//Funcoes que tiveram que ser tratadas diferentes por suas peculiaridades
			
			case "W": 					// Trata das funcoes lw e sw
				line = functionW(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.baseOffsetTreatment(arguments[2], true), DecForBin.baseOffsetTreatment(arguments[2], false));
				break;
			
			case "M": 						// Trata das funcoes mult e div
				line = functionM(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]));
				break;
			
			case "S": 						// Trata das funcoes sll e srl
				temp = Integer.parseInt(arguments[3]);
				line = functionS(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
						DecForBin.switchVariable(arguments[2]), DecForBin.saTreatment(DecForBin.binary(temp)));
				break;
			
			case "Jr": 						// Trata das funçao jr
				line = functionJr(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]));
				break;
			case "N": 						// Trata das funcoes do tipo R, com excecoes
				line = functionJr(SwitchOp.getOpcode(), shamt);
				break;
			
			}
		}
			catch(java.lang.NumberFormatException exception) {
				SwitchOp.error(exception.getMessage() + "\non line: " + arguments[0] + " " + arguments[1] + "[...]");
			}
		return line;
}
}
