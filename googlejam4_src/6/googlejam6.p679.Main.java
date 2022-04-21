package googlejam6.p679;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("B-large (2).in"));
        PrintWriter pw=new PrintWriter("B-large.out" );
        String output = null;
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            int arr[][]=new int[2*n-1][n];
            for (int j = 0; j < arr.length; j++) {
                String line=sc.nextLine();
                int numArr[] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();//Массив строк в массив чисел JAVA 8
                arr[j]=numArr;
//                System.out.println(Arrays.toString(numArr));
            }
			String output1="";
			        int n1=arr[0].length;
			        int result[]=new int[n1];
			        Map<Integer,Integer> m=new HashMap<Integer,Integer>();
			        for (int i2 = 0; i2 < arr.length; i2++) {
			            for (int j = 0; j < n1; j++) {
			                if(m.containsKey(arr[i2][j])){
			                    m.put(arr[i2][j],new Integer(m.get(arr[i2][j])+1));
			                }else{
			                    m.put(arr[i2][j],new Integer(1));
			                }
			            }
			        }
			
			//        System.out.println(m);
			        int resultN=0;
			        for (Integer key : m.keySet()) {
			            if(m.get(key)%2==1){
			                result[resultN]=key;
			                resultN++;
			            }
			        }
			        Arrays.sort(result);
			//        System.out.println(Arrays.toString(result));
			        for (int i1 = 0; i1 < result.length; i1++) {
			            output1+=" "+result[i1];
			        }
			
			
			
			
			
			
			        output1 = "Case #" + (i+1) + ": "+output1;


            output=output1;
            pw.print(output+"\n");
        }

        pw.flush();
        pw.close();
        sc.close();


    }
}
