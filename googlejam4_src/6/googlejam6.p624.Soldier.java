package googlejam6.p624;
import java.util.*;
import java.io.*;

public class Soldier {


	public static void main(String []args) throws IOException {

		FileReader fr = new FileReader("B-large.in");
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
		
		HashMap<Integer, Integer>  obj = new HashMap<Integer, Integer>();
		int N;
		Integer arr[][];int one = 1;
		String strarr[];// = new String();
		for(int k = 0;k < T;k++) {
			obj.clear();
			if((s = br.readLine()) != null)
				N = Integer.parseInt(s);//c.nextInt();
			else {
				System.out.println("File has nothing to read.");
				return;
			}
			arr = new Integer[2 * N - 1][N];
			for(int i = 0;i < 2 * N - 1;i++) {
				if((s = br.readLine()) == null) {
					System.out.println("File has nothing to read.");
					return;
				}
				strarr = null;
				strarr = s.split(" ");
				for(int j = 0;j < N;j++) {
					arr[i][j] = Integer.parseInt(strarr[j]);
					if(!obj.containsKey(arr[i][j]))
						obj.put((Integer) arr[i][j],(Integer)  1);
					else
						obj.put((Integer)arr[i][j], (Integer)(obj.get(arr[i][j]) + 1));
				}	
			}
	
			Set setobj = obj.entrySet();
			Iterator it = setobj.iterator();
			int out[] = new int[N];int i = 0;
			while(it.hasNext()) {
				Map.Entry me = (Map.Entry) it.next();
				int temp = (int)me.getValue();
				if(temp % 2  == 1) {
					out[i] = (int)me.getKey(); i++;
				}
						
			}
			Arrays.sort(out);
			System.out.print("Case #" + (k + 1) + ": ");
			for(int j = 0;j < N;j++)
				System.out.print(out[j] + " ");
			System.out.println();
			
			
		}

	}

}
