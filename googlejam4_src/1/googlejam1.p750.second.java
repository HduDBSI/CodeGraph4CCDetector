package googlejam1.p750;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class second {
	int num = 0;
	ArrayList<int[]> result = new ArrayList<int[]>();
	ArrayList<ArrayList<Integer>> content = new ArrayList<ArrayList<Integer>>();
	public static void main(String args[]) throws Exception{
		second a = new second();
		File file = new File("/Users/apple/Desktop/A-large.in");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp1 = null;
		int line = 0;
		while((temp1 = reader.readLine()) != null){
			if(line == 0){
				a.num = Integer.valueOf(temp1);
			}
			else{
				if(line % 2 == 1){ 
					line ++;
					continue;}
				String[] now1 = temp1.split(" ");
				ArrayList<Integer> cur1 = new ArrayList<Integer>();
				for(int i1 = 0; i1 < now1.length; i1 ++){
					cur1.add(Integer.valueOf(now1[i1]));
				}
				a.content.add(cur1);
			}
			line ++;
		}
		reader.close();
		for(int i = 0; i < a.num; i ++){
			ArrayList<Integer> now = a.content.get(i);	
			if(now.size() == 0){
				System.out.println("in");
				int[] cur = new int[2];
				a.result.add(cur);
				continue;
			}
			int sum1 = 0;
			int sum2 = 0;
			int max = 0;
			for(int j = 0; j < now.size() - 1; j ++){
				if(now.get(j) > now.get(j + 1)){
					max = Math.max(max, now.get(j) - now.get(j + 1));
					sum1 = sum1 + now.get(j) - now.get(j + 1);
				}
			}
			for(int j = 0; j < now.size() - 1; j ++){
				sum2 = sum2 + Math.min(max, now.get(j));
			}
			int[] temp = new int[2];
			temp[0] = sum1;
			temp[1] = sum2;
			a.result.add(temp);
		}
		FileWriter writer = new FileWriter("/Users/apple/Desktop/output.txt");
		for(int i = 0; i < a.result.size(); i ++){
			int j = i + 1;
			writer.write("case #" + j + ": " + a.result.get(i)[0] + " " + a.result.get(i)[1] + "\n");
			
		}
		writer.close();
	}

}
