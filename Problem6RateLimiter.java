import java.util.*;

public class Problem6RateLimiter {

    static HashMap<String, Integer> requestCount = new HashMap<>();
    static int LIMIT = 5;

    public static boolean checkRateLimit(String clientId) {

        int count = requestCount.getOrDefault(clientId, 0);

        if (count >= LIMIT) {
            return false;
        }

        requestCount.put(clientId, count + 1);
        return true;
    }

    public static void main(String[] args) {

        String client = "clientA";

        for (int i = 1; i <= 7; i++) {

            if (checkRateLimit(client)) {
                System.out.println("Request " + i + " allowed");
            } else {
                System.out.println("Request " + i + " denied (rate limit exceeded)");
            }
        }
    }
}