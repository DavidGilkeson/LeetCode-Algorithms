/* There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty. */

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length; // Find total length of the arrays
    
    
    if(total % 2 == 1) { // Check to see if the total array is an odd number
        
        return findKth(nums1, 0, nums2, 0, total / 2 + 1); // divide the total number by 2 and add 1.. This is the case number
    } else {
        
        return (findKth(nums1, 0, nums2, 0, total /2 ) + findKth(nums1, 0, nums2, 0, total / 2+ 1)) / 2.0; // Check if it is even and get the average
    }
}

private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
    
    if(start1 >= nums1.length) {
        
        return nums2[start2 + k - 1];
    }
       
    if(start2 >= nums2.length) {
        
        return nums1[start1 + k - 1];
    }
    
    if(k == 1) {
        
        return Math.min(nums1[start1], nums2[start2]);
    }
    int index1 = start1 + k / 2 - 1;
    int index2 = start2 + k / 2 - 1;
    int key1 = index1 < nums1.length ? nums1[index1] : Integer.MAX_VALUE;
    int key2 = index2 < nums2.length ? nums2[index2] : Integer.MAX_VALUE;
    
    if(key1 < key2) {
        
        return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    } else {
                return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);

        
    }
    
    
    
}
}