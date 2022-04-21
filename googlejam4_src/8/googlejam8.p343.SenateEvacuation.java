package googlejam8.p343;

import java.util.Scanner;
public class SenateEvacuation {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args){
		int cases=Integer.parseInt(sc.nextLine());
		for(int caseNo=0;caseNo<cases;caseNo++) {
			int N=Integer.parseInt(sc.nextLine());
			int[] members=new int[N];
			int totalMembers=0;
			for(int x=0;x<N;x++){
				members[x]=sc.nextInt();
				totalMembers+=members[x];
			}
			sc.nextLine();
			
			String ans="";
			
			while(totalMembers>0){
				int maxParty=0;
				int maxMembers=Integer.MIN_VALUE;
				for(int x=0;x<N;x++){
					if(members[x]>maxMembers){
						maxMembers=members[x];
						maxParty=x;
					}
				}
				ans=ans+(char)("A".charAt(0) + maxParty);
				members[maxParty]-=1;
				totalMembers--;
				///
				/*
				for(int x=0;x<N;x++) System.out.print(members[x]+" ");
				System.out.println("");*/
				maxMembers=Integer.MIN_VALUE;
				for(int x=0;x<N;x++){
					if(members[x]>maxMembers){
						maxMembers=members[x];
						maxParty=x;
					}
				}
				if(members[maxParty]-1<= 0.5*(totalMembers-1) && members[maxParty]>0 && totalMembers!=2){
					ans=ans+(char)("A".charAt(0) + maxParty);
					members[maxParty]-=1;
					totalMembers--;
					
					//////
					/*for(int x=0;x<N;x++) System.out.print(members[x]+" ");
					System.out.println("");*/
				}
				
				ans=ans+" ";
			}
			
			System.out.println("Case #"+(caseNo+1)+": "+ans);
		}
	}
}
