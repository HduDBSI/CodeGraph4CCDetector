package googlejam6.p457;

import java.util.Scanner;
public class RankAndFile {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] runOnce){
		int testCases=Integer.parseInt(sc.nextLine());
		for(int caseNo=0;caseNo<testCases;caseNo++) {
			int N;
			boolean[] height=new boolean[2501];
			int[] remainingPeople,arrangedPeople;
			
			int currentRead,ram1,ram2,z;
			
			
			N=Integer.parseInt(sc.nextLine());
			for(int y=0;y<((2*N)-1);y++){
				for(int x=0;x<N;x++){
					currentRead=sc.nextInt();
					/*
					if(height[currentRead]) System.out.println("removing "+currentRead);
					else System.out.println("adding "+currentRead);*/
					height[currentRead]=!height[currentRead];	
				}
				sc.nextLine();
			}
			remainingPeople=new int[N];
			int y=0;
			for(int x=0;x<2501;x++){
				if(height[x]){
					remainingPeople[y]=x;
					y++;
				}
			}
			ram1=Integer.MAX_VALUE;
			
			for(int x=0;x<N;x++) if(remainingPeople[x]<ram1) ram1=remainingPeople[x];
			arrangedPeople=new int[N];
			arrangedPeople[0]=ram1;
			
			for(y=1;y<N;y++){
				ram2=Integer.MAX_VALUE;
				for(int x=0;x<N;x++){
					z=remainingPeople[x];
					if(z<ram2&&z>ram1){
						ram2=z;
					}
				}
				arrangedPeople[y]=ram1=ram2;
			}
			System.out.print("Case #"+(caseNo+1)+": ");
			for(y=0;y<N;y++){
				System.out.print(arrangedPeople[y]);
				if(y!=N-1) System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
