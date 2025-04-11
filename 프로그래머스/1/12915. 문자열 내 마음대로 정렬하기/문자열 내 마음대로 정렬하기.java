import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> (a.charAt(n) - b.charAt(n)) != 0 ? (a.charAt(n) - b.charAt(n)) : a.compareTo(b));
        return strings;
    }
}