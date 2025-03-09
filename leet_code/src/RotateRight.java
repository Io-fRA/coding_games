public class RotateRight {


        public static void main(String[] args) {
            String s1 = "hello";
            String s2 = "hello";
            System.out.println(s1 == s2);
        }
    


    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k if it's larger than the length of the list
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Find the new head and new tail
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        tail.next = head;

        return newHead;
    }
}
