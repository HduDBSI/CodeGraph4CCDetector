package googlejam6.p311;
import java.util.*;
import java.io.*;
public class B{
  public static void main(String[] args) throws Exception{
    BufferedReader in = new BufferedReader(new FileReader("B-large.in"));
    int t = Integer.parseInt(in.readLine());
    String[] input = new String[t];
    int[] sizes = new int[t];
    PrintWriter out = new PrintWriter("output.txt");
    for (int i = 0; i < t; i++){
	int size = Integer.parseInt(in.readLine());
	sizes[i] = size;
	String temp = in.readLine();
	for(int j = 1;j<2*size-1;j++){
        	temp+= " "+in.readLine();
	}
	input[i] = temp;
    }
    for(int i = 0;i<t;i++){
	int n = sizes[i];
	String j = input[i];
	int[] list = new int[2501];
	for(int i2 = 0;i2<2501;i2++){
	    list[i2] = 0;
	}
	String[] lst = j.split(" ");
	int l = lst.length;
	for(int i1 = 0;i1<l;i1++){
	    int temp = Integer.parseInt(lst[i1]);
	    list[temp]++;
	}
	int[] ans = new int[n];
	int count = 0;
	int i3 = 0;
	while(count<n){
	    i3++;
	    if(list[i3]%2==1){
		ans[count] = i3;
		count++;
	    }
	}
	Arrays.sort(ans);
	String res = "";
	for(int d = 0;d<n-1;d++){
	    res+=ans[d]+" ";
	}
	res+=ans[n-1];
	String output = res;
	out.println("Case #"+(i+1)+": "+output);
    }
    out.close();
    }
}
