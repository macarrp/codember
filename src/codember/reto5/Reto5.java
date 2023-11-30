package codember.reto5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.regex.Pattern;

import codember.utils.Utils;

public class Reto5 {
	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		String linea;
		StringBuilder sb = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/codember/reto5/database_attacked.txt"))) {
			while ((linea = br.readLine()) != null) {
				String[] lineaPartida = linea.split(",");
				
				String id = lineaPartida[0];
				String username = lineaPartida[1];
				String email = lineaPartida[2];
				
				String age = null;
				
				if(lineaPartida.length > 3) {
					age = lineaPartida[3];
				}
				
				// Si no cumple alguno de estas condiciones es usuario inválido
				if(!existsAndAlphaNumeric(id) || !existsAndAlphaNumeric(username) 
						|| !verifyEmail(email) || !verifyAge(age)) {
					sb.append(username.charAt(0));
				}
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Mensaje oculto: submit " + sb.toString());
		Utils.printTotalTime(init);
	}
	
	// Válido si existe y es alfanumérica
	private static boolean existsAndAlphaNumeric(String s) {
		return isNotNullOrEmpty(s) && isAlphaNumeric(s);
	}
	
	// Válido si existe y es válido (sigue el patrón user@dominio.com)
	private static boolean verifyEmail(String email) {
		return isNotNullOrEmpty(email) && validateEmail(email);
	}
	
	// Es opcional pero si aparece es un número
	private static boolean verifyAge(String age) {
		if(!isNotNullOrEmpty(age)) {
			return true;
		}
		
		return new BigDecimal(age) != null;
	}
	
	// Existe
	private static boolean isNotNullOrEmpty(String text) {
		return text != null && !text.isBlank();
	}
	
	// Caracteres alfanuméricos -> (0-9), (A-Z), (a-z)
	private static boolean isAlphaNumeric(String text) {
		return text.matches("[A-Za-z0-9]+");
	}

	// Validar email
	private static boolean validateEmail(String email) {
		String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.compile(regex)
	      .matcher(email)
	      .matches();
	}
}
