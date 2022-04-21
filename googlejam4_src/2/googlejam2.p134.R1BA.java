package googlejam2.p134;


import java.util.Scanner;

public class R1BA {

	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=1; i<=t; i++){
			long n = in.nextLong();
			long k = n;
			int log = 1; //log is num of digits
			long totalPower = 1;
			while(k/10>0){
				log++;
				k=k/10;
				totalPower = totalPower*10;
			}
			
			long total = 0;
			if(log == 1){
				total = n;
			} else {
				total = 10;
				long power = 1;
				for(int j = 2; j<= log-1; j++){
					if(j%2==0) power = power*10;
					total+=power; //now we're at 999900001
					total+=(1+(j%2)*9)*power-1;
				}
				//last power of 10...
				if(log%2==0) power=power*10;
				if(n!=totalPower){
					long rem = n%(power*(1+(log%2)*9)); //last (log+1)/2 digits 
					k = n/(power*(1+(log%2)*9));
					
					if(rem==0){
						k--;
						rem = power*(1+(log%2)*9);
					}
					if(k<=power/10){
						total+=n-totalPower;
					} else {
						long power2 = power/10;
						while(k>0){
							total+=power2*(k%10);
							power2=power2/10;
							k=k/10;
						}
						total+=rem;
					}
				}
				
			}
			
			
			System.out.print("Case #" + i + ": ");
			System.out.print(total);
			System.out.println();
		}
		
		in.close();
	}
}
