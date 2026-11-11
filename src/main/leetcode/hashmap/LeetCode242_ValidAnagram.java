package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode242_ValidAnagram {

    public static void main(String[] args) {
//        System.out.println(isAnagram1("anagram", "nagaram"));
        System.out.println(isAnagram1("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int j = 0; j < t.length(); j++) {
            if (map.containsKey(t.charAt(j))) {
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);

                if (map.get(t.charAt(j)) == 0) {
                    map.remove(t.charAt(j));
                }
            }
        }

        return map.isEmpty();
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static boolean isAnagram3 (String s, String t){

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // 1. s의 문자는 맵에 추가 (+1)
            map.put(charS, map.getOrDefault(charS, 0) + 1);
            if (map.get(charS) == 0) {
                map.remove(charS);
            }

            // 2. t의 문자는 맵에서 감소 (-1)
            map.put(charT, map.getOrDefault(charT, 0) - 1);
            if (map.get(charT) == 0) {
                map.remove(charT);
            }
        }

        // 아나그램이라면 +1과 -1이 모두 상쇄되어 맵이 완전히 비워짐
        return map.isEmpty();
    }
}
