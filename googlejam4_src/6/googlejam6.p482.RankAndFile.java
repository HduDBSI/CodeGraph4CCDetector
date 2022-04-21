package googlejam6.p482;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;
public class RankAndFile {

	public static void main(String args[]) throws Exception {
		Writer writer = null;
		Scanner scanner = null;
		try{
			scanner= new Scanner(new BufferedReader(new FileReader("input_files/B-large.in")));
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("output_files/rankfile_output_large.txt"), "utf-8")); 

			int noOfTestCases = scanner.nextInt();
			System.out.println(noOfTestCases);
//			Set<Integer> set =null;
		    SortedSet<Integer> sortedSet =null; 

			for(int i =0;i<noOfTestCases;i++){
				HashMap<Integer, Integer> map = new HashMap<>();
//				set = new HashSet<>();
				sortedSet = new TreeSet<>(); 
				int noOfValues = scanner.nextInt();
//				System.out.println("no of values : "+noOfValues);
				for(int j=0;j<(noOfValues*2-1)*noOfValues;j++){
					int val = scanner.nextInt();
					if(!map.containsKey(val))
						map.put(val, 1);
					else{
						int value = map.get(val);
						map.put(val, value+1);
					}
				}

				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					int key = entry.getKey();
					int value = entry.getValue();
//					System.out.println(key + " : "+value);
					if(value%2!=0){
						sortedSet.add(key);
						if(sortedSet.size()==noOfValues)
							break;
					}
				}

				String printLine = "Case #"+(i+1)+": ";
//				System.out.println(Arrays.toString(sortedSet.toArray()));
//				for(int p =0;p<set.size();p++)
					for(Integer in : sortedSet)
						printLine+=in+" ";
					printLine = printLine.trim();
					printLine+="\n";
					writer.write(printLine);
			}
		}

		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			scanner.close();
			writer.close();	
		}
	}

}
