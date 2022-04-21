package googlejam6.p475;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());
		String str;
		String arr[];
		for(int i=1;i<=t;i++){
			int n = Integer.parseInt(scn.nextLine());
			HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
			for(int j=1;j<2*n;j++){
				str = scn.nextLine();
				arr = str.split(" ");
				for(int k=0;k<n;k++){
					int val = Integer.parseInt(arr[k]);
					if(data.containsKey(val)){
						data.put(val, data.get(val)+1);
					}else{
						data.put(val, 1);
					}
				}
			}
			ArrayList<Integer> missingList = new ArrayList<Integer>();
			Iterator<Integer> ite = data.keySet().iterator();
			while (ite.hasNext()) {
				Integer key = (Integer) ite.next();
				Integer cnt = data.get(key);
				if(cnt%2==1)
					missingList.add(key);
			}
			
			Collections.sort(missingList);
			
			System.out.print("Case #" + i + ": ");
			for(int j=0;j<n;j++){
				if(j>0)
					System.out.print(" "); 
				System.out.print(missingList.get(j));
			}
			System.out.println();
		}
		
		scn.close();

	}

}
