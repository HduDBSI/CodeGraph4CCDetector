package googlejam1.p823;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in) );
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int contador = 1;
		while(cases>0){
			
		int hongos = in.nextInt();
		int anterior = 0;
		int actual = 0;
		int metodo1 = 0;
		int metodo2 = 0;
		int c = 0;
		int[] anteriores = new int[hongos];
		while(hongos>0){
			// caso 1
			
		actual = in.nextInt();
		
		if(actual<anterior){
			metodo1 += anterior - actual;
		}
		
		anteriores[c] = actual;
	   
		anterior = actual;	
		  c++;
			hongos--;
		}
		int diferencia = 0;

		for(int i=0;i<anteriores.length-1;i++){
			int comp = anteriores[i] - anteriores[i+1];
			if(diferencia<comp){
				diferencia = comp;
			}
		}
		for(int i=0;i<anteriores.length-1;i++){
			if(anteriores[i]>=diferencia){
				metodo2 += diferencia;
			}else{
				metodo2 += anteriores[i];
			}
		}
			out.write("Case #" +contador+": "+ metodo1+" " + metodo2 + "\n");
			
			contador++;
			cases--;
		}
		out.flush();
		
	}
	
}
