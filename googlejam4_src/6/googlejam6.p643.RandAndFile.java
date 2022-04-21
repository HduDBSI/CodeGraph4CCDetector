package googlejam6.p643;
import java.util.*;

public class RandAndFile {

    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int testcase = 1; testcase <= t; testcase++) {

            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();

            //each list
            for(int a=0; a<n*2-1; a++) {

                //each element in the list
                for(int b=0; b<n; b++) {
                    list.add(sc.nextInt());
                }

            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1 > o2) return 1;
                    else if(o1 < o2) return -1;
                    else return 0;
                }
            });

            List<Integer> answer = new ArrayList<Integer>();
            int size = list.size();
            int prev = list.get(0);
            int count = 1;

            for(int i=1; i<size; i++) {
                if(list.get(i) != prev) {

                    if(count % 2 == 1) {
                        answer.add(prev);
                    }

                    count = 1;
                    prev = list.get(i);

                } else {
                    count++;
                }
            }

            if(count % 2 == 1) {
                answer.add(prev);
            }

            System.out.printf("Case #%d:", testcase);
            for(int j=0; j<answer.size(); j++) {
                System.out.print(" " + answer.get(j));
            }
            System.out.println();


        }
    }
}
