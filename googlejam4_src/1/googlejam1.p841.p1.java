package googlejam1.p841;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yilinhe on 4/17/15. All right reserved.
 */
public class p1 {
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(new FileInputStream( new File("p1small.txt")));
        BufferedWriter bfr = new BufferedWriter(new FileWriter( new File("p1small.result")));
        int counter = 1;
        input.nextLine();
        while(input.hasNext()){
            input.nextLine();
            String[] line = input.nextLine().split(" ");
			int[] res1 = new int[2];
			List<Integer> mushrooms =new ArrayList<>();
			for (String s : line){
			    mushrooms.add(Integer.valueOf(s));
			}
			int last = mushrooms.get(0);
			int rate = 0;
			for (int i = 1;i<mushrooms.size();i++){
			    int cur = mushrooms.get(i);
			    int diff = last - cur;
			    if (diff > 0){
			        res1[0]+=diff;
			    }
			    if (diff>rate){
			        rate = diff;
			    }
			    last = cur;
			}
			
			for (int i = 0;i<mushrooms.size()-1;i++){
			    int cur = mushrooms.get(i);
			    if (cur < rate){
			        res1[1] += cur;
			    }else{
			        res1[1] += rate;
			    }
			}
            int[] res = res1;
            System.out.printf("Case #%d: %d %d\n",counter++,res[0],res[1]);
        }
        bfr.flush();
    }
}
