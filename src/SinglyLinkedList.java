public class SinglyLinkedList {

    private SLLNode head,tail;
    private int size=0;

    
    public int getSize() {
        return size;
    }

    public void insertAtFirst(int val){      
        
        if(head==null && tail==null){
            SLLNode temp= new SLLNode(val);
            head=tail=temp;
        }
        else{

            SLLNode temp= new SLLNode(val,head);
            head=temp;
        }
        size++;

    }

    public void insertAtEnd(int val){

        if(head==null && tail==null){
            insertAtFirst(val);
            return;
        }

        SLLNode temp= new SLLNode(val);
        tail.setNext(temp);
        tail=temp;
        size++;

    }

    public void insertAtPosition(int pos,int val){

        if(pos<=0 || pos> size+1){
            System.out.println("Invalid Position!!");
        }
        else if(pos==1){
            insertAtFirst(val);
        }
        else if(pos==size+1){
            insertAtEnd(val);
        }
        else{
            SLLNode temp=head;

            while(pos-2>0){
                temp=temp.getNext();
                pos--;
            }

            SLLNode newNode= new SLLNode(val,temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }

    public int deleteFirst(){

        if(size==0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }
        int val= head.getVal();
        head=head.getNext();

        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }

        SLLNode temp=head;

        for (int i = 0; i < size-2; i++) {
            temp=temp.getNext();           
        }

        int val=tail.getVal();
        temp.setNext(null);
        tail=temp;
        size--;
        return val;
    }

    public int deleteFromPosition(int pos){

        if(pos<=0 || pos>size){
            System.out.println("Invalid Position");
            return Integer.MIN_VALUE;
        }

        if (pos==1) return deleteFirst();

        if(pos==size)return deleteLast();

        SLLNode temp=head;

        for (int i = 0; i < pos-2; i++) {
            temp=temp.getNext();
        }

        int val=temp.getNext().getVal();
        temp.setNext(temp.getNext().getNext());
        size--;

        return val;
    }

    public boolean isPresent(int val){
        SLLNode temp=head;
        while(temp!=null){
            if(temp.getVal()==val) return true;
            temp=temp.getNext();
        }
        return false;
    }
    
    public void displayLL(){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        SLLNode temp=head;

        while (temp!=null) {
            System.out.print(temp.getVal()+" --> ");
            temp=temp.getNext();
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        SinglyLinkedList l= new SinglyLinkedList();
        l.insertAtFirst(20);
        l.insertAtEnd(10);
        // l.insertAtEnd(30);
        // l.insertAtFirst(60);
        l.insertAtPosition(3, 23);
        l.displayLL();
        System.out.println(l.getSize());
        // l.deleteFromPosition(1);
        // l.displayLL();
        // System.out.println(l.getSize());
        // System.out.println(l.isPresent(10));
    }

}

class SLLNode extends Node{

    private SLLNode next;

    SLLNode getNext() {
        return next;
    }

    void setNext(SLLNode next) {
        this.next = next;
    }

    SLLNode(int val){
        setVal(val);
    }

    SLLNode(int val,SLLNode next){
        setVal(val);
        setNext(next);
    }
}
