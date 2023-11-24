package codember.reto3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import codember.utils.Utils;

public class Reto3 {
	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		String linea;
		
		List<String> clavesValidas = new ArrayList<>();
		List<String> clavesInvalidas = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/codember/reto3/encryption_policies.txt"))) {
			while ((linea = br.readLine()) != null) {
		        String politicaCompleta = linea.split(":")[0];
		        String clave = linea.split(":")[1].trim();
		        
		        String[] politicaCompletaPartida = politicaCompleta.split(" ");
		        
		        String minAndMax = politicaCompletaPartida[0];
		        String[] minAndMaxPartida = minAndMax.split("-");
		        
		        Long minimo = Long.valueOf(minAndMaxPartida[0]);
		        Long maximo = Long.valueOf(minAndMaxPartida[1]);		        
		        char letra = politicaCompletaPartida[1].charAt(0);		        
		        
		        long aparicionesLetra = clave.chars().filter(c -> c == letra).count();
		        
		        if(aparicionesLetra >= minimo && aparicionesLetra <= maximo) {
		        	clavesValidas.add(clave);
		        	continue;
		        }
		        clavesInvalidas.add(clave);
		      }			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// Secreto
		System.out.println("Clave invalida nº 13: submit " + clavesInvalidas.get(12)); // 13
		System.out.println("Clave invalida nº 42: submit " + clavesInvalidas.get(41));// 42
		
		Utils.printTotalTime(init);
	}
}
