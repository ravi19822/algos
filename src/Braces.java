import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Braces {

    public static void main(String[] args) {
        System.out.println("Inside Braces Problem ******");
        String s = "()[]{}(";
        Map<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("(",")");
        hashMap.put("{","}");
        hashMap.put("[","]");

        Stack<String> braces=new Stack<String>();
        boolean matchedBraces=true;
        for(int i=0;i<s.length();i++)
        {
            System.out.println("i is ***************************"+i);
            System.out.println("s.substring(i,1)"+s.substring(i,i+1));
            if(hashMap.containsKey(s.substring(i,i+1)))
            {
                System.out.println("Pushing inside stack");
                braces.push(s.substring(i,i+1));
            }
            else{

                if(!s.substring(i,i+1).equals(hashMap.get(braces.pop())))
                {
                    matchedBraces=false;
                    //System.out.println("Matched Braces is false"+i);
                    break;
                 //return matchedBraces;
                }
            }

        }
        if(matchedBraces && !hashMap.containsKey(s.substring(s.length()-1,s.length())))
        System.out.println("Matched Braces is true");
        else
            System.out.println("Matched Braces is false");

        //return matchedBraces;
    }
}
