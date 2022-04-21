package googlejam9.p142;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RoundThreeProblemThree {

    public static void main(String[] args) {

//        String ipf = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/small.in";
//        String opf = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/small.out";
        
        String ipf = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/large.in";
        String opf = "/Users/KiRaN/Desktop/CodeBase/Google_CodeBase/SheepSleep/src/large.out";
        
        
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(ipf));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(opf));

            // Total number of test cases
            int noOfTestCases = Integer.valueOf(bufferedReader.readLine());
            
            
            
            for (int testCases = 0; testCases < noOfTestCases; testCases++){
                String var1 = bufferedReader.readLine();
                int var2 = Integer.parseInt(var1.split(" ")[0]);
                long var3 = Long.parseLong(var1.split(" ")[1]);
                long var4 = var3;
                long var5;
                String v6 = "";
                String v7 = "0";
                
                for(int it1=2;it1<var2;it1++){
                    v6 += v7;

                    for(int it2=1;it2<var2;it2++){
                        
                        if(it1<=it2)
                            v6 += "1";
                        else
                            v6 += "0";
                        
                    }

                    v6 += "\n";

                }
                for(int it3=0;it3<var2;it3++){
                    
                        v6 += "0";
                    
                }
                
                boolean v8[]  = new boolean[var2-1];
//              for(int i = 0; i < (b-1); i++){
//                  tempA[i] = false;
//                  
//              }
                long v9 = (long) Math.pow(2, (var2-2));
                System.out.println("  maxPossible  " + v9);
                if(var2 == 2 && var3 == 1){
                    
                    bufferedWriter.write("Case #" + (testCases + 1) + ": " + "POSSIBLE" + "\n");
                    bufferedWriter.write("01" + "\n");
                    bufferedWriter.write("00" + "\n");
                    System.out.println("Case #" + (testCases + 1) + ": " + "POSSIBLE" + "\n");
                    System.out.println("01" + "\n");
                    System.out.println("00" + "\n");

                }else if(var3 > v9){
                    

                    bufferedWriter.write("Case #" + (testCases + 1) + ": " + "IMPOSSIBLE" + "\n");
                    System.out.println("Case #" + (testCases + 1) + ": " + "IMPOSSIBLE" + "\n");
                    
                }else{
                    
                    bufferedWriter.write("Case #" + (testCases + 1) + ": " + "POSSIBLE" + "\n");

                    var5 = v9/2;
                    for(int i = 0; i < (var2-1); i++){
                        
                        if(var4 == 0)
                            break;
                        
                        if(var4 >= var5){
                            
                            v8[i] = true;
                            var4 -= var5;
                            
                        }
                        var5 /=2;
                        
                    }
                    String tempresult = "0";

                    for(int i = 0; i < (var2-1); i++){
                        if(v8[i]){
                            tempresult = tempresult + "1";
                        }else{
                            tempresult = tempresult + "0";
                        }
                        
                    }   
                    
                    v6 = tempresult + "\n" + v6;

                    
                    System.out.println(v6);

                    bufferedWriter.write(v6 + "\n");

                }


                

            }
                
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException fileNotFoundException) {

            System.out.println("Some Exception: " + fileNotFoundException.getMessage());
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {

            System.out.println("Some Exception: " + ioException.getMessage());
            ioException.printStackTrace();

        } catch (Exception exception) {
            
            System.out.println("Some Exception: " + exception.getMessage());
            exception.printStackTrace();
        }

    }

}
