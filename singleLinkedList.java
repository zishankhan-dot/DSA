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

    singleLinkedList(){
       this.head=new Node<>(null,null);
       this.size=0;

    }

    public void insertFirst(t val){
        Node<t> temp=new Node<>(val, head.next);
        head.next=temp;
        this.size++;

    }

    public boolean contains(t val){
        for(Node<t> current=this.head.next;current!=null;current=current.next){
            if(current.value.equals(val)){
                return true;
            }
        }

        return false;

    }

    public int size(){
        return this.size;
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

    }
}

