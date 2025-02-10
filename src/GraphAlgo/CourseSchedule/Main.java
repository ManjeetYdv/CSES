package GraphAlgo.CourseSchedule;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        int[]inDegree= new int[n];
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;
            b--;
            graph.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);

        while(!queue.isEmpty()){
            int node=queue.poll();
            order.add(node);

            for(int neigh:  graph.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0) queue.add(neigh);
            }
        }
        if(order.size()!=n){
            System.out.println("IMPOSSIBLE");
        }
        else{
            for(int el : order) System.out.print((el+1)+" ");
        }
    }
}
