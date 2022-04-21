package googlejam8.p792;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class A {

	static String aString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static int n;
	static HashMap<Character,Integer> aList;
	public static void main(String[] args) throws FileNotFoundException {
		//File aFile = new File("data.txt");
		Scanner s = new Scanner(System.in);
		int numIter = s.nextInt();
		for(int i = 0; i<numIter;i++)
		{
			n = s.nextInt();
			aList = new HashMap<Character,Integer>();
			for(int j = 0;j<n;j++)
				aList.put(aString.charAt(j),s.nextInt());
			System.out.print("Case #" + (i+1) + ": ");
			int count = 0;
			int count2 = 0;
			boolean flag = false;
			while(Collections.max(aList.values())!=0){
				int maxValueInMap=(Collections.max(aList.values()));
				int tempCount = 0;
				for (Entry<Character, Integer> entry : aList.entrySet()) {
			        if (entry.getValue()==maxValueInMap)
			            tempCount++;
			    }
				if(tempCount%2==0)
					count = 2;
				else
					count = 1;
				count2 = 0;
				for (Entry<Character, Integer> entry : aList.entrySet()) {
			        if (entry.getValue()==maxValueInMap){
			            count2++;
			            System.out.print(entry.getKey());
			            aList.replace(entry.getKey(), entry.getValue()-1);
			        }
			        if(count==count2)
			        	break;
			    }
				if(Collections.max(aList.values())!=0)
					System.out.print(" ");
				}
			if(i+1 != numIter)
				System.out.println("");
		}

	}

}
