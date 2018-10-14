package linked;

/**
 * Created by asus on 2018/10/14.
 */
public class ListNodeUtil {
    /**
     * 声明一个1到5的链表
     */
    public  static  ListNode init(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    public static ListNode initCycle(){
        //有环链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        return node1;
    }

    public static void traversing(ListNode node){
        while(node != null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        traversing(init());
    }
}
