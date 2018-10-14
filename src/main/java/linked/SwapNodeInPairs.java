package linked;

/**
 *  两两交换链表中的节点
    https://leetcode.com/problems/swap-nodes-in-pairs/

    Example:
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    思路 :
            1.遍历节点,需保存一个迭代指针,迭代是以步数为2的长度
            2.声明一个虚设的节点,其下一个节点指向head
            3.
                I.第一个节点的next指向第二个节点的next节点
                II.current节点的下个节点指向第二个节点
                III.current节点的下下个节点指向第一个节点
            4.更新迭代指针为下下个节点
 */
public class SwapNodeInPairs {
    public static ListNode swap(ListNode head){
        ListNode dummy  = new ListNode(0);
        dummy.next = head;                                       //增加多一个起始节点,并声明其后继节点为head
        ListNode current = dummy;                                //迭代指针
        while (current.next != null && current.next.next != null){        //判断连续有两个后继节点
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

           firstNode.next = secondNode.next;                    //声明第一个节点指向第三个节点
           current.next = secondNode;                           //交换位置
           current.next.next = firstNode;


            current = current.next.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.traversing(swap(ListNodeUtil.init()));
    }
}
