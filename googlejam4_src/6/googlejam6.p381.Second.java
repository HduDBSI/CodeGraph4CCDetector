package googlejam6.p381;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Second {
    private static final String dir = "C:\\Users\\Sasidharan\\Downloads\\Code\\B\\";

    public static int mins = 0;
    public static void main(String[] args) throws Exception {
    	Second o = new Second();
    	Scanner sc = new Scanner(new FileReader(dir + "B-large.in"));

    	PrintWriter pw = new PrintWriter(new FileWriter(dir + "output.txt"));
    	int caseCnt = sc.nextInt();
    	sc.nextLine();
    	for(int n = 0; n < caseCnt; n++) {
    		//sc.nextLine();
    		//System.out.println("Test cases " + (n + 1));
    		pw.print("Case #" + (n+1) + ": ");
    		//mins = 0;
    		int no = sc.nextInt();
			int[][] a = new int[2 * no - 1][no];
			int b[] = new int[2502];
			
			for(int i = 0; i < 2* no - 1; i++) {
				sc.nextLine();
				for(int k = 0; k < no; k++) {
					int j = sc.nextInt();
					if(b[j] == 0) {
						b[j] = 1;
					} else {
						b[j] = b[j] - 1;
					}
				}
			    //a[i][0] = sc.nextInt();
				//a[i][1] = sc.nextInt();
				//a[i][2] = sc.nextInt();
				//System.out.println(a[i][0] +" " + a[i][1] + " " + a[i][2]);
				//sc.nextLine();
			}
			for(int i =0; i < 2502; i++)
			{
				if(b[i] == 1) {
					System.out.print(i + " ");
					pw.print(i + " ");
				}
				//String text = sc.nextLine();
			}
			System.out.println();
			pw.println();
    	}
    	pw.flush();
    	pw.close();
    	sc.close();
    }

}
