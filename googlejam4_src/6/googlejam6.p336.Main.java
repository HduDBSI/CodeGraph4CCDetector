package googlejam6.p336;

import java.util.*;

/**
 * Created by akshitsharma on 4/16/2016.
 */
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trys, cases;
        trys = scanner.nextInt();
        cases = 0;
        while (cases < trys) {
            cases++;
            int n = scanner.nextInt();
            //int [][] solders = new int[2*n-1][n];

            ArrayList input = new ArrayList<>();
            Integer temp;
            for(int i=0;i<2*n-1;i++)
                for(int j=0;j<n;j++) {
                    temp = scanner.nextInt();
                    if(!input.contains(temp)){
                        input.add(temp);
                    }else{
                        input.remove(temp);
                    }
                }

            Collections.sort(input);

            Iterator<Integer> values = input.iterator();

            System.out.print("Case #"+cases+":");

            while (values.hasNext()){
                System.out.print(" "+values.next());
            }
            System.out.println();

        }

    }

}
