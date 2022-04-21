package googlejam8.p270;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int itt = 1; itt <= T; itt++){

            int N = sc.nextInt();
            int[] senators = new int[N];

            int total = 0;

            for(int i = 0; i < N; i++){
                senators[i] = sc.nextInt();
                total += senators[i];
            }

            //System.out.println("TOTAL: " + total);

            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + itt + ":");
            while(total > 0){
                //evacuation
                String evac = "";

                int max = 0;
                int index = -1;
                for(int i = 0; i<N; i++){
                    if(senators[i] > max){
                        max = senators[i];
                        index = i;
                    }
                }

                total--;
                senators[index]--;
                evac += (char)(index + (int)'A');

                if(total > 0) {

                    int majority = ((total - 1) / 2) + 1;

                    max = 0;
                    index = -1;
                    int count = 0;
                    for (int i = 0; i < N; i++) {
                        if (senators[i] > max) {
                            max = senators[i];
                            index = i;
                        }
                        if (majority == senators[i]) count++;
                    }

                    if (count < 2) {

                        total--;
                        senators[index]--;
                        evac += (char)(index + (int)'A');
                    }
                }

                sb.append(" " + evac);

            }

            System.out.println(sb);

        }

    }
}
