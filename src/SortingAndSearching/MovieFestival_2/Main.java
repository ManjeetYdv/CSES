package SortingAndSearching.MovieFestival_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        List<int[]> movies= new ArrayList<>();
        for(int i=0;i<n;i++){
            int s=sc.nextInt();
            int e=sc.nextInt();
            movies.add(new int[]{s,e});
        }
        Collections.sort(movies, (a, b)->a[1]==b[1]?Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

       TreeMap<Integer, Integer> map = new TreeMap<>();
       map.put(0, k);
       int count=0;
        for(int [] movie : movies){
            int start=movie[0];
            int end=movie[1];
            Integer floorKey=map.floorKey(start);

            if(floorKey!=null){
                if(map.get(floorKey)==1) map.remove(floorKey);
                else map.put(floorKey, map.get(floorKey)-1);
                map.put(end, map.getOrDefault(end, 0)+1);
                count++;
            }
        }
        System.out.println(count);
    }
}
