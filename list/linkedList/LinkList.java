package list.linkedList;

//线性链表
//特点：增删快，查询慢
public class LinkList {
    //头节点
    public Node head;
    //尾节点
    public Node last;
    //链表实际长度
    public int size;

    /**
     * 链表插入元素
     * @param data
     * @param index
     */
    public void insert(int data,int index){
        if (index <0 || index >size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node inNode = new Node(data);
        if (size == 0){
            //空链表
            head = inNode;
            last = inNode;
        }else if (index == 0){
            //插入头部
            inNode.next = head;
            head = inNode;
        }else if(index == size){
            //插入尾部
            last.next = inNode;
            last = inNode;
        }else {
            //插入中间
            Node preNode = get(index - 1);
            inNode.next = preNode.next;
            preNode.next = inNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index
     * @return
     */
    public Node remove(int index){
        if (index <0 || index>=size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode = null;
        if (index == 0){
            //删除头节点
            removeNode = head;
            head = head.next;
        }else if (index == size-1){
            //删除尾节点
            Node preNode = get(index-1);
            removeNode = preNode.next;
            preNode.next = null;
            last = preNode;
        }else{
            //删除中间节点
            Node preNode = get(index-1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
        }
        size --;
        return removeNode;
    }

    /**
     * 链表查找元素
     * @param index
     * @return
     */
    public Node get(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
