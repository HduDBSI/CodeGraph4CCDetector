package googlejam1.p702;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class First {
	public static int[] tabela;
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pr = new PrintWriter("neki.txt");
		Scanner sc = new Scanner(System.in);
		//pr.print("hello");
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			pr.print("Case #" + (i+1) + ": ");
			int st = sc.nextInt();
			tabela = new int[st];
			for (int j = 0; j < st; j++) {
				tabela[j] = sc.nextInt();
			}
			int hrana = 0;
			int trenutni = tabela[0];
			for (int i1 = 1; i1 < tabela.length; i1++) {
				if(trenutni > tabela[i1]){
					hrana += trenutni -tabela[i1];
				}
				trenutni = tabela[i1];
			}
			int a = hrana;
			int max = 0;
			for (int i1 = 0; i1 < tabela.length-1; i1++) {
				int c = tabela[i1] - tabela[i1+1];
				if(c > max){
					max= c;
				}
			}
			int hrana1 = 0;
			for (int i2 = 1; i2 < tabela.length; i2++) {
				if(tabela[i2-1] <= max ){
					hrana1 += tabela[i2-1];
				}
				else
					hrana1 += max;
			}
			int b = hrana1;
			pr.println(a + " " + b);
			
		}
		sc.close();
		pr.close();

	}

}
