import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            int wordsMatched = 0;
            while (right + wordLen <= sLen) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    wordsMatched++;
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        wordsMatched--;
                        left += wordLen;
                    }
                    if (wordsMatched == numWords) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    wordsMatched = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
