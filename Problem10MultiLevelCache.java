import java.util.*;

public class Problem10MultiLevelCache {

    static HashMap<String, String> L1 = new HashMap<>();
    static HashMap<String, String> L2 = new HashMap<>();
    static HashMap<String, String> L3 = new HashMap<>();

    public static String getVideo(String videoId) {

        if (L1.containsKey(videoId)) {
            System.out.println("L1 Cache HIT");
            return L1.get(videoId);
        }

        if (L2.containsKey(videoId)) {
            System.out.println("L2 Cache HIT → Promoting to L1");
            String data = L2.get(videoId);
            L1.put(videoId, data);
            return data;
        }

        if (L3.containsKey(videoId)) {
            System.out.println("L3 Database HIT → Promoting to L2");
            String data = L3.get(videoId);
            L2.put(videoId, data);
            return data;
        }

        System.out.println("Video not found");
        return null;
    }

    public static void main(String[] args) {

        L3.put("video1", "Movie Data 1");
        L3.put("video2", "Movie Data 2");

        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video1"));
        System.out.println(getVideo("video2"));
    }
}
