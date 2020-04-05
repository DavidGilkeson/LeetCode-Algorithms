// ZigZag Conversion

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R


 */
 
class Solution6 {
    public String convert(String s, int numRows) {
        
        int length = s.length(); // Get the length of the orinigal string
        
        if(numRows > length || numRows <= 1) {
            
            return s;
        }
        
        char[] zigZagChars = new char[length]; // Initialise array of characters
        int count = 0; // How many characters are being put into char array
        
        int interval = 2 * numRows - 2;
        
        for(int i = 0; i < numRows; i++) {
            
            int step = interval - 2 * i;
			
            for(int j = i; j < length; j += interval) {
                
                zigZagChars[count] = s.charAt(j);
                count++;
                if(step > 0 && step < interval && j + step < length) {
                    
                    zigZagChars[count] = s.charAt(j + step);
                    count++; // increase
                }
            }
        }
           return new String(zigZagChars);
    }
}



/* 
Alternative Solution

class Solution {
    public String convert(String s, int numRows) {
        
        Map<Integer,StringBuilder> map = new HashMap<>();
        
        int position = 0;
        boolean increment = true;
        for(char c: s.toCharArray()){
            
            if (position == numRows) {
                increment = false;
            } 
            if(position == 1  ) {
                increment = true;
            } 
            if(increment) {
                 position++;
            } else {
                     position--;  
                   }
            
            if(!map.containsKey(position))
                map.put(position, new StringBuilder());
            map.get(position).append(c);
                        
        }
        StringBuilder result = new StringBuilder();
        for(int i: map.keySet()) {
            
            result.append(map.get(i));
        }
        return result.toString();
    }
}
*/