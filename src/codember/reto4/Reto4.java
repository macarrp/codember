package codember.reto4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import codember.utils.Utils;

public class Reto4 {
	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		String linea;
		
		List<String> archivosReales = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/codember/reto4/files_quarantine.txt"))) {
			while ((linea = br.readLine()) != null) {
				String[] lineaPartida = linea.split("-");
				
				String cadena = lineaPartida[0];
				String checksum = lineaPartida[1];
				
				String caracteresUnicos = cadena.chars()
						.filter(cad -> cadena.chars().filter(caracter -> caracter == cad).count() == 1)
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
						.toString();
				
				boolean esReal = checksum.equals(caracteresUnicos);
				
				if(esReal) {
					archivosReales.add(checksum);
				}
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Archivo real nº 13: submit " + archivosReales.get(32)); // 32
		Utils.printTotalTime(init);
	}
}
