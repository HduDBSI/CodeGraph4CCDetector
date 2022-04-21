package googlejam3.p425;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by pascal on 5/10/15.
 */
public class A {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int caseNum = 1;
        while((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int R = Integer.parseInt(parts[0]);
            int C = Integer.parseInt(parts[1]);
            int W = Integer.parseInt(parts[2]);
            int result = 0;

            if(W == 1) {
                result = R*C;
            } else {
                for(int i = W; i < C; i += W) {
                    result += R;
                }
                result += W;
            }

            System.out.println("Case #" + caseNum + ": " + result);
            caseNum++;
        }
    }
}
