public class StringProblems {
    public static void main(String[] args) throws Exception {
        String[] strings = { "Helhkjhjksgdfhgkho", "abcdefghijklmno", "a", "bb", "games" };
        for (String string : strings) {
            // System.out.println(isUnique(string));
        }
        // System.out.println(checkPermutation("cat", "tac"));
        System.out.println(palindromePermutation("tat  "));
    }

    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     * Runs in O(min(128,N)) where N is the length of the string
     * @param s
     * @return
     */
    static boolean isUnique(String s) {
        boolean[] a = new boolean[128];
        for (char c : s.toCharArray()) {
            if (a[c]) {
                return false;
            } else {
                a[c] = true;
            }
        }
        return true;
    }

    /**
     * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
     * O(N+C) where N is the length of the longest string and c is 128
     * @param a
     * @param b
     * @return
     */
    static boolean checkPermutation(String a, String b) {
        int[] hashA = new int[128];

        if (a.length() != b.length()) {
            return false;
        }
        for (int c = 0; c < a.length(); c++) {
            hashA[a.charAt(c)]++;
            hashA[b.charAt(c)]++;
        }
        for (int c = 0; c < 128; c++) {
            if (hashA[c] != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean palindromePermutation(String s) {
        char[] ca = s.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        boolean[] hash = new boolean[26];
        //This assumes only lowercase letters are left otherwise i would use modulo to be more safe
        for (char c : ca) {
            hash[c-97] = !hash[c-97];
        }
        int c = 0;
        int strikes = 0;
        while (c < 26 && strikes < 2) {
            if (hash[c]) {
                strikes++;
            }
            c++;
        }
        return strikes < 2;
    }
}
