package LeetCoode;

import java.util.PriorityQueue;

public class que1792 {
    class Classes{
        int pass;
        int total;
        public Classes(int pass, int total) {
            this.pass=pass;
            this.total=total;
        }
        public double passRatio(){
            return (double)pass/total;
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Classes> pq = new PriorityQueue<>((a,b)->Double.compare(a.passRatio(), b.passRatio()));
        for(int []clas: classes){
            pq.add(new Classes(clas[0],clas[1]));
        }

        for(int i=0;i<extraStudents;i++){
            Classes c = pq.poll();
            c.pass++;
            c.total++;
            pq.add(c);
        }
        double res=0;
        while(!pq.isEmpty()){
            res+=pq.poll().passRatio();
        }
        return res/classes.length;
    }
    public static void main(String[] args) {

    }
}
