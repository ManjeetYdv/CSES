package LeetCoode;

public class que2825 {
    public static boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length()<str2.length()) return false;
        int i=0;
        int j=0;

        while(i<str1.length()){
            if(str1.charAt(i)!=str2.charAt(j)){
                int num=str2.charAt(j)-'a';
                while(i<str1.length() && (str1.charAt(i)-'a'+1)%26 != num  && str1.charAt(i)!=str2.charAt(j) )i++;
                if(i==str1.length()) return false;
            }
            i++;
            j++;
            if(j==str2.length()) return true;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
    }
}
