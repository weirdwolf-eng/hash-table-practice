import java.util.*;

public class Problem7AutocompleteSystem {

    static HashMap<String, Integer> queryFrequency = new HashMap<>();

    public static void addQuery(String query) {
        queryFrequency.put(query, queryFrequency.getOrDefault(query, 0) + 1);
    }

    public static List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String query : queryFrequency.keySet()) {
            if (query.startsWith(prefix)) {
                results.add(query);
            }
        }

        results.sort((a, b) -> queryFrequency.get(b) - queryFrequency.get(a));

        if (results.size() > 5) {
            return results.subList(0, 5);
        }

        return results;
    }

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("java tutorial");
        addQuery("java download");
        addQuery("javascript basics");
        addQuery("java streams");

        List<String> suggestions = search("jav");

        System.out.println("Suggestions:");
        for (String s : suggestions) {
            System.out.println(s);
        }
    }
}
