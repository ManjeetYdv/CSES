package SegmentTree;

public class Main {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.find(0, 9));
        System.out.println(st.find(1, 9));
        System.out.println(st.find(4, 4));
        st.update(0, 100);
        st.update(1, 1000);
        System.out.println(st.find(0,1));
    }
}
