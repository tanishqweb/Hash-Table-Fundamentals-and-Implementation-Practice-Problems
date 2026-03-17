import java.util.*;

public class Q2 {
    private static Map<String, Integer> inventory = new HashMap<>();
    private static LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public static void purchaseItem(String productId, int userId) {
        synchronized(inventory) {
            int stock = inventory.getOrDefault(productId, 0);
            if (stock > 0) {
                inventory.put(productId, stock - 1);
                System.out.println("User " + userId + " purchased " + productId + ". Remaining: " + (stock - 1));
            } else {
                waitingList.put(userId, productId);
                System.out.println("User " + userId + " added to waiting list.");
            }
        }
    }

    public static void main(String[] args) {
        inventory.put("IPHONE15_256GB", 2);
        purchaseItem("IPHONE15_256GB", 12345);
        purchaseItem("IPHONE15_256GB", 67890);
        purchaseItem("IPHONE15_256GB", 99999);
    }
}