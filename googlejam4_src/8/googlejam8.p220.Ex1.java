package googlejam8.p220;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex1 {
    private static String input = "A-large.in";
    private static String output = "out.txt";
    private PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new FileInputStream(input));
		Ex1 r = new Ex1();
        r.out = new PrintWriter(Ex1.output);
		int testsNo = Integer.valueOf(file.nextLine());
		
		for (int i=1; i<=testsNo; i++) {
		    int N = Integer.valueOf(file.nextLine());
		    String[] arr = file.nextLine().split(" ");
		    int[] sen = new int[arr.length];
		    for (int j=0; j<sen.length; j++)
		        sen[j] = Integer.valueOf(arr[j]);
		
		    r.out.print("Case #"+i+": ");
			int total = 0;
			for (int i1=0; i1<N; i1++) total += sen[i1];
			
			while (total > 3 || total == 2) {
			    int max = 0;
			    for (int j=0; j<N; j++) if (sen[max] < sen[j]) max = j;
			    sen[max]--;
			    total--;
			    char first = (char)('A'+max);
			    r.out.print(first);
			
			    if (total == 3) break;
			    if (total > 0) {
			        max=0;
			        for (int j=0; j<N; j++) if (sen[max]<sen[j]) max=j;
			        char second=(char) ('A'+max);
			        sen[max]--;
			        total--;
			        r.out.print(second);
			    }
			    r.out.print(" ");
			}
			
			
			
			if (total == 3) {
			    int max = 0;
			    for (int j=0; j<N; j++) if (sen[max] < sen[j]) max = j;
			    sen[max]--;
			    char first = (char)('A'+max);
			    r.out.print(first+" ");
			
			    max = 0;
			    for (int j=0; j<N; j++) if (sen[max] < sen[j]) max = j;
			    sen[max]--;
			    first = (char)('A'+max);
			    r.out.print(first);
			
			    max = 0;
			    for (int j=0; j<N; j++) if (sen[max] < sen[j]) max = j;
			    sen[max]--;
			    char second= (char)('A'+max);
			    r.out.print(second);
			    r.out.print(" ");
			}
		    r.out.println();
		}
		r.out.close();
        file.close();
    }
}
