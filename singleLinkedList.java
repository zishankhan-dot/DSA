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
    private Node<t> tail;
    private int size;
    //constructor 
    singleLinkedList(){
       this.head=new Node<>(null,null);
       this.tail=this.head.next;
       this.size=0;

    }
    //insert at first position
    public void insertFirst(t val){
        Node<t> temp=new Node<>(val, head.next);
        if(head.next==null){
            tail=temp;
        }
        head.next=temp;
        this.size++;

    }
    //insert from last;
    public void insertEnd(t val){
        if(tail==null){
            Node<t> curr=new Node<>(val,tail);
            head.next=curr;
            tail=curr;
            this.size++;
            return;
        }
        else{
        Node<t> curr=tail;
        Node<t> temp=new Node<>(val,curr.next);
        curr.next=temp;
        tail=temp;
        this.size++;
        return;
        }

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

//check and return the index of the value in the linked list (iterative)
public int getIndex(t val){
    int index=1;
    for(Node<t> curr=head.next;curr!=null;curr=curr.next){
        if(curr.value.equals(val)){
            return index;
        }
        ++index;
    }
    return -1;
}

//check and return index of the value in linked list (recursive)
public int getIndexRecursive(t val){
   return  getIndexR(val,this.head.next,1);
}
private int getIndexR(t val,Node<t> head,int index){
if(head==null){
    return -1;
}
else if(head.value.equals(val)){
    return index;
}
return getIndexR(val, head=head.next, ++index);
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
        System.out.println();
    }

    //printing the whole list using recursive approach 
    public void printRecursive(){
        recursiveRecursion(this.head.next);
    }

    private void recursiveRecursion(Node<t> head){
        if(head==null){
            System.out.println();
            return ;
        }
        System.out.print(head.value+" ");
        recursiveRecursion(head.next);
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
    s2.printList();
    System.out.println("RECURSIVE PRINT --");
    s2.printRecursive();
    System.out.println("REVERSE AGAIN --");
    s2.printList();
    
    //get index 
    System.out.println(s2.getIndex("Natu"));
    System.out.println(s1.getIndex(7));
    System.out.println(s1.getIndex(5));
    System.out.println(s1.getIndex(6));
    System.out.println("__RECURSIVE APPROACH__");
    System.out.println(s1.getIndexRecursive(5));
    System.out.println(s1.getIndexRecursive(6));
    System.out.println(s1.getIndexRecursive(7));



    }
}

