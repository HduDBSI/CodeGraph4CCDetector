package googlejam6.p628;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		FileInputStream fs = new FileInputStream("B-large.in");
		FileWriter fw = new FileWriter("B-large.txt");
		Scanner s = new Scanner(fs);
		int num = s.nextInt();
		for(int i = 0; i < num; i++){
			int lineNum = s.nextInt();
			HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
			for(int j = 0; j < (lineNum * 2 - 1) * lineNum; j++){
				int n = s.nextInt();
				if(hs.containsKey(n)){
					hs.put(n, hs.get(n) + 1);
				}else{
					hs.put(n, 1);
				}
			}
			int[] ans = new int[lineNum];
			int index = 0;
			Iterator it = hs.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Map.Entry)it.next();
				if((Integer)entry.getValue() % 2 == 1){
					ans[index++] = (Integer)entry.getKey();
				}
			}
			Arrays.sort(ans);
			StringBuilder sb = new StringBuilder();
			for(int k = 0; k < lineNum; k++)
				sb.append(ans[k] + " ");
			fw.write("Case #" + (i + 1) +": " + sb.toString() + "\n");
		}
		fs.close();
		fw.close();
	}
}
