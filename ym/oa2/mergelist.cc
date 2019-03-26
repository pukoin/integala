class Solution {
public:
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    ListNode * mergeTwoLists(ListNode * l1, ListNode * l2) {
        // write your code here
        ListNode *dummy = new ListNode(0);
        ListNode *tmp = dummy;
        
        while (l1 != NULL && l2 != NULL) {
            if (l1->val < l2->val) {
                tmp->next = l1;
                l1 = l1->next;
            }
            else {
                tmp->next = l2;
                l2 = l2->next;
            
            }
            tmp = tmp->next;
        }
        
        if (l1 != NULL) tmp->next = l1;
        else 
            tmp->next = l2;
        
        return dummy->next;
    }
};