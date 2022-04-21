package googlejam6.p715;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Square {

	public static void main(String[] args) throws IOException {
		String filename = "C:/Users/Administrator/Desktop/B-small-attempt1.in";
		FileReader fr = new FileReader(filename);
		BufferedReader br =  new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("C:/Users/Administrator/Desktop/out_b.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		String inputs[] = new String[10000000];
		int N = 0;
		while ( (line = br.readLine()) != null){
			inputs[N] = line;
			System.out.println(inputs[N]);
			N++;
		}
		int T = Integer.valueOf(inputs[0]);
		int case_num = 1;
		for (int i=1;i<N;){
			int n = Integer.valueOf(inputs[i]);
			i++;
			//ArrayList<String> list = new ArrayList<String>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (int k=0;k<2*n-1;i++,k++){
				String array[] = inputs[i].split(" ");
				
				for (int m=0;m<array.length;m++){
					if (map.containsKey(array[m])){
						int times = map.get(array[m]);
						map.put(array[m], times+1);
					}
					else{
						map.put(array[m], 1);
					}
				}
			}
			ArrayList<String> list = new ArrayList<String>();
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String key = entry.getKey().toString();
				int times = entry.getValue();
				//System.out.println(key+":::::"+times);
				if (times%2 != 0)
					list.add(key);
			}
			int array[] = new int [list.size()];
			for (int j=0;j<array.length;j++)
				array[j] = Integer.valueOf(list.get(j));
			Arrays.sort(array);
			bw.write("Case #"+case_num+": ");
			for (int j=0;j<array.length;j++){
				if (j<array.length-1)
					bw.write(array[j]+" ");
				else
					bw.write(array[j]+"\n");
			}
			case_num++;
		}
		bw.flush();
	}

}
