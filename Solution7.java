/* Given a 32-bit signed integer, 
reverse digits of an integer. */

class Solution7 {
    public int reverse(int x) {
        
        int reversed = 0;
        int pop;
        
        while(x != 0) {
            
            int temp = reversed * 10 + x % 10;
            if(temp / 10 != reversed) {
                return 0;
            }
          reversed = temp;
            x /= 10;
            
           
        }
        return reversed;
    }
} 