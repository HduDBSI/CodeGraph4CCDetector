package googlejam6.p602;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
          
public class Main2 {
	
	public static int T, N, M;
	public static int[][] map;
	public static int[][] input;
	public static int[] minIndex;
	public static boolean[] visited;
	public static int cnt;
	
    public static void main(String[] arg) throws IOException {
         
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuffer sb = new StringBuffer();
    	
    	T = Integer.parseInt(br.readLine());
    	
    	for(int t = 1 ; t <= T ; t++){
    		sb.append("Case #"+t+":" );
    		N = Integer.parseInt(br.readLine());
    		M = 2*N-1;
    		input = new int[M][N];
    		int[] height = new int[2501];  
    		
    		for(int i = 0 ; i < M ; i++){
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			
    			for(int j = 0 ; j < N ; j++){
    				input[i][j] = Integer.parseInt(st.nextToken());
    				height[input[i][j]] += 1;
    			}
    		}
    		
    		for(int i = 0 ; i <= 2500 ; i++){
    			if(height[i]%2 == 1){
    				sb.append(" ").append(i);
    			}
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
}