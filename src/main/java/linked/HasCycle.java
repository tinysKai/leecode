package linked;

/**
 * 判断链表是否有环
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * 一般解法 : 声明set来判重
 * 经典解法 : 快慢指针
 */
public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head ,fast = head.next;                   //快,慢指针,fast指针声明为head.next可以快一个节点遍历完

        while (fast != null && fast.next != null){
            slow = slow.next;                               //针对slow指针每次走一个节点
            fast = fast.next.next;                          //针对fast指针每次走两个节点

            if (slow == fast){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //无环链表
        System.out.println(hasCycle(ListNodeUtil.init()));

        //有环链表
        System.out.println(hasCycle(ListNodeUtil.initCycle()));
    }
}
