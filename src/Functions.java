
public class Functions {

	static String line;
	static int temp;

	static String functionR(String opcode, String rd, String rs, String rt, String shamt, String funct) {
		String function = funct + rs + rt + rd + shamt + opcode;
		return function;
	}

	static String functionI(String opcode, String rt, String rs, String immediate) {
		String function = opcode + rs + rt + immediate;
		return function;
	}

	static String functionJ(String opcode, String address) {
		String function = opcode + address;
		return function;
	}

	static String functionW(String opcode, String rs, String immediate) {
		String function = opcode + rs + immediate;
		return function;
	}

	static void buildFunction(String[] arguments) {

		SwitchOp.setOpcode(arguments);
		if (SwitchOp.getFormat() == "R") {
			line = functionR(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
					DecForBin.switchVariable(arguments[2]), DecForBin.switchVariable(arguments[3]), Main.shamt,
					Main.funct);
		} else if (SwitchOp.getFormat() == "I") {
			temp = Integer.parseInt(arguments[3]);
			line = functionI(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]),
					DecForBin.switchVariable(arguments[2]), DecForBin.immediateTreatment(DecForBin.binary(temp)));
		} else if (SwitchOp.getFormat() == "J")
			line = functionJ(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]));
		else if (SwitchOp.getFormat() == "W") {
			line = functionW(SwitchOp.getOpcode(), DecForBin.switchVariable(arguments[1]), DecForBin.switchVariable(arguments[2]));
		}
		System.out.println(line);
	}
}
