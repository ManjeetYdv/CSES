package AryanshiOT;

public class ques1 {
    public static int solution(int initialHealth, int[] deltas) {
        int currentHealth = initialHealth;
        for (int delta : deltas) {
            currentHealth += delta;
            if (currentHealth < 0) {
                currentHealth = 0;
            } else if (currentHealth > 100) {
                currentHealth = 100;
            }
        }
        return currentHealth;
    }

    public static void main(String[] args) {

    }
}
