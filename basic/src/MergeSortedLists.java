public class MergeSortedLists {

    // ListNode class for the singly linked list node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Method to merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merge logic
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Pointers for both lists
        ListNode p1 = l1;
        ListNode p2 = l2;

        // Compare elements of both lists and merge them
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        // If any elements are left in either list, append them
        if (p1 != null) {
            current.next = p1;
        } else if (p2 != null) {
            current.next = p2;
        }

        // Return the merged list (dummy.next is the head of the merged list)
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example lists: [1, 2, 4, 8, 10] and [1, 3, 4]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(8);
        l1.next.next.next.next = new ListNode(70);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoLists(l1, l2);

        System.out.print("Merged List: ");
        printList(mergedList);  // Output: 1 1 2 3 4 4
    }
}
