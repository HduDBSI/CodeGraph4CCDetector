package googlejam6.p356;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;


public class RankAndFile {
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("B-large.in"));
		bw = new BufferedWriter(new FileWriter("result.txt"));
		int size = Integer.parseInt(br.readLine());
		String line = "";
		int index = 0;
		while(size !=0 ){
			index++;
			line = br.readLine();
			int length = Integer.parseInt(line);
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0;j<2*length-1;j++){
				line = br.readLine();
				String[] strs = line.split(" ");
				int[] hes = new int[strs.length];
				for(int i=0;i<hes.length;i++){
					hes[i] = Integer.parseInt(strs[i]);
					if(map.containsKey(hes[i])){
						map.put(hes[i], map.get(hes[i])+1);
					}else{
						map.put(hes[i], 1);
					}
				}
			}
			Iterator<Integer> iterator = map.keySet().iterator();
			ArrayList<Integer> res = new ArrayList<Integer>();
			while(iterator.hasNext()){
				int key = iterator.next();
				if(map.get(key)%2==1)
					res.add(key);
			}
			Collections.sort(res);
			String finalres = "";
			for(Integer i : res){
				finalres += (i+" ");
			}
			String info ="Case #"+index+": "+finalres;
			System.out.println(info);
			bw.write(info);
			bw.newLine();
			size--;
		}
		if(bw != null){
			bw.close();			
		}
		if(br != null){
			br.close();
		}
		
	}
}
