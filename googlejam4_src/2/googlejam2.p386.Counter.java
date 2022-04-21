package googlejam2.p386;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Counter {

	public static void main(String[] args) {
		String input = "/Users/bhavesh/Downloads/A-small-attempt1.in";
		String output = "/Users/bhavesh/Downloads/output";

		try {
			int a[]= new int[1000001];
			int n;
		    for(int i=0;i<=1000000;i++){
		    	a[i]=-1;
		    }

		    for(int i = 1; i<=1000000;i++)
		    {
		        if(i<=10)
		        {
		            a[i]=i;
		            continue;
		        }
				int n1 = i;
				int reverse = 0;
				while (n1 != 0) {
					reverse = reverse * 10;
					reverse = reverse + n1 % 10;
					n1 = n1 / 10;
				}
		        int ri = reverse;
		        if(ri < i && i%10!=0)
		            a[i]= (a[i-1]+1< a[ri] + 1)?a[i-1]+1:a[ri] + 1;
		        else
		            a[i]= a[i-1]+1;
		    }
			BufferedReader br = new BufferedReader(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);

			int t = Integer.parseInt(br.readLine().trim());

			int i = 1;
			while (i <= t) {
				int num = Integer.parseInt(br.readLine());

				String op = "Case #" + i + ": " +a[num];
			System.out.println(op);
				pw.print(op);
				pw.println();
				i++;
			}

			pw.flush();
			pw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}