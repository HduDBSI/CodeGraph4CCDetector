package googlejam1.p753;


import java.util.Scanner;

/**
 * Created by wing on 4/17/15.
 */
public class Mushroom {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        int numInput = input.nextInt();

        for(int e = 1; e<=numInput ; e++){
            int numIn = input.nextInt();
            int[] numMashroom = new int[numIn];

            for(int i = 0; i<numIn;i++){
                numMashroom[i]=input.nextInt();
            }

            int case1 = 0;
            int case2max = 0;
            int case2 = 0;
            for(int i = 0; i<numIn -1 ; i++){
                if(numMashroom[i]>numMashroom[i+1]){
                    case1 += (numMashroom[i]-numMashroom[i+1]);
                }
            }

            for(int i = 0; i<numIn-1;i++){
                if (case2max<(numMashroom[i]-numMashroom[i+1])){
                    case2max = numMashroom[i]-numMashroom[i+1];
                }
            }

            for(int i = 0; i <numIn-1;i++){
                if(numMashroom[i]<case2max){
                    case2+=numMashroom[i];
                }else{
                    case2+=case2max;
                }

            }


            System.out.println("Case #"+e+": "+case1+" "+case2);

        }

    }
}
