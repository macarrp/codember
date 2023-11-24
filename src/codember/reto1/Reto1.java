package codember.reto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import codember.utils.Utils;

public class Reto1 {

	public static void main(String[] args) {
		long init = System.currentTimeMillis();
		
		Map<String, Integer> resultado = new LinkedHashMap<String, Integer>();
		String linea;
		String[] lineaPartida;
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/codember/reto1/message.txt"))) {
			while ((linea = br.readLine()) != null) {
				lineaPartida = linea.toLowerCase().split(" ");
				
				for(String str : lineaPartida) {			
					Integer value = resultado.getOrDefault(str, 0);
					resultado.put(str, ++value);
				}
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.out.print("submit ");
		for(String s : resultado.keySet()) {
			System.out.print(s + resultado.get(s));
		}
		
		Utils.printTotalTime(init);
	}

}
