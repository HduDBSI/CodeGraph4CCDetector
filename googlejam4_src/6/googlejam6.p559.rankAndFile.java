package googlejam6.p559;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class rankAndFile {
	public static void main(String[] args) throws IOException {
		StringBuffer sb; 
		Scanner sc = new Scanner(new FileReader("B-large (1).in"));
		int N=Integer.valueOf(sc.nextLine());
		FileOutputStream fs = new FileOutputStream(new File("202.txt"));
		PrintStream p = new PrintStream(fs);
		HashSet<String> set=new HashSet<>();
		loop:for(int i=1;i<=N;i++){
			set=new HashSet<>();
			int people=sc.nextInt();
			int[] height=new int [3000];
			for(int j=0;j<2*people-1;j++){
				for(int k=0;k<people;k++){
					height[sc.nextInt()]++;
				}
			}
			System.out.print("Case #"+i+": ");
			p.print("Case #"+i+": ");
			for(int m=0;m<height.length;m++){
				if(height[m]%2!=0){
					System.out.print(m+" ");
					p.print(m+" ");
				}
			}
			System.out.println();
			p.println();
		}
	}
}
