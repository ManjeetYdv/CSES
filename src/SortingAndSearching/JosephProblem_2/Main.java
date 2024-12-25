//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt(); // Number of children
//        int k = scanner.nextInt(); // Step size (every k-th child is removed)
//        scanner.close();
//
//        // LinkedList to represent children (1 to n)
//        LinkedList<Integer> children = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            children.add(i);
//        }
//
//        // To store the order of removal
//        List<Integer> removalOrder = new ArrayList<>();
//
//        // Start with the first child
//        int idx = 0;
//
//        while (!children.isEmpty()) {
//            // Calculate the next index to remove
//            idx = (idx + k - 1) % children.size();
//            // Remove the child and add to the result
//            removalOrder.add(children.remove(idx));
//        }
//
//        // Output the removal order
//        for (int i = 0; i < removalOrder.size(); i++) {
//            System.out.print(removalOrder.get(i) + (i == removalOrder.size() - 1 ? "\n" : " "));
//        }
//    }
//}
