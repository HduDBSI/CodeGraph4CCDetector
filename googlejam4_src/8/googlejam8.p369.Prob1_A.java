package googlejam8.p369;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prob1_A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Harish/Downloads/A-large.in"));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		int count = 0;
		while (t-- > 0) {
			line = br.readLine();
			int n = Integer.parseInt(line);
			int[] arr = new int[n];
			line = br.readLine();
			int orgtotal = 0;
			int max = 0;
			int max2 = 0;
			String[] str = line.split(" ");
			int i = 0;
			int a = -1;
			int b = -1;
			for (String st : str) {
				int val = Integer.parseInt(st);
				orgtotal += val;
				arr[i] = val;
				i++;
			}
			boolean flag = true;
			System.out.print("Case #"+(++count)+": ");
			int total;
			while (flag) {
				flag = false;
				max = 0;
				max2 =0;
				a=-1;
				b=-1;
				total = 0;
				for (int j = 0; j < n; j++) {
					if(arr[j] > max){
						if(max !=0){
							b=a;
							max2 = max;
						}
						a=j;
						max = arr[j];
					}else if(arr[j]>max2 && arr[j]<=max){
						b=j;
						max2 = arr[j];
					}
					total+=arr[j];
				}
				if(total== 3){
					System.out.print((char)(65+a)+" ");
					arr[a]--;
					total--;
				}else{
					System.out.print((char)(65+a)+""+(char)(65+b)+" ");
					arr[a]--;
					arr[b]--;
					total-=2;
				}
				if(total != 0) flag = true;
			}
			System.out.println();
		}
	}

}
