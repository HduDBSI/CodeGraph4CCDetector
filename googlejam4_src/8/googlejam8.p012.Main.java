package googlejam8.p012;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner = new Scanner(new FileInputStream(new File("A-small-attempt0.in")));
		//FileOutputStream fo = new FileOutputStream(new File("output.out"));
		int t = scanner.nextInt();
		for(int x = 1; x <= t; ++x){
			int n = scanner.nextInt();
			int[] p = new int[n];
			for(int i = 0; i < n; ++i){
				p[i] = scanner.nextInt();
			}
			System.out.print("Case #" + x + ":");
			//fo.write(("Case #" + x + ":").getBytes());
			if(n == 2){
				for(int i = 0; i < p[0]; ++i){
					System.out.print(" AB");
					//fo.write((" AB").getBytes());
				}
				System.out.println();
				//fo.write(("\n").getBytes());
			}
			else{
				int count1 = 0;
				for(int i3 = 0; i3 < p.length; ++i3)
					if(p[i3] != 0)
						++count1;
				int count = count1;
				while(count > 2){
					int max = 0;
					int index1 = -1;
					for(int i3 = 0; i3 < p.length; ++i3){
						if(p[i3] > max){
							max = p[i3];
							index1 = i3;
						}
					}
					int index = index1;
					--p[index];
					System.out.print(" " + (char)('A'+index));
					int count2 = 0;
					for(int i = 0; i < p.length; ++i)
						if(p[i] != 0)
							++count2;
					//fo.write((" " + (char)('A'+index)).getBytes());
					count = count2;
				}
				int i1 = -1, i2 = -1;
				for(int i = 0; i < p.length; ++i){
					if(p[i] != 0){
						if(i1 == -1)
							i1 = i;
						else
							i2 = i;
					}
				}
				System.out.println(" " + (char)('A'+i1) + (char)('A'+i2));
				//fo.write((" " + (char)('A'+i1) + (char)('A'+i2) + '\n').getBytes());
			}
		}
		//fo.flush();
		//fo.close();
	}
	
}
