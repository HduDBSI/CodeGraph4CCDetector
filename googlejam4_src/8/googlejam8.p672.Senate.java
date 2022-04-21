package googlejam8.p672;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Senate {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("A-large.in-2.txt"));
		
		PrintStream obj = new PrintStream(new File("output.txt"));
		
		int num_case = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i<num_case;i++){
			String num = bf.readLine();
			
			int numSenate = Integer.valueOf(num);
			
			obj.print("Case #"+(i+1)+": ");
			String line = bf.readLine();
			
			String[] lineNum = line.split(" ");
			
			int[] arr = new int[26];
			
			int count = 0;
			int max = 0;
			int totalNum = 0;
			for(int i2 = 0; i2<lineNum.length; i2++){
				if(lineNum[i2] != " "){
					arr[count]+=Integer.valueOf(lineNum[i2]);
					count++;
					totalNum += Integer.valueOf(lineNum[i2]);
					max = Math.max(Integer.valueOf(lineNum[i2]), max);
				}
			}
			
			
			
			ArrayList<Integer> arrList = new ArrayList<>(0);
			
			while(totalNum > 0){
				int max1 = 0;
				for(int i1 = 0; i1<arr.length;i1++){
					max1 = arr[max1]>arr[i1]? max1 : i1;
				}
				int remove = max1;
				arr[remove]--;
				totalNum--;
				arrList.add(remove);
			}
			
			int counter =0;
			int length = arrList.size();
			
			for(int i1 = 0; i1<length && arrList.size()>3;i1++){
				if(counter<1){
					obj.print((char)(arrList.remove(0)+65));
					counter++;
				}else{
					obj.print((char)(arrList.remove(0)+65));
					obj.print(" ");
					counter = 0;
				}
			}
			
			if(arrList.size() == 4){
				obj.print((char)(arrList.remove(0)+65));
				obj.print((char)(arrList.remove(0)+65));
				obj.print(" ");
				obj.print((char)(arrList.remove(0)+65));
				obj.print((char)(arrList.remove(0)+65));
			}
			else if(arrList.size() == 3){
				obj.print((char)(arrList.remove(0)+65));
				obj.print(" ");
				obj.print((char)(arrList.remove(0)+65));
				obj.print((char)(arrList.remove(0)+65));
			}else if(arrList.size() == 2){
				obj.print((char)(arrList.remove(0)+65));
				obj.print((char)(arrList.remove(0)+65));
			}
			obj.println();
		}
		obj.close();
		}
}



