package googlejam1.p496;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Mushroom {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.in"));
        PrintWriter out = new PrintWriter("output.txt");
        int T = in.nextInt();
        int[] se=new int[2];
        for (int i = 0; i < T; i++) {
        	Mushroom r = new Mushroom();
			int N=in.nextInt();
			int[] plate=new int[N];
			for(int i1=0;i1<N;i1++){
				plate[i1]=in.nextInt();
			}
			int[] eat=new int[N-1];
			int max=0;
			int sum1=0;
			for(int i2=0;i2<N-1;i2++){
				eat[i2]=plate[i2]-plate[i2+1];
				if(eat[i2]>max) max=eat[i2];
				if(eat[i2]>0) sum1=sum1+eat[i2];
			}
			int sum2=0;
			for(int i3=0;i3<N-1;i3++){
				if(plate[i3]>max) sum2=sum2+max;
				else sum2=sum2+plate[i3];
			}
			int[] result=new int[2];
			result[0]=sum1;
			result[1]=sum2;
			se=result;
            String s = "Case #" + (i + 1) + ": " + se[0]+ " " + se[1];
            out.println(s);
            System.out.println(s);
        }
        out.close();
    }
}
