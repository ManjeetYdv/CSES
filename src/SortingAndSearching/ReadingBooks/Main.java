package SortingAndSearching.ReadingBooks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n=sc.nextInt();
        long max=0;
        long sum=0;
        for(int i=0;i<n;i++){
            int el=sc.nextInt();
            max=Math.max(max, el);
            sum+=el;
        }
        long exceptMax=sum-max;
        if(exceptMax< max) System.out.println(max*2);
        else System.out.println(sum);
    }
}
