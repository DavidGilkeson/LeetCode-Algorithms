/*
Determine whether an integer is a palindrome. 
An integer is a palindrome when it reads the same backward as forward.
 */
 
 class Solution9 {
    public boolean isPalindrome(int x) {
        
      if(x < 0 || x != 0 && x % 10 == 0) { // - number
          
          return false;
      } 
        //Reverse 
        
        int reversed = 0; // 
        int original = x; // 123
        while(x != 0) {
            reversed = reversed * 10 + x % 10; //reversed = 3 * 10 * 10 + 2 * 10 + 1
           x = x / 10;  // 1 / 10 = 0
        }
            
            return reversed == original; // 321 == 123
    }
}