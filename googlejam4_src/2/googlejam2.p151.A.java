package googlejam2.p151;
import java.util.Scanner;


public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCaseNum = scan.nextInt();
		long[] ADD = {0, 10, 19, 109, 199, 1099, 1999, 10999, 19999, 109999, 199999, 1099999, 1999999, 10999999, 19999999, 109999999, 199999999};

		for(int i = 0; i < testCaseNum; ++i){
			String nStr = scan.next().trim();
			long n = Long.parseLong(nStr);

			if(n <= 9){
				System.out.println("Case #" + (i + 1) + ": " + n);
				continue;
			}

			long ans = 0;
			for(int j = 0; j < nStr.length(); ++j){
				ans += ADD[j];
			}
			if(String.valueOf(n - 1).length() != nStr.length()){
				System.out.println("Case #" + (i + 1) + ": " + ans);
				continue;
			}
			if(nStr.charAt(0) == '1'){
				boolean v = true;
				for(int k = 1; k < (nStr.length() / 2); ++k){
					v = v && (nStr.charAt(k) == '0');
				}
				if(v == true){
					long bias = 1;
					for(int k = nStr.length() - 1; k >= (nStr.length() / 2) ; --k){
						ans += Long.parseLong(nStr.substring(k, k+1)) * bias;
						bias *= 10;
					}
					System.out.println("Case #" + (i + 1) + ": " + ans);
					continue;
				}
			}
			long bias = 1;
			n -= 1;
			nStr = String.valueOf(n);
			ans += 1;
			if(nStr.charAt(0) == '1'){
				boolean v = true;
				for(int k = 1; k < (nStr.length() / 2); ++k){
					v = v && (nStr.charAt(k) == '0');
				}
				if(v == true){
					bias = 1;
					for(int k = nStr.length() - 1; k >= (nStr.length() / 2) ; --k){
						ans += Long.parseLong(nStr.substring(k, k+1)) * bias;
						bias *= 10;
					}
					System.out.println("Case #" + (i + 1) + ": " + ans);
					continue;
				}
			}
			bias = 1;
			for(int k = 0; k < (nStr.length() / 2); ++k){
				ans += Long.parseLong(nStr.substring(k, k+1)) * bias;
				bias *= 10;
			}
			bias = 1;
			for(int k = nStr.length() - 1; k >= (nStr.length() / 2) ; --k){
				ans += Long.parseLong(nStr.substring(k, k+1)) * bias;
				bias *= 10;
			}

			System.out.println("Case #" + (i + 1) + ": " + ans);
		}

		scan.close();
	}
}
