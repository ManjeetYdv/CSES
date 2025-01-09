package AryanshiOT;
import java.util.*;

public class ques5 {

    public static int[] vehicleSlam(int[] vehicles) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int vehicle : vehicles) {
            boolean addVehicle = true;

            while (!stack.isEmpty() && stack.peekLast() > 0 && vehicle < 0) {
                int topVehicle = stack.peekLast();

                if (Math.abs(topVehicle) < Math.abs(vehicle)) {
                    stack.pollLast();
                } else if (Math.abs(topVehicle) == Math.abs(vehicle)) {
                    stack.pollLast();
                    addVehicle = false;
                    break;
                } else {
                    addVehicle = false;
                    break;
                }
            }

            if (addVehicle) {
                stack.offerLast(vehicle);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int vehicle : stack) {
            result[i++] = vehicle;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] vehicles1 = {3, -2, 0, 4};
        int[] vehicles2 = {12, -12};
        int[] vehicles3 = {8, 3, -6};

        System.out.println(Arrays.toString(vehicleSlam(vehicles1))); // Output: [3, 0, 4]
        System.out.println(Arrays.toString(vehicleSlam(vehicles2))); // Output: []
        System.out.println(Arrays.toString(vehicleSlam(vehicles3))); // Output: [8]
    }
}
