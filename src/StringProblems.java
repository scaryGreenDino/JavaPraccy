import java.io.PrintStream;
import java.util.Scanner;



public class StringProblems {
    PrintStream Out = System.out;
    Scanner In = new Scanner(System.in);

    public StringProblems(String[] args) throws Exception {
        Out.println("Enter Q at anytime to quit.");
        String prompt = "Enter 1 for Arrays and Strings:";
        Out.print(prompt);
        String input = In.nextLine();
        while (input != "Q") {
            Out.println(prompt);
            switch (input) {
                case "1":
                    arraysAndStrings();
                    break;
            
                default:
                    break;
            }
        }
    }
    
    void arraysAndStrings() {
        String prompt = "isUnique : 1\n checkPermutation : 2\n palindromePermutation : 3";
        Out.println(prompt);
        String input = In.nextLine();
        while (input != "q") {
            switch (input) {
                case "1":
                    Out.println("Determines if a string has all unique characters\nEnter a string:");
                    String s = In.nextLine();
                    Out.println(isUnique(s));
                    break;
                case "2":
                    Out.println("Decides if one is a permutation of the other.\nString 1:");
                    String permOne = In.nextLine();
                    Out.println("String 2:");
                    String permTwo = In.nextLine();
                    Out.println(checkPermutation(permOne, permTwo));
                    break;
                case "3":
                    Out.println("Determines if a string is the permutation of a palindrome\nEnter a string:");
                    String pp = In.nextLine();
                    Out.println(palindromePermutation(pp));
                    break;

                default:
                    break;
            }
            Out.println(prompt);
            input = In.nextLine();
        }
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
