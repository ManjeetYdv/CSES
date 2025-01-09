package StringHash;

public class RabinKarp {

    public static boolean rabin(String string, String subString){
        if(subString.length()>string.length()) return false;
       int p=31;
       int mod=(int)1e9+7;
       long hash1=0;
       long pPow=1;

       for(char ch:subString.toCharArray()){
           hash1=(hash1+(ch-'a')*pPow)%mod;
           pPow=(pPow*p)%mod;
       }

       long hash2=0;
       pPow=1;
       int n=string.length();
       int m=subString.length();
       for(int i=0;i<m;i++){
           char ch=string.charAt(i);
           hash2=(hash2+(ch-'a')*pPow)%mod;
           if(i<m-1)pPow=(pPow*p)%mod;
       }

        if (hash1 == hash2 && string.substring(0, m).equals(subString)) {
            return true;
        }
       long modInv=modInverse(p, mod);
       for(int i=m;i<n;i++){
           char outGoing=string.charAt(i-m);
           char curr=string.charAt(i);
           hash2=(hash2-(outGoing-'a')+mod)%mod;
           hash2=(hash2*modInv)%mod;
           hash2=(hash2+(curr-'a')*pPow)%mod;

           if (hash2 == hash1 && string.substring(i - m + 1, i + 1).equals(subString)) {
               return true;
           }
       }
       return false;
    }
    // Function to compute modular multiplicative inverse using Fermat's Little Theorem
    private static long modInverse(long base, int mod) {
        return power(base, mod - 2, mod)%mod;
    }

    // Function to compute base^exp % mod
    private static long power(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(rabin("abcd", "ad"));
    }
}
