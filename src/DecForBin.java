
public class DecForBin {

	public static final String gp = "11100";
	public static final String sp = "11101";
	public static final String fp = "11110";
	public static final String ra = "11111";
	public static final String at = "00000";
	public static final String zero = "00000";
	static String temp;
	static char[] vetor;

	// Verifica qual o tipo de argumento
	static String switchVariable(String arg) {
		int num = 0;
		char[] args = arg.toCharArray();
		switch (args[0]) {
		case 'v':
			num = functionResults(arg);
			arg = binary(num);
			break;
			
		case 's':
			if (args[1] == 'p')
				arg = sp;
			else
				num = savedTemporaries(arg);
			arg = binary(num);
			
			break;
		case 'a':
			if (args[1] == 't')
				arg = at;
			else
				num = arguments(arg);
			arg = binary(num);
			break;
		case 't':
			num = temporaries(arg);
			arg = binary(num);
			break;
		case 'k':
			num = reservedOSKernel(arg);
			arg = binary(num);
			break;
		case 'g':
			arg = gp;
			break;
		case 'f':
			arg = fp;
			break;
		case 'r':
			arg = ra;
			break;
		case 'z':
			if(args[1] == 'e' && args[2] == 'r' && args[3] == 'o')
				arg = zero;
			else
				SwitchOp.error(String.valueOf(arg));
			break;
		default:
			SwitchOp.error(String.valueOf(arg));
			break;
		}

		return arg;
	}

	public static String binary(int number) { //Método para conversão de Decimal para binário
		int decimal = number;
		if((SwitchOp.getFormat() == "I" | SwitchOp.getFormat() == "W") & number > (Math.pow(2, 16) -1)) //Validação de Imediatos
			SwitchOp.error(number + " (except 16bits)");
		if((SwitchOp.getFormat() == "J") & number > (Math.pow(2, 26) -1)) //Validação de endereços
			SwitchOp.error(number + " (except 26bits)");
		if((SwitchOp.getFormat() == "S") & number > (Math.pow(2, 5) -1)) //Validação de sa
			SwitchOp.error(number + " (except 5bits)");
		StringBuilder binary = new StringBuilder();
		while (decimal > 0) {
			int bin = decimal % 2;
			binary.append(bin);
			decimal = decimal / 2;
		}
		String valor = binary.reverse().toString();
		return valor;

	}

	static int functionResults(String v) { //Valores para resultados de funções
			char[] args = v.toCharArray();
			int num = 0;
			if (args[1] == 0) {
				num = 2;
			} else if (args[1] == 1) {
				num = 3;
			} else
				SwitchOp.error(String.valueOf(v));
		return num;

	}

	static int savedTemporaries(String s) { //Valores para variaveis carregadas

			char[] args = s.toCharArray();
			int num = Integer.parseInt(String.valueOf(args[1]));
			if (num >= 0 & num <= 7) {
				num += 16;
			} else
				SwitchOp.error(String.valueOf(s));
		return num;
	}

	static int arguments(String a) { //Valores para argumentos
		char[] args = a.toCharArray();
		int num = Integer.parseInt(String.valueOf(args[1]));
		if (num >= 0 & num <= 3) {
			num += 4;
		} else
			SwitchOp.error(String.valueOf(a));
		return num;
	}

	static int temporaries(String t) { //Valores para temporários
		char[] args = t.toCharArray();
		int num = Integer.parseInt(String.valueOf(args[1]));

		if (num >= 0 & num <= 7) {
			num += 8;
			}
		 else if (num == 8)
			 num = 24;
		else if (num == 9)
			num = 25;
		else
			SwitchOp.error(String.valueOf(t));
		return num;
	}

	static int reservedOSKernel(String k) { //Valores para variaveis reservadas
		char[] args = k.toCharArray();
		int num = 0;
		if (args[1] == '0') {
			num = 26;
		} else if (args[1] == '1') {
			num = 27;
		} else
			SwitchOp.error(String.valueOf(k));

		return num;
	}

	static String immediateTreatment(String immediate) { //Adiciona "0"s até completar os 16bits de um imediato
		vetor = immediate.toCharArray();
		if (vetor.length < 16) {
			temp = immediate;
			immediate = "";
			for (int i = vetor.length; i < 16; i++) {
				immediate += "0";
			}
			immediate += temp;
		}
		return immediate;
	}
	static String addressTreatment(String address) { //Adiciona "0"s até completar os 26bits de um endereço
		vetor = address.toCharArray();
		if (vetor.length < 26) {
			temp = address;
			address = "";
			for (int i = vetor.length; i < 26; i++) {
				address += "0";
			}
			address += temp;
		}
		return address;
	}
	
	static String saTreatment(String sa) { //Adiciona "0"s até completar os 5bits de um endereço
		vetor = sa.toCharArray();
		if (vetor.length < 5) {
			temp = sa;
			sa = "";
			for (int i = vetor.length; i < 5; i++) {
				sa += "0";
			}
			sa += temp;
		}
		return sa;
	}

	static String baseOffsetTreatment(String baseOffset, boolean controller) { //Divide o argumento, passa pelos outros métodos para tratar e, de acordo com o controlador, da o retorno desejado
		char[] args = baseOffset.toCharArray();
		int i = 0;
		String offset = "";
		while(args[i] != '(') {
			offset += args[i];
			i++;
		}
		String base = Character.toString(args[i+1]) + Character.toString(args[i+2]);
		if(offset == "zero") {
			
		}
		try {
			offset = immediateTreatment(binary(Integer.parseInt(offset)));
		}
		catch(NumberFormatException exception) {
			offset = immediateTreatment(switchVariable(offset));
		}
		base = saTreatment(switchVariable(base));

		if (controller == true)
			return offset;
		return base;
	}

}