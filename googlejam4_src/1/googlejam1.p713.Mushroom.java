package googlejam1.p713;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mushroom {


		List<ArrayList<Integer>> cases = new ArrayList<ArrayList<Integer>>();
		List<Integer> method1List = new ArrayList<Integer>();
		List<Integer> method2List = new ArrayList<Integer>();
		
		public static void main(String[] args)
		{
			Mushroom so = new Mushroom();
			
			Scanner scanner;
			try {
				scanner = new Scanner(new File("A-large.in"));
			
				int testCases = scanner.nextInt();
			
				//System.out.println("testCases: "+ testCases);
				scanner.nextLine();
				for(int i=0; i<testCases; ++i)
				{
			
					so.cases.add(new ArrayList<Integer>());
					int plateNum = scanner.nextInt();
			
					for(int j = 0; j < plateNum; ++j){
						
						so.cases.get(i).add(scanner.nextInt());
					}
					
					
					
					
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			//so.readFile("test1.in");
			
			for(ArrayList<Integer> testCase : so.cases)
			{
				int size = testCase.size();
				int method1 = 0;
				int method2 = 0;
				int method2Rate = 0;
				
				for(int i2 = 1; i2 < size; ++i2){
					if(testCase.get(i2-1) - testCase.get(i2) > method2Rate) 
						method2Rate = testCase.get(i2-1) - testCase.get(i2);
				}
				
				for(int i1 = 1; i1 < size; ++i1){
					if(testCase.get(i1-1)>testCase.get(i1)){
						method1 += testCase.get(i1-1) - testCase.get(i1);
					}
					
					//if(i<size-1)
					method2 += Math.abs(method2Rate > testCase.get(i1-1) ? testCase.get(i1-1) : method2Rate);
				}
				
				so.method1List.add(method1);
				so.method2List.add(method2);
				
			
			}
			
			PrintWriter writer;
			try {
				writer = new PrintWriter("A-large.out");
				
				int counter = 0;
				for(int i=0; i<so.method1List.size();++i)
				{
					writer.print("Case #" + (++counter) + ": " + so.method1List.get(i) +" "+ so.method2List.get(i));
					if(counter<so.method1List.size())
					{
						writer.println();
					}
				}
				
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

}
