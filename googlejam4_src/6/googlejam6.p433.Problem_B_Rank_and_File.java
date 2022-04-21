package googlejam6.p433;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_B_Rank_and_File {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new FileReader("B-small-attempt0.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
		StringBuilder salida = new StringBuilder();
		int casos = Integer.parseInt(leer.readLine());
		int [] pesos;
		int cont = 0, n;
		StringTokenizer partes;
		while(casos-- != 0){
			pesos = new int[3000];
			n = Integer.parseInt(leer.readLine());
			for(int i=0; i<2*n-1; i++){
				partes = new StringTokenizer(leer.readLine());
				while(partes.hasMoreTokens())
					pesos[Integer.parseInt(partes.nextToken())]++;
			}
			salida.append("Case #").append(++cont).append(":");
			for(int i=0; i<pesos.length; i++){
				if(pesos[i] != 0 && pesos[i]%2 != 0)
					salida.append(" ").append(i);
			}
			salida.append("\n");
		}
		out.append(salida);
		out.close();
		leer.close();
		System.out.print(salida);
	}
}
