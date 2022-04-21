package googlejam6.p600;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RankAndFile {
	

	public static void main(String[] args) {
		try {
			final Scanner sc = new Scanner(new File(args[0]));
			final FileWriter writer = new FileWriter(new File("rankAndFile.out"));
			final int numberOfCases = sc.nextInt();
			int currentCase = 0;
			sc.nextLine();
			while(currentCase < numberOfCases){
				final int n = sc.nextInt();
//				System.out.println(n);
				Map<Integer, Integer> heights = new HashMap<>();
				for (int i = 0; i < 2*n-1; i++){
					for (int j = 0; j < n; j++){
						final int next = sc.nextInt();
//						System.out.println(next);
						if(heights.containsKey(next)){
							heights.put(next, heights.get(next).intValue() + 1);
						} else {
							heights.put(next, 1);
						}
					}	
				}
				final List<Integer> missingRow = new ArrayList<>();
						for (Integer height:heights.keySet()){
				//			System.out.println("height: " + height + "  number: " + heights.get(height));
							if(heights.get(height)%2 != 0){
								missingRow.add(height);
							}
						}
						Collections.sort(missingRow);
						StringBuilder builder = new StringBuilder();
						for(Integer integer:missingRow){
							builder.append("" + integer + " ");
						}
				final String result = builder.toString().trim();
				System.out.println("Case #" + (currentCase + 1) + ": " + result);

				writer.write("Case #" + ++currentCase + ": " + result + "\n");
			}
		
			writer.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
