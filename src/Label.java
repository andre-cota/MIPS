
public class Label {
	
	private static String[] label;
	
	private static void label(String argument) {
		
		
		label = argument.split("");
		for(int i = 0; i < label.length; i++)
			System.out.println("Teste de rotulo [" + "]: " + label[i]);
		
	}

	public static String[] getLabel() {
		return label;
	}

	public static void setLabel(String argument) {
		Label.label(argument);
	}

}
