package googlejam8.p855;


import java.util.*;

public class Jam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x[],sum;
        String gg ;
        for(int i = 0;i<t;i++){
            gg = "Case #"+(i+1)+": ";
            int n = sc.nextInt();
            x = new int[n];
            sum = 0;
            for(int j = 0;j<n;j++){
                int m = sc.nextInt();
                x[j] = m;
                sum+=m;
            }
            while(sum>0){
            int max1 = 0,max2 =0, dex1 = 0,dex2 = 0;
				for(int i1 = 0;i1<x.length;i1++){
				    if(x[i1]>=max1){
				        max2 = max1;
				        dex2 = dex1;
				        max1 = x[i1];
				        dex1 = i1;
				    }
				}int a1[];
				
				a1 = max1==max2?new int[]{max1,max2,dex1,dex2}:new int[]{max1,dex1};
			int a[] = a1;
            if(sum==3){
                  for(int k = 0;k<x.length;k++)
                    if(x[k]<=a[0]&&x[k]>0&&k!=a[1]){
                        x[k]--;
                        gg=gg+(char)(k+65)+" ";
                        sum--;
                        break;
                    }
            }else if(a.length!=4){
                if(x[a[1]]-2!=0){
                x[a[1]]-=2;
                sum-=2;
                gg = gg + (char)('A'+a[1])+(char)(a[1]+'A')+" "; 
                }else{
                    x[a[1]]--;
                sum--;
                gg = gg + (char)('A'+a[1])+" "; 
                }
           }else if(a.length==4){
               x[a[2]]--;
                x[a[3]]--;
               gg = gg + (char)('A'+a[2])+(char)(a[3]+'A')+" "; 
                sum-=2;
               
            }
                }
            System.out.println(gg);
        }
        
                }
    
}
