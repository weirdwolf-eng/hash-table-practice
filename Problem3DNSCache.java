import java.util.*;

class DNSEntry {
    String ipAddress;
    long expiryTime;

    DNSEntry(String ipAddress, int ttlSeconds) {
        this.ipAddress = ipAddress;
        this.expiryTime = System.currentTimeMillis() + ttlSeconds * 1000;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

public class Problem3DNSCache {

    static HashMap<String, DNSEntry> cache = new HashMap<>();

    public static String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (!entry.isExpired()) {
                System.out.println("Cache HIT");
                return entry.ipAddress;
            } else {
                cache.remove(domain);
                System.out.println("Cache EXPIRED");
            }
        }

        String ip = queryUpstreamDNS(domain);
        cache.put(domain, new DNSEntry(ip, 5));

        System.out.println("Cache MISS");
        return ip;
    }

    public static String queryUpstreamDNS(String domain) {
        return "192.168.1." + new Random().nextInt(255);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(resolve("google.com"));
        Thread.sleep(2000);

        System.out.println(resolve("google.com"));
        Thread.sleep(6000);

        System.out.println(resolve("google.com"));
    }
}
