package linked;

/**
 * 描述: 寻找链表是否存在环,若存在则返回环的起始位置,不存在则返回null
 *
 * https://leetcode.com/problems/linked-list-cycle-ii
 *
 * 思路 :
 *         1.先利用快慢指针判断是否有环
 *         2.有环的话利用当快慢指针碰撞时,慢指针指向head,快指针以步调1开始往下走,则此时满足 :
 *              S慢 = 非环路径长 + 弧A长度
 *              S快 = 非环路径长 + N * 环长 + 弧A长度
 *
 *              而S快 = 2S慢,则非环部分长度=n*环的长度-弧A的长度
 *
 *              所以当S慢再走非环部分长度时,S快位于弧A,此时再加上(n*环的长度-弧A的长度),刚好走完一个环.结果两个指针会在环的起始位置相遇,
 *              返回此时的节点
 *
 * 2018-10-14
 */
public class FirstNodeOfCrcleInLinkded {
    public static  ListNode findBeginLoop(ListNode head){
        ListNode slow = head ,fast = head;                   //快,慢指针声明为head

        while (fast != null && fast.next != null){
            slow = slow.next;                               //针对slow指针每次走一个节点
            fast = fast.next.next;                          //针对fast指针每次走两个节点

            if (slow == fast){
                break;
            }

        }

        //判断无环时返回null
        if (fast == null || fast.next == null){
            return null;
        }

        //有环时按照上面的规则去迭代
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.print(findBeginLoop(ListNodeUtil.initCycle()));
    }
}
