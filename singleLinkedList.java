class singleLinkedList<t>{
    static class  Node<t>{
        t value;
        Node<t> next;
        
        
        Node(t val,Node<t> next){
            this.value=val;
            this.next=next;
        }

    };


    //head
    private Node<t> head;
    private int size;
    //constructor 
    singleLinkedList(){
       this.head=new Node<>(null,null);
       this.size=0;

    }
    //insert at first position
    public void insertFirst(t val){
        Node<t> temp=new Node<>(val, head.next);
        head.next=temp;
        this.size++;

    }
    //reverse of the linked list 
    public void reverse(){
         Node<t> prev=null;
         Node<t> curr=head.next;
         while(curr!=null){
            Node<t> next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
         }
         head.next=prev;
   }




    //check contains the value or not
    public boolean contains(t val){
        for(Node<t> current=this.head.next;current!=null;current=current.next){
            if(current.value.equals(val)){
                return true;
            }
        }

        return false;

    }
    //size of the linked list 
    public int size(){
        return this.size;
    }

    //printing the whole linkedlist
    public void printList(){
        for(Node<t> curr=head.next;curr!=null;curr=curr.next){
            System.out.print(curr.value+" ");

        }
    }




};



class Main{
    public static void main(String[] args){
    // try for integers 
    singleLinkedList<Integer> s1=new singleLinkedList<>();
    s1.insertFirst(6);
    s1.insertFirst(5);
    System.out.println(s1.contains(7));
    System.out.println(s1.contains(8));
    System.out.println(s1.contains(5));

    //try with String
    System.out.println("__ STRING __");
    singleLinkedList<String> s2=new singleLinkedList<>();
    s2.insertFirst("Generic");
    s2.insertFirst("Natu");
    System.out.println(s2.contains("film"));
    System.out.println(s2.contains("Generic"));
    System.out.println("__ SIZE __");
    System.out.println(s2.size());
    System.out.println(s1.size());

    System.out.println("__REVERSE_CHECK__");
    s2.printList();
    s2.reverse();
    System.out.println();
    s2.printList();
    


    }
}

