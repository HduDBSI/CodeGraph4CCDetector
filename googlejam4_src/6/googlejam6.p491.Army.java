package googlejam6.p491;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Army {
    public static void main(String[] args) throws Exception {
        String line;
        String fileName = args[0];
        System.out.println("fileName=" + fileName);

        FileWriter fw = new FileWriter(fileName + ".out.txt");

        // fw.write("something");

        InputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        try {
            line = br.readLine();
            Long count = Long.valueOf(line);

            System.out.println("count=" + count);

            Long current = 0L;
            while (current++ < count) {

                line = br.readLine();
                final int N = Integer.valueOf(line);
                final int rowNum = 2* N -1;
				Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
				int i = 0;
				while (i< rowNum) {
				    String line1 = br.readLine();
				    
				    //System.out.println(line);
				    
				    String[] numbers = line1.split("\\s+");
					for (int i1=0; i1<numbers.length; i1++) {
					    int currentNumber = Integer.valueOf(numbers[i1]);
					    
					    int oldCount = 0;
					    if (countMap.containsKey(currentNumber)) {
					        oldCount = countMap.get(currentNumber);
					    }
					    
					    countMap.put(currentNumber, oldCount+1);
					}
				    
				    i++;
				}
				int[] result2 = new int[N];
				int i1=0;
				for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
				    
				    if (entry.getValue()%2 != 0) {
				        result2[i1++] = entry.getKey();
				    }
				}
				
				int[] result1 = result2;
				Arrays.sort(result1);
				
				StringBuilder tmp = new StringBuilder();
				for(int j=0; j<result1.length; j++) {
				    tmp.append(String.valueOf(result1[j])).append(" ");
				}
                
                String result = tmp.toString().trim();
                
                
                fw.write("Case #" + current + ": " + result + "\n");
            }
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
