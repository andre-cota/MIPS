
public class DecForBin {

	public static final String gp = "11100";
	public static final String sp = "11101";
	public static final String fp = "11110";
	public static final String ra = "11111";
	public static final String at = "00000";
	public static final String zero = "00000";
	static String temp;
	static char[] vetor;

	static String switchVariable(String arg) {

		char[] args = arg.toCharArray();
		switch (args[0]) {
		case 'v':
			arg = functionResults(arg);
			break;
		case 's':
			if (args[0] == 'p')
				arg = sp;
			else
				arg = savedTemporaries(arg);
			break;
		case 'a':
			if (args[0] == 't')
				arg = at;
			else
				arg = arguments(arg);
			break;
		case 't':
			arg = temporaries(arg);
			break;
		case 'k':
			arg = reservedOSKernel(arg);
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
			arg = zero;
			break;
		default:
			Main.error(String.valueOf(args[0] + args[1]));
			break;
		}

		return arg;
	}

	public static String binary(int numero) {
		int d = numero;
		StringBuffer binary = new StringBuffer(); // guarda os dados
		while (d > 0) {
			int b = d % 2;
			binary.append(b);
			d = d / 2;
		}
		String valor = binary.reverse().toString(); // inverte a ordem e imprime
		return valor;

	}

	static String functionResults(String v) {
		char[] args = v.toCharArray();
		if (args[1] == 0) {
			v = "00010";
		} else if (args[1] == 1) {
			v = "00011";
		} else
			Main.error(String.valueOf(args[1]));

		return v;
	}

	static String savedTemporaries(String s) {
		char[] args = s.toCharArray();
		int num = Integer.parseInt(String.valueOf(args[1]));
		if (args[1] >= 0 | args[1] <= 7) {
			num += 16;
			s = binary(num);
		} else
			Main.error(String.valueOf(args[1]));

		return s;
	}

	static String arguments(String a) {
		char[] args = a.toCharArray();
		int num = Integer.parseInt(String.valueOf(args[1]));
		if (args[1] >= 0 | args[1] <= 3) {
			num += 4;
			a = binary(num);
		} else
			Main.error(String.valueOf(args[1]));

		vetor = a.toCharArray();
		if (vetor.length < 5) {
			temp = a;
			a = "";
			for (int i = vetor.length; i == 5; i++) {
				a += "0";
			}
			a += temp;
		}

		return a;
	}

	static String temporaries(String t) {
		char[] args = t.toCharArray();
		int num = Integer.parseInt(String.valueOf(args[1]));

		if (num >= 0 & num <= 7) {
			num += 8;
			t = binary(num);

			vetor = t.toCharArray();
			if (vetor.length < 5) {
				temp = t;
				t = "";
				for (int i = vetor.length; i < 5; i++) {
					t += "0";
				}
				t += temp;
			}
		} else if (num == 8)
			t = "11000";
		else if (num == 9)
			t = "11001";
		else
			Main.error(String.valueOf(args[1]));
		return t;
	}

	static String reservedOSKernel(String k) {
		char[] args = k.toCharArray();
		if (args[1] == 0) {
			k = "11010";
		} else if (args[1] == 1) {
			k = "11011";
		} else
			Main.error(String.valueOf(args[1]));

		return k;
	}

	static String immediateTreatment(String immendiate) {
		vetor = immendiate.toCharArray();
		if (vetor.length < 16) {
			temp = immendiate;
			immendiate = "";
			for (int i = vetor.length; i < 16; i++) {
				immendiate += "0";
			}
			immendiate += temp;
		}
		return immendiate;
	}

}