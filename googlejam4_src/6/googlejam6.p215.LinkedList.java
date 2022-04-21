package googlejam6.p215;
import java.util.*;
public class LinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int[] inte;
        int counter = 1;
        ArrayList<Integer> arr;
        while(cases-- > 0){
            inte = new int[2501];
            int n = in.nextInt();
            for(int i = 0; i < 2*n-1; i++){
                for(int j = 0; j < n; j++){
                    int a = in.nextInt();
                    inte[a]++;
                }
            }
            arr = new ArrayList<>();
            for (int i = 0; i < 2501; i++){
                if (inte[i]%2 ==1)
                    arr.add(i);
            }
            Collections.sort(arr);
            System.out.print("Case #"+counter+": ");
            for (int i = 0; i < n; i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println("");
            counter++;
        }
    
    }
    
}
