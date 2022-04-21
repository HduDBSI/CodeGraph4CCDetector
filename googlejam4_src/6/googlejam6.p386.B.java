package googlejam6.p386;
import java.io.*;
import java.util.*;

public class B{
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
	
    for (int i = 1; i <= t; ++i) {
		int n = in.nextInt();
		System.out.print("Case #" + i + ": ");
		int p=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		while(p<2*n*n-n){
			p++;
			int key=in.nextInt();
			if(map.containsKey(key))map.put(key,map.get(key)+1);
			else map.put(key,1);
		}
		Iterator it = map.entrySet().iterator();
		int[] missing=new int[n];
		int j=0;
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			
			if((int)pair.getValue()%2==1){
				missing[j]=(int)pair.getKey();
				j++;
			}
			it.remove(); 
		}
		Arrays.sort(missing);
		
		for(int k=0;k<n;k++){
			System.out.print(missing[k]+" ");
		}
		System.out.println("");
	}
	
	
  }
  
}