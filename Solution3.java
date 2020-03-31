//Find the length of the string that does not have repeating characters

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0; // Pointer 1 stays at the beginning 
        int j = 0; // Pointer 2 is going to go out and make sure the characters are distinct 
        int max = 0; // This is for max length of the substring
        // Hash set is the best for this problem as it tracks new things
        HashSet<Character> hash_set = new HashSet();
        
        while (j < s.length()) {
            
            if(!hash_set.contains(s.charAt(j))) { // If the hash set does not contain j
                hash_set.add(s.charAt(j));			// Then we are going to add the character
                j++; // Update j
                max = Math.max(hash_set.size(), max); /* Update the maximum each iteration when we find a new unique character with 
														 the hash_set size as that is the size of the unique characters*/
            } else {
                
                hash_set.remove(s.charAt(i)); // Then remove the character stored at i which is at the beginning
                i++; // Going to move i pointer to the right
            }
                
            }
        return max; // Return max length
        }
    }
	
	/*One pointer is going to stay at the beginning and the other is 
	going to expand the window checking if the character is new or not
	
	The max then keeps count of what is the biggest substring
	
	It works like a sliding window
	*/