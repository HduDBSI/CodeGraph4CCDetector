package googlejam6.p587;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GCJ2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String fileName = "B-large.in";
		StringBuffer fileContent1 = new StringBuffer();
		
		String line1 = new String();
		
		FileReader fileReader = null;
		try {
		    fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		BufferedReader bufferedReader= new BufferedReader(fileReader);
		
		try {
		    while ((line1 = bufferedReader.readLine()) != null) {
		        fileContent1.append(line1 + ";");
		    }
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		try {
		    bufferedReader.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
        String fileContent = fileContent1.toString();
        String[] inputString = fileContent.split(";");
        StringBuffer outputString = new StringBuffer();
        int t = Integer.parseInt(inputString[0]);
        String[] input = new String[inputString.length - 1];
        int line = 1;
        
        for (int z = 0; z < t; z++) {
            outputString.append("Case #" + (z+1) + ":");
            int index = line;
            int n = Integer.parseInt(inputString[index]);
            index++;
            line = line + 2 * n;
            HashMap<Integer, Integer> height = new HashMap<Integer, Integer>();
            int[] miss = new int[n];
            ArrayList<Integer> number = new ArrayList<Integer>();
            int len = 0;
            
            for (int i = 0; i < (2*n-1); i++) {
                String[] lineHeight = inputString[index+i].split(" ");
                int[] num = new int[lineHeight.length];
                for (int j = 0; j < lineHeight.length; j++) {
                    num[j] = Integer.parseInt(lineHeight[j]);
                    Integer key = new Integer(num[j]);
                    if (height.containsKey(key)) {
                        Integer value = height.get(key);
                        value++;
                        height.put(key, value);
                    } else {
                        height.put(key, 1);
                        number.add(new Integer(key));
                    }
                }
            }
            
            int m = 0;
            
            for (int i = 0; i < number.size(); i++) {
                Integer value = height.get(number.get(i));
                
                if ((value%2) == 1) {
                    System.out.println(number.get(i));
                    miss[m++] = number.get(i);
                }
            }
            Arrays.sort(miss);
            for (int i = 0; i < miss.length; i++) {

                outputString.append(" " + miss[i]);
            }
            outputString.append("\n");
            
        }

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt")));
		writer.write(outputString.toString());
		writer.close();

    }

}
