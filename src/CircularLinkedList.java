public class CircularLinkedList {

    private CLLNode head,tail;
    private int size=0;

    public int getSize(){
        return size;
    }

    public void insertAtFirst(int val){

        CLLNode temp= new CLLNode(val,head);
        head=temp;
        if(size==0){
            tail=temp;
        }
        tail.setNext(head);
        size++;

    }

    public void insertAtLast(int val){

        if(size==0){
            insertAtFirst(val);
            return;
        }

        CLLNode temp= new CLLNode(val,head);
        tail.setNext(temp);
        tail=temp;
        size++;

    }

    public int delete(int val){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return Integer.MIN_VALUE;
        }
        
        if(size==1){
            int temp = head.getVal();
            head=tail=null;
            size--;
            return temp;
        }

        CLLNode temp=head;


        do{
            if(temp.getNext().getVal()==val){

                CLLNode toBeDeleted=temp.getNext();
                temp.setNext(toBeDeleted.getNext());

                if(toBeDeleted==head) head=toBeDeleted.getNext();
                if(toBeDeleted==tail) tail=temp;
                
                size--;
                return toBeDeleted.getVal();
            }
            temp=temp.getNext();
        }
        while(temp!=head);
        System.out.println("Value not found !!");
        return Integer.MIN_VALUE;
    }
    public void displayLL(){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        
        CLLNode temp=head;


        do{
            System.out.print("-> "+temp.getVal()+" -");
            temp=temp.getNext();
        }
        while(temp!=head);

        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list= new CircularLinkedList();
        list.insertAtFirst(34);
        list.insertAtFirst(51);
        list.insertAtLast(67);
        list.delete(51);
        list.delete(34);
        list.displayLL();
    }
}

class CLLNode extends Node{
    private CLLNode next;

    CLLNode(int val){
        setVal(val);
    }
    CLLNode(int val,CLLNode next){
        this(val);
        setNext(next);
    }
    CLLNode getNext(){
        return next;
    }
    void setNext(CLLNode next){
        this.next=next;
    }
}
