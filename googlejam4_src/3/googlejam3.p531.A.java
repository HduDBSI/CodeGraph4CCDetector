package googlejam3.p531;
import java.util.*;
import java.io.*;
public class A {
	public static void main(String... args) throws Exception{
		//Scanner input = new Scanner(new File("in.txt"));
		Scanner input = new Scanner(new File("A-small-attempt2.in"));
		int numCases = input.nextInt();
		//Scanner sinput = new Scanner(System.in);
		System.setOut(new PrintStream("a2.out"));//System.out.printの出力先をファイルに変える
		for (int n = 0; n < numCases; n++) {
				int r = input.nextInt();
				int c = input.nextInt();
				int w = input.nextInt();
				//System.out.println("r="+r+" c="+c+" w="+w);
				
				int num=0;
				
				if(r*c/w!=1){
					num = (r*c)/w+w-1;
					if((r*c)%w!=0) num++;
				}
				else{
					num = w+1;
				}
				if(num>r*c) num=r*c;
			System.out.printf("Case #%d: %d\n", n + 1, num);
		}
	}
}
