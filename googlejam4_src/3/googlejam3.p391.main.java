package googlejam3.p391;


import java.io.*;

public class main {
	public static void main(String[] args) {
		try {
			BufferedReader read=new BufferedReader(new FileReader("A-large.in"));
			BufferedWriter write=new BufferedWriter(new FileWriter("out.in"));
			int N=Integer.valueOf(read.readLine());
			
			for(int i=0;i<N;i++){
				String list[]=read.readLine().split(" ");
				int R=Integer.parseInt(list[0]);
				int C=Integer.parseInt(list[1]);
				int W=Integer.parseInt(list[2]);
				int b=0;
				float c=Float.parseFloat(list[1]);
				float w=Float.parseFloat(list[2]);
				if(C==W){
					b=C+(R-1);
				}else if(W==1){
					b=C*R;
				}
				else if(C%2==0){
					if(C/2<W){
						b=(C/W)+W+((C/W)*(R-1));
					}else{
						if(C%W==0){
							b=(C/W)+(W-1)+((C/W)*(R-1));
						}else{
							b=(C/W)+W+((C/W)*(R-1));
						}
						
					}
					
				}else if(C%2!=0){
					if(C%W==0){
						b=(C/W)+(W-1)+((C/W)*(R-1));
					}else{
						b=(C/W)+W+((C/W)*(R-1));
					}
				}
					
				
				
				write.write("Case #" + (i+1) + ": "+ b+"\n");
				write.flush();
			}
		} catch(IOException ex) {
			ex.printStackTrace();
	}
	}
}

