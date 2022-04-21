package googlejam7.p094;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class B {
	public static void main(String args[]) {
		try (BufferedReader reader = new BufferedReader(new FileReader("B-large.in"))) {
			
		    int T = Integer.parseInt(reader.readLine());
		    String s;
		    for (int t = 1; t <= T; t++) {
		    	s = reader.readLine();
		    	//System.out.println(s);
		    	String a = s.split(" ")[0];
		    	String b = s.split(" ")[1];
		    	String a2 = a;
		    	String b2 = b;
		    	
		    	if (a.equals(b)) {
		    		a = a.replace('?', '0');
		    		b = a;
		    		System.out.println("Case #"+t+": "+a+" "+b);
		    	} else {
		    		ArrayList<String> as = new ArrayList<String>();
		    		ArrayList<String> bs = new ArrayList<String>();
		    		//as.add(a);
		    		//bs.add(b);
		    		int po = 0;
		    		while (a.indexOf("?") != -1 || b.indexOf("?") != -1) {
		    			if (a.charAt(po) == '?' && b.charAt(po) == '?') {
		    				as.add(a.replaceFirst("\\?", "1").replaceAll("\\?", "0"));
		    				bs.add(b.replaceFirst("\\?", "0").replaceAll("\\?", "9"));
		    				
		    				bs.add(b.replaceFirst("\\?", "1").replaceAll("\\?", "0"));
		    				as.add(a.replaceFirst("\\?", "0").replaceAll("\\?", "9"));
		    				
		    				a = a.replaceFirst("\\?", "0");
		    				b = b.replaceFirst("\\?", "0");
		    			} else if (a.charAt(po) == '?') {
		    				StringBuilder sb = new StringBuilder();
		    				sb.append(b.charAt(po));
		    				int bv = Integer.parseInt(sb.toString());
		    				
		    				if (bv < 9) {
		    				as.add(a.replaceFirst("\\?", ""+(bv+1)).replaceAll("\\?", "0"));
		    				bs.add(b.replaceAll("\\?", "9"));
		    				}
		    				if (bv > 0) {
		    				bs.add(b.replaceAll("\\?", "0"));
		    				as.add(a.replaceFirst("\\?", ""+(bv-1)).replaceAll("\\?", "9"));
		    				}
		    				a = a.replaceFirst("\\?", ""+bv);
		    			} else if (b.charAt(po) == '?') {
		    				StringBuilder sb = new StringBuilder();
		    				sb.append(a.charAt(po));
		    				int av = Integer.parseInt(sb.toString());
		    				
		    				if (av < 9) {
		    				bs.add(b.replaceFirst("\\?", ""+(av+1)).replaceAll("\\?", "0"));
		    				as.add(a.replaceAll("\\?", "9"));
		    				}
		    				if (av > 0) {
		    				as.add(a.replaceAll("\\?", "0"));
		    				bs.add(b.replaceFirst("\\?", ""+(av-1)).replaceAll("\\?", "9"));
		    				}
		    				
		    				b = b.replaceFirst("\\?", ""+av);
		    			} else {
		    				if (a.charAt(po) > b.charAt(po)) {
			    				as.add(a.replaceAll("\\?", "0"));
			    				bs.add(b.replaceAll("\\?", "9"));
		    				}
		    				if (a.charAt(po) < b.charAt(po)) {
			    				bs.add(b.replaceAll("\\?", "0"));
			    				as.add(a.replaceAll("\\?", "9"));
		    				}
		    			}
		    			po++;
		    		}
		    		as.add(a);
		    		bs.add(b);
		    		int mini = 0;
		    		long min2 = Long.MAX_VALUE;
		    		long minav = Long.MAX_VALUE;
		    		long minbv = Long.MAX_VALUE;
		    		for (int i = 0; i < as.size(); i++) {
		    			long av = Long.parseLong(as.get(i));
		    			long bv = Long.parseLong(bs.get(i));
		    			long diff = Math.abs(
		    					Long.parseLong(as.get(i)) -
		    					Long.parseLong(bs.get(i))
		    					);
		    			if (diff < min2) {
		    				min2 = diff;
		    				mini = i;
		    				minav = av;
		    				minbv = bv;
		    			} else if (diff == min2) {
		    				if (av < minav) {
			    				min2 = diff;
			    				mini = i;
			    				minav = av;
			    				minbv = bv;
		    				} else if (av == minav) {
		    					if (bv < minbv) {
				    				min2 = diff;
				    				mini = i;
				    				minav = av;
				    				minbv = bv;
		    					}
		    				}
		    			}
		    		}
		    		System.out.println("Case #"+t+": "+as.get(mini)+" "+bs.get(mini));
		    		
		  /*  		
		    		String temp = a2 + b2;
		    		ArrayList<String> p = new ArrayList<String>();
		    		p.add(temp);
		    		while (p.get(0).indexOf("?") != -1) {
		    			int size = p.size();
		    			ArrayList<String> np = new ArrayList<String>();
		    			for (int i = 0; i < p.size(); i++) {
		    				String tempp = p.get(i);
				    		for (int j = 0; j < 10; j++) {
				    			np.add(tempp.replaceFirst("\\?", ""+j));
				    		}
		    			}
		    			p = np;
		    		}
		    		String mins = "";
		    		int min = Integer.MAX_VALUE;
		    		for (String pos : p) {
		    			int diff = Math.abs(
		    						Integer.parseInt(pos.substring(0, a.length())) -
		    						Integer.parseInt(pos.substring(a.length(), a.length()*2))
		    					);
		    			if (diff < min) {
		    				min = diff;
		    				mins = pos;
		    			}
		    		}
		    		System.out.println("Case #"+t+": "+mins.substring(0, a.length())+" "+mins.substring(a.length(), a.length()*2));
*/
		    	}
		    	//System.out.println("here");
		    }
		} catch (Exception e) {
			e.printStackTrace(System.err);
			//System.out.println(e.toString());
		}
		
	}
}
