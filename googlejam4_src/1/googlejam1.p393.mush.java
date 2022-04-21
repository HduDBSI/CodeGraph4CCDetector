package googlejam1.p393;
import java.io.*;
import java.util.*;

class mush{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numcase = sc.nextInt();
		for(int i =0;i<numcase;i++){
			int numti = sc.nextInt();
			Queue<Integer> mushin1 = new LinkedList<Integer>();
			Queue<Integer> mushin2 = new LinkedList<Integer>();
			for(int j=0;j<numti;j++){
				int mushtime = sc.nextInt();
				mushin1.offer(mushtime);
				mushin2.offer(mushtime);
			}
			int t1 = 0;
			int t2 = 0;
			int musha = mushin1.poll();
			ArrayList<Integer> timediff = new ArrayList<Integer>();
			//timediff.add(musha);
			while(mushin1.peek()!=null){
				int mushb = mushin1.poll();
				if(musha - mushb>=0){
					t1 = t1 + musha - mushb;
				}
				timediff.add(musha - mushb);
				musha = mushb;
			}
			
			//Collections.sort(timediff);
			//int maxtd = timediff.get(0);
			boolean lastflag;
			int maxtd = Collections.max(timediff);
			lastflag = maxtd==timediff.get(timediff.size()-1);
			//System.out.println("maxtd: " +maxtd);
			while(mushin2.peek()!=null){
				int mushc = mushin2.poll();
				if(mushin2.peek()==null){
					break;
				}
				if(mushc<=maxtd){
					t2 = t2 + mushc;
				}
				else{
					t2 = t2 + maxtd;
				}
			}
			/*
			int shylvl = sc.nextInt();
			String ppl = sc.next();
			int inv = 0;
			int standing = Integer.parseInt(ppl.substring(0,1));
			for(int j=1;j<shylvl;j++){
				int shyppl = Integer.parseInt(ppl.substring(j,j+1));
				if(standing<j){
					inv = inv + j-standing;
					standing = j + shyppl;
				}
				else{
					standing = standing + shyppl;
				}
			}
			int last = Integer.parseInt(ppl.substring(shylvl));
			if(standing<shylvl){
				inv = inv + shylvl-standing;
				standing = shylvl + last;
			}
			else{
				standing = standing + last;
			}
			*/
			System.out.println("Case #"+(i+1)+": "+t1 + " " + t2);
		}
	}
	
}