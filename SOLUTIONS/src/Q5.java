import java.util.*;

public class Q5 {
    private static Map<String, Integer> pageViews = new HashMap<>();
    private static Map<String, Set<String>> uniqueVisitors = new HashMap<>();

    public static void processEvent(String url, String userId) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
        uniqueVisitors.computeIfAbsent(url, k -> new HashSet<>()).add(userId);
    }

    public static void getDashboard() {
        System.out.println("Top Pages Analytics:");
        pageViews.forEach((url, count) -> {
            int unique = uniqueVisitors.get(url).size();
            System.out.println(url + " - Views: " + count + " (Unique: " + unique + ")"); [cite: 146]
        });
    }

    public static void main(String[] args) {
        processEvent("/home", "user1");
        processEvent("/home", "user2");
        processEvent("/home", "user1");
        getDashboard();
    }
}