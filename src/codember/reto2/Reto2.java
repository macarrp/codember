package codember.reto2;

import codember.utils.Utils;

public class Reto2 {
	static Integer value = 0;

	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		String input = "&###@&*&###@@##@##&######@@#####@#@#@#@##@@@@@@@@@@@@@@@*&&@@@@@@@@@####@@@@@@@@@#########&#&##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@&";
		
		char[] inputArray = input.toCharArray();
		
		System.out.print("submit ");
		for(char c : inputArray) {
			processChar(c);
		}
		
		Utils.printTotalTime(init);
	}
	
	public static void processChar(char c) {
		switch(c) {
			case Symbols.HASHTAG: // Incrementa el valor numérico en 1.
				value++;
				break;
			case Symbols.ARROBA: // Decrementa el valor numérico en 1.
				value--;
				break;
			case Symbols.ASTERISCO: // Multiplica el valor numérico por sí mismo.
				value *= value;
				break;
			case Symbols.AMPERSAND: // Imprime el valor numérico actual.
				System.out.print(value);
				break;
			default:
				System.out.println("Error");
		}
	}
}

class Symbols {
	public static final char HASHTAG = '#';
	public static final char ARROBA = '@';
	public static final char ASTERISCO = '*';
	public static final char AMPERSAND = '&';
}
