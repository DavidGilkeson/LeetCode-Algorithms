/* You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, 
except the number 0 itself. */

/* **Linked List** 
A linked list is a linear data structure to store data.
Each node is linked to another node
It will have a place to store a value and another place to point to another node.

l1 [3][-]->[2][-]->[1][-]->null
l2 [7][-]->[6][-]->[5][-]->null
_____(carry 1)_________________
l3 [0][-]->[9][-]->[6][-]->null



*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; // This is to store the value in the LinkedList
 *     ListNode next; // This is to point to the next node
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // dummy node is used to link to the head of the result linked list
        ListNode l3 = dummy; // l3 is a pointer of the result linked list
        
        int carry = 0; // This is to store the carry over value
        
        while(l1 != null || l2 != null) {
            
            int l1_value = (l1 != null) ? l1.val : 0;
            int l2_value = (l2 != null) ? l2.val : 0;
            
            int currentSum = l1_value + l2_value + carry;
            
            carry = currentSum / 10; // Divide by 10 to get the carry  
            int lastDigit = currentSum % 10; 
            
            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;

        }
        
        
        if(carry > 0) {
            
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = l3.next;
        }
        return dummy.next;
    }
}