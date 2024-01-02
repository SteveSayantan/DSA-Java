public class DoublyLinkedList {

    private DLLNode head,tail;
    private int size=0;

    public int getSize() {
        return size;
    }

    public void insertAtFirst(int val){
        
        if(size==0){
            DLLNode temp= new DLLNode(val);
            head=tail=temp;
        }
        else{

            DLLNode temp= new DLLNode(null,val,head);
            head.setPrev(temp);
            head=temp;
        }
        size++;

    }

    public void insertAtPosition(int pos,int val){

        if(pos>size+1 || pos <=0){
            System.out.println("Invalid Position");
            return;
        }
        if(pos==1){
            insertAtFirst(val);
            return;
        }
        
        if(pos==size){
            DLLNode newNode= new DLLNode(tail.getPrev(),val,tail);
            tail.getPrev().setNext(newNode);
            tail.setPrev(newNode);
            size++;
            return;
        }

        if(pos==size+1){
            insertAtLast(val);
            return;
        }

        DLLNode temp=head;

        for (int i = 0; i < pos-1; i++) {
            temp=temp.getNext();
        }

        DLLNode newNode= new DLLNode(temp.getPrev(),val,temp);
        temp.getPrev().setNext(newNode);
        temp.setPrev(newNode);
        size++;


    }

    public void insertAtLast(int val){
        if(size==0){
            insertAtFirst(val);
            return;
        }

        DLLNode temp= new DLLNode(tail, val, null);
        tail.setNext(temp);
        tail=temp;
        size++;
    }

    public int deleteFirst(){

        if(size==0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }

        int res=head.getVal();

        head=head.getNext();

        head.setPrev(null);

        size--;

        return res;
    }

    public int deleteLast(){

        if(size<=1) return deleteFirst();

        int val=tail.getVal();

        tail=tail.getPrev();
        tail.setNext(null);

        size--;
        return val;
    }

    public int deleteFromPosition(int pos){

        if(pos>size || pos<=0){
            System.out.println("Invalid Position");
            return Integer.MIN_VALUE;
        }

        if(pos==1) return deleteFirst();

        if(pos==size) return deleteLast();

        DLLNode temp= head;

        for (int i = 0; i < pos-1; i++) {
            temp=temp.getNext();
        }
        int val= temp.getVal();
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());

        size--;
        return val;
    }

    public void displayLL(){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        DLLNode temp=head;

        while (temp!=null) {
            System.out.print(temp.getVal()+" <- -> ");
            temp=temp.getNext();
        }
        System.out.println("END");
    }

    public void displayLLInReverse(){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        DLLNode temp=tail;
        while(temp!=null){
            System.out.print(temp.getVal()+" <- -> ");
            temp=temp.getPrev();
        }

        System.out.println("START");
    }

    public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        list.insertAtFirst(25);
        list.insertAtFirst(10);
        list.insertAtFirst(78);
        list.insertAtLast(45);
        list.insertAtLast(67);
        list.displayLL();
        System.out.printf("%d deleted successfully%n",list.deleteFirst());
        list.insertAtPosition(5,23);
        System.out.printf("%d deleted successfully%n",list.deleteLast());
        System.out.printf("%d deleted successfully%n",list.deleteFromPosition(2));
        list.displayLL();
        System.out.println(list.getSize());
        list.displayLLInReverse();
    }
    
}

class DLLNode extends Node{

    private DLLNode prev;
    private DLLNode next;

    DLLNode(int val){
        setVal(val);
    }

    DLLNode(DLLNode prev,int val,DLLNode next){
        this(val);
        setPrev(prev);
        setNext(next);
    }

    DLLNode getPrev(){
        return prev;
    }

    void setPrev(DLLNode prev){
        this.prev=prev;
    }
    DLLNode getNext(){
        return next;
    }

    void setNext(DLLNode next){
        this.next=next;
    }

}
