import java.util.*;

public class Q3 {
    static class DNSEntry {
        String ip;
        long expiryTime;

        DNSEntry(String ip, int ttlSeconds) {
            this.ip = ip;
            this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000L); [cite: 75]
        }
    }

    private static Map<String, DNSEntry> cache = new HashMap<>(); [cite: 76]

    public static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);
            if (System.currentTimeMillis() < entry.expiryTime) { [cite: 63]
                System.out.print("Cache HIT: ");
                return entry.ip;
            }
            cache.remove(domain); // Expired [cite: 64]
        }
        // Simulate upstream query [cite: 65]
        String ip = "172.217.14.206";
        cache.put(domain, new DNSEntry(ip, 300));
        System.out.print("Cache MISS/EXPIRED (Upstream): ");
        return ip;
    }

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com")); // Second call is a HIT
    }
}