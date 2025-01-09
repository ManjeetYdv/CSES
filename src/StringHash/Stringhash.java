package StringHash;

public class Stringhash {
    public static long hash(String str){
        int p=31;
        int mod=(int)1e9+7;
        long hash=0;
        long pPow=1;

        for(char ch: str.toCharArray()){
            int charVal=ch-'a';
            hash=(hash+ charVal*pPow)%mod;
            pPow=(pPow*p)%mod;
        }
        return hash;
    }
    public static long hashSubString(String str, int start, int end){
        int p=31;
        int mod=(int)1e9+7;
        long hash=0;
        long pPow=1;

        long startHash=0;
        long endHash=0;
        long pDivide=1;
        for(int i=0;i<=end;i++){
            if(i==start)pDivide=pPow;

            int charVal=str.charAt(i)-'a';
            hash=(hash+charVal*pPow)%mod;
            pPow=(pPow*p)%mod;
            if(i==start-1)startHash=hash;
            if(i==end) endHash=hash;


        }
        long diff=endHash-startHash;
//        Modular Division and Fermat's Little Theorem
//        In modular arithmetic, division is not directly defined because modular arithmetic operates
////        within a finite set of integers. To perform division, we use the modular multiplicative inverse.
//        a^-1 =a^m-2 mod m .. m is prime
        long modInv= modInverse(pDivide, mod);
        long subStringHash= (diff*modInv)%mod;
        return subStringHash;
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
        String s="de";
        System.out.println(hash(s));
        s=new String("fde");
        System.out.println(hashSubString(s,1,2));
    }
}
