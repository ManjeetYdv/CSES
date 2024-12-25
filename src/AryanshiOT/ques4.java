package AryanshiOT;

import java.util.HashSet;
import java.util.Set;

public class ques4 {
    public static long[] solution(long[][] segments) {
        Set<Long> uniqueBytes = new HashSet<>();
        long[] result = new long[segments.length];

        for (int i = 0; i < segments.length; i++) {
            long start = segments[i][0];
            long end = segments[i][1];

            // Add all bytes in the current segment to the set
            for (long j = start; j <= end; j++) {
                uniqueBytes.add(j);
            }

            // Record the current size of the set
            result[i] = uniqueBytes.size();
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
