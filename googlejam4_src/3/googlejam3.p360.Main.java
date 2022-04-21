package googlejam3.p360;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int numInputs = input.nextInt();
        for(int i = 0; i<numInputs;i++){
            int R = input.nextInt();
            int C = input.nextInt();
            int W = input.nextInt();
			int result;
			if((W<=C/2&&C%W==0)||W==C) {
			    result = C / W * R + W - 1;
			}else {
			    result = C/W*R+W;
			}
            int r = result;
            System.out.println("Case #"+(i+1)+": "+r);
        }
    }
}
