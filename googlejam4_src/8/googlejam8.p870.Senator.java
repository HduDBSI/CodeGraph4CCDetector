package googlejam8.p870;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Senator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		File file = new File("input2");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int tcs = Integer.parseInt(br.readLine());
		
		while(tcs-- > 0){
			
			Map<Integer,Character> alphabets = new HashMap<Integer,Character>();
			
			alphabets.put(1,'A');
			alphabets.put(2,'B');
			alphabets.put(3,'C');
			alphabets.put(4,'D');
			alphabets.put(5,'E');
			alphabets.put(6,'F');
			alphabets.put(7,'G');
			alphabets.put(8,'H');
			alphabets.put(9,'I');
			alphabets.put(10,'J');
			alphabets.put(11,'K');
			alphabets.put(12,'L');
			alphabets.put(13,'M');
			alphabets.put(14,'N');
			alphabets.put(15,'O');
			alphabets.put(16,'P');
			alphabets.put(17,'Q');
			alphabets.put(18,'R');
			alphabets.put(19,'S');
			alphabets.put(20,'T');
			alphabets.put(21,'U');
			alphabets.put(22,'V');
			alphabets.put(23,'W');
			alphabets.put(24,'X');
			alphabets.put(25,'Y');
			alphabets.put(26,'Z');
			
			int n = Integer.parseInt(br.readLine());
			
			List<Long> senators = new ArrayList<Long>();
			
			String s[] = br.readLine().split(" ");
			
			for(int i = 0; i < s.length; i++){
				senators.add(Long.parseLong(s[i]));
			}

			while(!(Collections.frequency(senators, (long)0) == senators.size())){
				String x="";
				for(int i = 0; i < 2; i++){
					
					int index = senators.indexOf(Collections.max(senators));
					if(senators.get(index) == 0){
						break;
					}
					if(Collections.frequency(senators, (long)1) > 2 && Collections.frequency(senators, (long)1) % 2 > 0){
						senators.set(index, senators.get(index) - 1);
						x=""+alphabets.get(index + 1);
						break;
					}
					senators.set(index, senators.get(index) - 1);
					x = x + alphabets.get(index + 1);
				}
			
				System.out.print(x);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
