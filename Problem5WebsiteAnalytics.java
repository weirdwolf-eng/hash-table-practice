import java.util.*;

public class Problem5WebsiteAnalytics {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    static HashMap<String, Integer> trafficSources = new HashMap<>();

    public static void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source, trafficSources.getOrDefault(source, 0) + 1);
    }

    public static void getDashboard() {

        System.out.println("Top Pages:");

        for (String url : pageViews.keySet()) {
            int views = pageViews.get(url);
            int unique = uniqueVisitors.get(url).size();

            System.out.println(url + " → " + views + " views (" + unique + " unique)");
        }

        System.out.println("\nTraffic Sources:");

        for (String source : trafficSources.keySet()) {
            System.out.println(source + " → " + trafficSources.get(source));
        }
    }

    public static void main(String[] args) {

        processEvent("/article/breaking-news", "user1", "google");
        processEvent("/article/breaking-news", "user2", "facebook");
        processEvent("/sports/championship", "user3", "google");
        processEvent("/article/breaking-news", "user1", "direct");

        getDashboard();
    }
}