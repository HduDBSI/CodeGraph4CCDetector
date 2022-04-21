package googlejam8.p607;
import java.io.File;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) throws Exception {
		File f = new File("A-large (1).in");
		Scanner sc = new Scanner(f);
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int size = sc.nextInt();
			int[] number = new int[size];
			for(int j=0;j<size;j++) {
				number[j] = sc.nextInt();
			}
			System.out.print("Case #"+(i+1)+": ");
			last(number);
		}
		/*int[] x = {9,8,7,6,5,4,3,2,1};
		last(x);*/
	}
	public static  void last(int[] number) {
		int x = sum(number);
		if(x%2==1) {
			int max = 0;
			for(int i=1;i<number.length;i++) {
				if(number[i]>number[max]) {
					max = i;
				}
			}
			x--;
			number[max]--;
			System.out.print((char)(65+max)+" ");
		}
		do{
			int max=0,secondMax=0;
			for(int i=1;i<number.length;i++) {
				if(number[i]>number[max]) {
					max = i;
				}
			}
			secondMax = (max+1)%number.length;
			for(int i=0;i<number.length;i++) {
				if((number[i]>number[secondMax])&&(i!=max)) {
					secondMax = i;
				}
			}
			System.out.print((char)(65+max)+""+(char)(65+secondMax)+" ");
			number[max]--;
			number[secondMax]--;
			/*for(int i=0;i<number.length;i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();*/
			x-=2;
			//printMajority(number,x);
		}while(x>0);
		System.out.println();
		/*if(x == 1) {
			System.out.println("Bing");
		}*/
		//System.out.println(number[max]+"  "+number[secondMax]);
	}
}