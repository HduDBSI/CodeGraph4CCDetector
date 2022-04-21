package googlejam6.p375;
import java.util.*;
public class rank{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            System.out.print("Case #"+(i+1)+": ");
            int n = sc.nextInt();
            int[] ar = new int[2505]; 
            int max = 0;
            for(int j=0;j<(2*n-1)*n;j++){
                int temp = sc.nextInt();
                ar[temp]++;
                if(temp>max){
                    max = temp;
                }
            }

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int m= 0;m<=max;m++){
                if(ar[m]%2!=0){
                    arr.add(m);
                }
            }

            for(int nn=0;nn<arr.size()-1;nn++){
                System.out.print(arr.get(nn)+" ");
            }
            System.out.println(arr.get(arr.size()-1));
        }
    
    }
}
