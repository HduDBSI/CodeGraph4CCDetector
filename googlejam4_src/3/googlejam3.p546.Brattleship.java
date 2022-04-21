package googlejam3.p546;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;


public class Brattleship {

	public static void main(String[] args) {
		Reader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		try {
			// get no. of testcases
			int testCaseNo = Integer.parseInt(b.readLine());
			int[] minCount = new int[testCaseNo];
			int index = 0;
			while (testCaseNo != 0) {
				String StrList = b.readLine();
				String[] splitList = StrList.split(" ");
				int n = Integer.parseInt(splitList[0]);
				int m = Integer.parseInt(splitList[1]);
				int w = Integer.parseInt(splitList[2]);
				if( n==1 && m==w){
					minCount[index] = w;
				}else if( w==1){
					minCount[index] = n*m;
				} else {
					minCount[index] = (w+((m-w)/w)+((m-w)%w==0?0:1))+((n-1)*(m-w));
				}
				index++;
				testCaseNo--;
			}

			for (int k = 0; k < minCount.length; k++) {
				System.out.println("Case #" + (k + 1) + ": "
						+ minCount[k]);
			}

		} catch (Exception e) {
			System.out.println("invalid inputs !!! \n"+ e.getMessage());
		} 

	}

}
