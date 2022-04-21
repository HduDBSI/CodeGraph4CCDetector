package googlejam1.p768;
import java.util.Scanner;


public class A1 {
	 public static void main(String[] args) throws Exception
	 {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=1;t<=T;t++){
	        	int N = sc.nextInt();
	        	int[] mushrooms = new int[N];
	        	int[] diff = new int[N-1];
	        	long total1=0;
	        	long total2=0;
	        	int max =0;
	        	mushrooms[0]=sc.nextInt();
	        	for(int n=1;n<N;n++){
	        		mushrooms[n]=sc.nextInt();
	        		diff[n-1]=mushrooms[n-1]-mushrooms[n];
	        		total1+=Math.max(diff[n-1],0);
	        		if(diff[n-1]>max){
	        			max=diff[n-1];
	        		}
	        	}
	        	
	        	//int c=0;
	        	double c = (double)max/10;
	        	//System.out.println(c);
	        	boolean check=true;
	        	//for(c=0;c<=10000;c++){
	        		total2=0;
	        		check=true;
	        		for(int i=1;i<N;i++){
	        			if(mushrooms[i]==0){	        				
	        				if(mushrooms[i-1] > c*10){
	        					check=false;
	        					break;
	        				}else{
	        					total2=total2+ mushrooms[i-1];
	        				}
	        			}else{
	        				if(mushrooms[i-1]-mushrooms[i]>10*c){
	        					check=false;
	        					break;
	        				}else{
	        					if(10*c>=mushrooms[i-1]){        						
	        						
	        						total2=total2+mushrooms[i-1];
	        					}else{
	        						total2=(long) (total2+(int)10*c);
	        					}
	        				}
	        			}
	        		}
	        		//if(check==true){
	        			//System.out.println(c);
	        			System.out.println("Case #"+t+": "+total1+" " +(total2));
	        			//break;
	        		//}
	        	//}
	        	//System.out.println(c);
	        	//if(check==false)
	        	//System.out.println("Case #"+t+": "+total1+" "+total2);
	        	
	        }
	        
	 }
}
