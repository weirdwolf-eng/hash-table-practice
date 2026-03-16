import java.util.*;

public class Problem4PlagiarismDetection {

    static HashMap<String, Set<String>> index = new HashMap<>();

    public static void indexDocument(String docId, String text, int n) {

        String[] words = text.split(" ");

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder ngram = new StringBuilder();

            for (int j = i; j < i + n; j++) {
                ngram.append(words[j]).append(" ");
            }

            String key = ngram.toString().trim();

            index.putIfAbsent(key, new HashSet<>());
            index.get(key).add(docId);
        }
    }

    public static void checkDocument(String docId, String text, int n) {

        String[] words = text.split(" ");
        HashMap<String, Integer> matches = new HashMap<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder ngram = new StringBuilder();

            for (int j = i; j < i + n; j++) {
                ngram.append(words[j]).append(" ");
            }

            String key = ngram.toString().trim();

            if (index.containsKey(key)) {
                for (String doc : index.get(key)) {
                    matches.put(doc, matches.getOrDefault(doc, 0) + 1);
                }
            }
        }

        System.out.println("Similarity with existing documents:");

        for (String doc : matches.keySet()) {
            System.out.println(doc + " → " + matches.get(doc) + " matching n-grams");
        }
    }

    public static void main(String[] args) {

        String doc1 = "machine learning is fun and powerful";
        String doc2 = "learning is fun when machine learning works";
        String doc3 = "data structures and algorithms are important";

        indexDocument("doc1", doc1, 3);
        indexDocument("doc2", doc2, 3);

        checkDocument("doc3", doc3, 3);
    }
}
