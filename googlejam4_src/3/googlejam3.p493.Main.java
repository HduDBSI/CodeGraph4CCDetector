package googlejam3.p493;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//
//
//public class Main {
//
//	public static void main(String[]args) throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		 BufferedReader br = new BufferedReader(new FileReader("input.in"));
////		 PrintWriter out = new PrintWriter("output.txt");
//		int t = Integer.parseInt(br.readLine());
//		
//		
//		for(int i = 0;i<t;i++){
//			long n = Long.parseLong(br.readLine());
//			String curr = "1";
//			long ans = 1;
//			while(Long.parseLong(curr)<n){
//				StringBuffer temp = new StringBuffer(curr).reverse();
//				if(n-(Long.parseLong(curr)+1)>n-Long.parseLong(temp.toString()) && n-Long.parseLong(temp.toString())>=0){
//					curr = temp.toString();
//				}else{
//					long s0 = (Long.parseLong(curr)+1);
//					String s = ""+s0;
//					curr = s;
//				}
//				System.out.println(curr);
//				ans++;
//			}
//
//			System.out.println("Case #"+(i+1)+": "+ans);
//			
//		}
//		
//		br.close();
////		out.close();
//		
//	}
//
//
//}



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[]args) throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedReader br = new BufferedReader(new FileReader("input.in"));
		 PrintWriter out = new PrintWriter("output.txt");
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i = 0;i<t;i++){
			String[]in = br.readLine().split(" ");
			
			int r = Integer.parseInt(in[0]);
			int c = Integer.parseInt(in[1]);
			int w = Integer.parseInt(in[2]);
			out.println("Case #"+(i+1)+": "+(int)(Math.ceil((c*1.0/w)) - 1 + w)*r);
			
			
		}
		
		br.close();
		out.close();
		
	}


}

