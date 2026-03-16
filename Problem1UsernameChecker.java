import java.util.*;

public class Problem1UsernameChecker {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public static String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for (String key : attempts.keySet()) {
            if (attempts.get(key) > max) {
                max = attempts.get(key);
                maxUser = key;
            }
        }

        return maxUser;
    }

    public static void main(String[] args) {

        users.put("john_doe", 101);
        users.put("admin", 102);

        String username = "john_doe";

        if (checkAvailability(username)) {
            System.out.println(username + " is available");
        } else {
            System.out.println(username + " is taken");
            System.out.println("Suggestions: " + suggestAlternatives(username));
        }

        System.out.println("Most attempted username: " + getMostAttempted());
    }
}