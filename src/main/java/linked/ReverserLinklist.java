package linked;

/**
 * 反转链表
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 *  反转链表的关键在于将当期节点的后继节点指向当前节点
 *  思路 :
 *      1.遍历链表,所以需保存一个遍历指针
 *      2.需保存上个节点的指针,用来在遍历时指向
 *
 *  Input:  1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
 */
public class ReverserLinklist {
    /**
     * 反转链表
     */
    public static  ListNode reverseList(ListNode head) {
          ListNode pre = null;                   //先声明第一个前指针为null
          ListNode current = head;               //声明遍历指针
          while (current != null){
              ListNode temp = current.next;      //先保存当前遍历指针的下一个next节点用来遍历
              current.next = pre;                //修改后继节点为当前节点的前一个
              pre = current;                     //保存前节点
              current = temp;                   //遍历指针迭代为下一个元素
          }

        return pre;
    }

    public static void main(String[] args) {
        ListNodeUtil.traversing(reverseList(ListNodeUtil.init()));
    }

}


