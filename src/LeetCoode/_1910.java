package LeetCoode;
import java.util.*;

public class _1910 {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0; i<s.length();i++){
            boolean removed=false;
            stack.push(s.charAt(i));
            if(s.charAt(i)==part.charAt(part.length()-1)){
                if(stack.size() < part.length()) break;
                for(int j=part.length()-1;j>=0;j--){
                    if(stack.peek()==part.charAt(j)){
                        stack2.push(stack.pop());
                    }
                    else break;
                }
                if(stack.isEmpty()) removed=true;

            }
            if(removed) stack2.clear();
            else while(!stack2.isEmpty()) stack.push(stack2.pop());
        }
        StringBuilder res= new StringBuilder();
        while(!stack.isEmpty()) res.append(stack.pop());
        res=res.reverse();
        return res.toString();
    }
}
