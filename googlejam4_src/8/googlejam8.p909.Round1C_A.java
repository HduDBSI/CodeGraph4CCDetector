package googlejam8.p909;
import java.util.*;
import java.io.*;

public class Round1C_A {


	public static void main(String []args) throws IOException {

		FileReader fr = new FileReader("A-large11.in");
		BufferedReader br = new BufferedReader(fr);
		String s;


		//Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T;
		if((s = br.readLine()) != null)
			T = Integer.parseInt(s);//c.nextInt();
		else
		{
			System.out.println("File has nothing to read.");
			return;
		}
		if(T < 1 || T > 100) {
			System.out.println("Improper number of test cases.");
			return;
		}

		int N;
		int arr[], temp[];
		for(int k = 0;k < T;k++) {
			if((s = br.readLine()) != null)
				N = Integer.parseInt(s);//c.nextInt();
			else {
				System.out.println("File has nothing to read.");
				return;
			}
			arr = new int[N];
			if((s = br.readLine()) == null) {
				System.out.println("File has nothing to read.");
				return;
			}
			Scanner sc;
			sc = new Scanner(s);
			int p = 0;
			while(sc.hasNext()) {
				arr[p] = sc.nextInt();p++;
			}
			
			int tot, max, secmax;tot = 0;
			for(int i = 0;i < N;i++)
				tot += arr[i];	
			int print[];
			int printIndex;
			print = new int[2002];Arrays.fill(print, -1);
			printIndex = 0;

			while(true) {
				//temp = Arrays.copyOf(arr, N);
				//Arrays.sort(temp);
				int maxpos, secmaxpos;maxpos = 0;max = arr[0];
				for(int i = 1;i < N;i++) {
					if(arr[i] > max) {
						max = arr[i];
						maxpos = i;
					}
				}
					
				boolean flag, tflag;tflag = false;
				flag = false;
				int tcount;
				tcount = 0;
				if(max == 1) {
					int count;
					count = 0;
					for(int i = 0;i < N;i++) {
						if(arr[i] == 1)
							count++;
						if(arr[i] == 0)
							tcount++;
					}
					if(tcount == N) {
						tflag = true;
						break;
					}
					if(count == 3)
						flag = true;
				}
				if(!flag) {
					print[printIndex++] = maxpos;
					secmax = -1;secmaxpos = 0;
					for(int i = 0;i < N;i++) {
						if(i != maxpos && arr[i] > secmax) {
							secmax = arr[i];
							secmaxpos = i;
						}	
					}
					print[printIndex++] = secmaxpos;
					arr[maxpos]--;
					arr[secmaxpos]--;
					print[printIndex++] = -2;
				}
				else {
					print[printIndex++] = maxpos;
					arr[maxpos]--;
					print[printIndex++] = -2;

					for(int i = 0;i < N;i++) 
						if(arr[i] == 1) { 
							print[printIndex++] = i;
		arr[i]--;}			break;
				}
				
				tot = 0;
				for(int i = 0;i < N;i++)
					tot += arr[i];
				if(tot == 0)
					break;	

			}	


			System.out.print("Case #" + (k + 1) + ": ");
			for(int j = 0;j < 2000 && print[j] != -1;j++) 
				if(print[j] != -2) 
					System.out.print(  ((char)(print[j] + 65)) );
				else
					System.out.print(" ");
				
			System.out.println();	
			
		}

	}

}
