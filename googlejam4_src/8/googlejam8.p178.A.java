package googlejam8.p178;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("src/round1/roundC/A-large (5).in"));
        PrintWriter pw = new PrintWriter("src/round1/roundC/A-large.out");
        int testCases = sc.nextInt();
     //   testCases=1;
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        for (int casen = 0; casen < testCases; casen++) {
            pw.printf("Case #%d: ",casen+1);

            int n = sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }
			int max1=0;
			for (int i = 0; i < arr.length; i++) {
			    if(arr[i]>max1){
			        max1=arr[i];
			    }
			}
//            int sum=0;
//            for (int i = 0; i < n; i++) {
//                sum+=arr[i];
//            }
            int max = max1;
           // System.out.println(Arrays.toString(arr));
            while(max!=0) {

                Queue<Integer> arrOfIndexOfMaxNum=new LinkedList<>();
				for (int i1 = 0; i1 < arr.length; i1++) {
				    if(arr[i1]==max) arrOfIndexOfMaxNum.add(i1);
				}
				Queue<Integer> indexOfMax = arrOfIndexOfMaxNum;

               // System.out.println(indexOfMax);
                if (indexOfMax.size() % 2 == 1) {
                    int t = indexOfMax.poll();
                    arr[t]--;
                    pw.print(alphabet.charAt(t) + " ");
                }
                while (!indexOfMax.isEmpty()) {
                    int t1 = indexOfMax.poll();
                    int t2 = indexOfMax.poll();
                    arr[t1]--;
                    arr[t2]--;
                    pw.print(alphabet.charAt(t1) );
                    pw.print(alphabet.charAt(t2) + " " );
                }
				int max2=0;
				for (int i = 0; i < arr.length; i++) {
				    if(arr[i]>max2){
				        max2=arr[i];
				    }
				}
                max = max2;
            }
            pw.println();





            pw.flush();
        }

        pw.close();
        sc.close();

    }

}
