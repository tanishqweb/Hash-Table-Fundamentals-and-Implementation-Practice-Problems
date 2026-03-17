import java.util.*;

public class Q1 {
    private static HashMap<String, String> userRegistry = new HashMap<>();
    private static HashMap<String, Integer> attemptFrequency = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);
        return !userRegistry.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        return Arrays.asList(username + "1", username + "2", username.replace("_", "."));
    }

    public static void main(String[] args) {
        userRegistry.put("john_doe", "USR101");

        System.out.println("Availability of 'jane_smith': " + checkAvailability("jane_smith")); // true
        System.out.println("Availability of 'john_doe': " + checkAvailability("john_doe"));   // false
        System.out.println("Suggestions for 'john_doe': " + suggestAlternatives("john_doe"));
    }
}