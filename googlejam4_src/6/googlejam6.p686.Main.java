package googlejam6.p686;

import java.io.*;
import java.util.*;
class Main{

	public static void main(String[] args)throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n, lim = Integer.parseInt(sc.readLine()), a, b, c;
		String cad;
		int [] array;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		StringTokenizer st;
		for (int i = 1; i <= lim; i++) {
			n = Integer.parseInt(sc.readLine());
			array = new int[2501];
			for (int filas = 0; filas < 2*n-1; filas++) {
				cad = sc.readLine();
				st = new StringTokenizer(cad);
				for (int datos = 0; datos < n; datos++) {
					array[Integer.parseInt(st.nextToken())]++;
				}
			}
			for (int r = 1; r < 2501; r++) {
				if (array[r] % 2 != 0) {
					lista.add(r);
				}
			}

			System.out.print("Case #"+i+":");
			for (Integer t: lista) {
				System.out.print(" "+t);
			}
			System.out.println("");
			lista.clear();
		}		
	}
	
}



















/*
		double a, b, p;
		final double pi = 3.1415926535; 
		Intervalo intervalo = new Intervalo(2.0, 3.0);
		Funcion funcion = new Funcion();
		
		// Biseccion
		/*
		Biseccion biseccion = new Biseccion(intervalo, 0.0001, funcion);	
		biseccion.ejecutar_Algoritmo();	
		System.out.println(biseccion.getRespuesta());
		*/

		// Punto Fijo
		/*
		PuntoFijo algoritmo_PuntoFijo = new PuntoFijo(0.000000001, 1.5, 4, funcion);
		algoritmo_PuntoFijo.ejecutar_Algoritmo();
		System.out.println(algoritmo_PuntoFijo.getRespuesta());
		

		MetodoNewton algoritmo_MetodoNewton = new MetodoNewton(0.0001, 1, 10, funcion);
		algoritmo_MetodoNewton.ejecutar_Algoritmo();
		System.out.println(algoritmo_MetodoNewton.getRespuesta());

*/