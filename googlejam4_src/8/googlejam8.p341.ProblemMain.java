package googlejam8.p341;
import java.util.*;
import java.io.*;

public class ProblemMain {
    
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("A-large.in"));
//           System.setIn(new FileInputStream("A-small-attempt0.in"));
  //          System.setIn(new FileInputStream("sample.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        //    e.printStackTrace();
        }
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_cases = in.nextInt(); // Scanner has functions to read ints,
                                       // longs, strings, chars, etc.
        
        // test code
//        for( int i_test_code = 1; i_test_code <= 200; i_test_code++ )
//        {
//            solution(i_test_code, i_test_code);
//        }
//        
//      
        in.nextLine();
        // actual code
        for (int i_test = 1; i_test <= test_cases; ++i_test) {
            
            int party_members_count[] = new int[26];
            int total_members = 0;
        
            int num_parties = in.nextInt();
            in.nextLine();
            for( int i_party = 0; i_party < num_parties; i_party++ )
            {
                int num_members = in.nextInt();
                total_members += num_members;
                party_members_count[i_party] = num_members;
            }
            
            // algo, find two parties with max count, if no such party,
            // get max and second max
            StringBuilder buffer = new StringBuilder();
            while(total_members > 0 )
            {
                int party_max_members_index = -1;
                int party_second_max_members_index = -1;
                for( int i_party = 0; i_party < num_parties; i_party++ )
                {
                    if( party_max_members_index == -1 )
                    {
                        party_max_members_index = i_party;
                    }
                    else
                    {
                        if( party_members_count[i_party] >= party_members_count[party_max_members_index] )
                        {
                            party_second_max_members_index = party_max_members_index;
                            party_max_members_index = i_party;   
                        }
                        else
                        {
                            if( party_second_max_members_index == -1 
                                    || party_members_count[i_party] >= party_members_count[party_second_max_members_index] )
                            {
                                party_second_max_members_index = i_party;
                            }
                        }
                    }                    
                }
                if( party_members_count[party_max_members_index]/(float)total_members > 0.5 )
                {
                    System.out.println("Error Case #" + i_test + ": " + (buffer) );
                }

                // always keep max and second max close as possible
                
                if(total_members >= 4)
                {
                    // remove max and second max
                    if((party_members_count[party_max_members_index] - party_members_count[party_second_max_members_index] ) > 2 )
                    {
                        // remove two from max
                        buffer.append((char)('A' + party_max_members_index));
                        buffer.append((char)('A' + party_max_members_index));
                        buffer.append(' ');
                        party_members_count[party_max_members_index]-= 2;
                    }
                    else
                    {
                        // remove one from max, one from second max
                        buffer.append((char)('A' + party_max_members_index));
                        buffer.append((char)('A' + party_second_max_members_index));
                        buffer.append(' ');
                        party_members_count[party_max_members_index]-= 1;
                        party_members_count[party_second_max_members_index]-= 1;
                    }
                    total_members-=2;
                }
                else if( total_members == 3 )
                {
                    // can only remove single max
                    buffer.append((char)('A' + party_max_members_index));
                    buffer.append(' ');
                    party_members_count[party_max_members_index]-= 2;
                    total_members-=1;
                }
                else
                {
                    // remove last 2
                    buffer.append((char)('A' + party_max_members_index));
                    buffer.append((char)('A' + party_second_max_members_index));
                    buffer.append(' ');
                    party_members_count[party_max_members_index]-= 1;
                    party_members_count[party_second_max_members_index]-= 1;
                    total_members-=2;
               }
            }
            
            System.out.println("Case #" + i_test + ": " + (buffer) );
        }

        in.close();
    }

}
