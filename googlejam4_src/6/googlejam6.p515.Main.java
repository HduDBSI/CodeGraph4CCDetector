package googlejam6.p515;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

class Main {
	public static final String CASE = "Case #";
	Hashtable<String, Integer> rep;
	public static void main(String[] args) throws IOException {
		Main r = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		String line = "";
		String resp="";
		for(int i=1; i<=cases;i++){
			int n = Integer.parseInt(br.readLine());
			r.rep = new Hashtable<>();
			for(int j=0;j<n*2-1;j++){
				line = br.readLine();
				String[] nums = line.split(" ");
				for(int i2=0; i2<nums.length; i2++){
					Integer n1 = r.rep.get(nums[i2]);
					if(n1==null){
						r.rep.put(nums[i2], 1);
					}else{
						r.rep.put(nums[i2], n1+1);
					}
				}
			}
			Enumeration<String> k = r.rep.keys();
			int i1=0;
			int[] r1 = new int[n];
			while(k.hasMoreElements()){
				String actual = k.nextElement();
				int repeticiones = r.rep.get(actual);
				if(repeticiones%2!=0){
					r1[i1]=Integer.parseInt(actual);
					i1++;
				}
			}
			String resp1="";
			for(int i2=0; i2<r1.length; i2++){
				if(i2!=0) resp1+=" ";
				for(int j=i2+1;j<r1.length; j++){
					if(r1[i2]>r1[j]){
						int temp = r1[i2];
						r1[i2]=r1[j];
						r1[j]=temp;
					}
				}
				resp1+=r1[i2];
			}
			String ans = resp1;
			resp+=(Main.CASE+i+": "+ans+"\n");
		}
		System.out.print(resp);
	}

}
