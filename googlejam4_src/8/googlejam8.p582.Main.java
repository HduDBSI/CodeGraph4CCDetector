package googlejam8.p582;


import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Marcus on 4/8/2016.
 */
public class Main {

    //Fractiles - failed
    public static void main(String... orange) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int N = input.nextInt();
            int[] senatorList = new int[N];
            int max = 0;
            int maxValue = 0;
            int sum = 0;
            for(int i = 0; i<N; i++){
                senatorList[i] = input.nextInt();
                if(senatorList[i] > maxValue) {
                    maxValue = senatorList[i];
                    max = i;
                }
                sum += senatorList[i];
            }
            StringBuilder answerSB = new StringBuilder();
            while(sum>0){
                answerSB.append(String.valueOf((char)(max + 65)));
                senatorList[max]--;
                sum--;
                if(sum == 0) break;
				int[] maxes1 = new int[2];
				maxes1[0] = 0; //max
				maxes1[1] = 0; //maxValue
				for(int i = 0; i<N; i++) {
				    if (senatorList[i] > maxes1[1]) {
				        maxes1[1] = senatorList[i];
				        maxes1[0] = i;
				    }
				}
                int[] maxes = maxes1;
                max = maxes[0];
                maxValue = maxes[1];
                sum--;
                maxValue--;
                if(sum ==0) {
                    senatorList[max]--;
                    answerSB.append(String.valueOf((char)(max + 65)));
                    break;
                }
                else if((double)maxValue/(double)sum <=0.5 && sum > 1) {
                    senatorList[max]--;
                    answerSB.append(String.valueOf((char)(max + 65)));
                }
                else{
                    sum++;
                    maxValue++;
                }
                answerSB.append(" ");
				int[] maxes2 = new int[2];
				maxes2[0] = 0; //max
				maxes2[1] = 0; //maxValue
				for(int i = 0; i<N; i++) {
				    if (senatorList[i] > maxes2[1]) {
				        maxes2[1] = senatorList[i];
				        maxes2[0] = i;
				    }
				}
                maxes = maxes2;
                max = maxes[0];
                maxValue = maxes[1];
            }

            String answer = answerSB.toString();
            System.out.printf("Case #%d: %s\n", n + 1, answer);

        }

    }
}
