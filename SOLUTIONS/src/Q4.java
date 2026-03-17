import java.util.*;

public class Q4 {
    // n-gram -> Set of Document IDs [cite: 105]
    private static Map<String, Set<String>> ngramMap = new HashMap<>();

    public static void indexDocument(String docId, String content) {
        String[] words = content.split(" ");
        int n = 3; // 3-gram example [cite: 106]
        for (int i = 0; i <= words.length - n; i++) {
            String ngram = String.join(" ", Arrays.copyOfRange(words, i, i + n)); [cite: 95]
            ngramMap.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
        }
    }

    public static void checkPlagiarism(String docId, String content) {
        String[] words = content.split(" ");
        int n = 3;
        int matches = 0;
        int totalNgrams = 0;

        for (int i = 0; i <= words.length - n; i++) {
            String ngram = String.join(" ", Arrays.copyOfRange(words, i, i + n));
            if (ngramMap.containsKey(ngram)) matches++; [cite: 108]
            totalNgrams++;
        }
        double similarity = (double) matches / totalNgrams * 100; [cite: 96]
        System.out.println("Similarity for " + docId + ": " + similarity + "%");
    }

    public static void main(String[] args) {
        indexDocument("essay_001", "the quick brown fox jumps over the dog");
        checkPlagiarism("student_test", "the quick brown fox leaps over dog");
    }
}