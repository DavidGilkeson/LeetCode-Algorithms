/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.
 */



class Solution5 {
    public String longestPalindrome(String s) {
        if( s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length();i++){ // Looping through the string letter by letter
        
            int length1 = expandFromMiddle(s, i, i);	// Checks from middle on odd string
            int length2 = expandFromMiddle(s, i, i+1); // Checks from middle on even string
            int length = Math.max(length1, length2); // Gets the max of the strings
        
        if(length > end - start) {
            
            start = i - ((length - 1) / 2 );
            end = i + (length / 2);
        }
        }
        return s.substring(start, end + 1); // +1 and -1 are for indexOutOfBounds
    }
    
    // Method that returns the length of the palindrome substring after it expands
    public int expandFromMiddle(String s, int left, int right) {
        
        // if the string is null or left is greater than right, then the string or boundaries are messed up.
        if(s == null || left > right )
            return 0; // No palindromic substring to return
        
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            
            left--; // left pointer checks left
            right++; // right pointer checks right
        }
        return right - left - 1;
    }
}



// Brute Force Time complexity - 0(n^3)