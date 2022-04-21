package googlejam6.p205;
import java.util.*;
import java.lang.*;
import java.math.*;

public class rankAndFile
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int numberOfTests = in.nextInt();

        // in.nextLine();
        for (int i = 0; i < numberOfTests; i++)
        {
        	int n = in.nextInt();
            int [] arr = new int[2500];
            for (int j = 1; j < 2 * n; j++){
                for (int k = 1; k <= n; k++){
                    arr[in.nextInt() - 1]++;
                }
            }

            System.out.print("Case #" + (i + 1) + ":");

            int found = 0;
            for (int k = 0; k < 2500; k++){
                if (arr[k] != 0 && arr[k] % 2 != 0){
                    System.out.print(" " + (k + 1));
                    found++;
                    if (found == n){
                        break;
                    }
                }
            }
            System.out.println("");
        }  
    }
}