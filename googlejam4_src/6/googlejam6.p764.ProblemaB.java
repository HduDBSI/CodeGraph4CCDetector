package googlejam6.p764;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemaB {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		int t = input.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			int n = input.nextInt();			
			
			ArrayList<Integer> listaMatrizOrdenada = new ArrayList<Integer>();
						
			for(int j = 0; j < n * (2 * n - 1); j++)
				listaMatrizOrdenada.add( input.nextInt() );
		
			Collections.sort(listaMatrizOrdenada);	
			
			listaMatrizOrdenada.add(-1);
			
			List<Integer> resultado = new ArrayList<Integer>();
			
			int count = 0;
			Integer anterior = null;
				
			
			for(Integer j : listaMatrizOrdenada) {
				
				if(j == 134)
					System.out.println("");
				
				if(anterior == null || j.equals(anterior)) {
					count++;
					
				} else {

					if (count % 2 != 0) {
						resultado.add(anterior);
					}
					count = 1;
				}
				anterior = j;
				
			}
			
			System.out.print("Case #" + (i + 1) + ":");
			for(Integer numero : resultado)
				System.out.print(" " + numero);
			
			System.out.println("");
		}
		
		input.close();
	}
}
