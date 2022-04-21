package googlejam6.p395;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		for(int i=0; i<total;i++){
			int sizeForList = scan.nextInt();
			HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
			for(int j=0;j<sizeForList*(sizeForList*2-1);j++){
				int tempValue = scan.nextInt();
				if(values.containsKey(tempValue)){
					int val = values.get(tempValue);
					val++;
					values.put(tempValue, val);
				}
				else{
					values.put(tempValue, 1);
				}
			}
			int [] list = new int[sizeForList];
			int index = 0;
			for(Entry<Integer, Integer> tempVal : values.entrySet()) {
			    if(tempVal.getValue()%2==1){
			    	list[index] = tempVal.getKey();
			    	index++;
			    }
			}
			Arrays.sort(list);
			System.out.print("Case #" + (i+1) + ": ");
			for(int j=0;j<list.length;j++){
				if(j==0){
					System.out.print(list[j]);
				}
				else
				{
					System.out.print(" "+list[j]);
				}
			}
			System.out.println();
		}
	}
}