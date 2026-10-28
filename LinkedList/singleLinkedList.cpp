#include <iostream> 
using namespace std;

//forward declaration
template <typename Type>
class singlyLinkedList;
template <typename Type>
class Node{
    private:
    Type data;
    Node<Type> *next;
    friend class singlyLinkedList<Type>;
    public:
    Node(){
        this->data=Type();
        this->next=nullptr;

    }

    Node(Type data,Node *next=nullptr){
        this->data=data;
        this->next=next;
    };
};


template <typename Type>
class singlyLinkedList{
    private:
    Node<Type> *head;
    Node<Type> *tail;
    int count=0;

    public: 
    singlyLinkedList(){
     head=new Node<Type>();
     tail=head->next;
    }

   void  insertStart(Type val){
        Node<Type> *temp=new Node(val,head->next);
        head->next=temp;
        if(count==0){
            tail=temp;
        }
        ++count;
    }

    void Print(){
    if(count>0){
        for(auto* i=head->next;i!=nullptr;i=i->next){
            cout<<i->data<<" ";
        }
        cout<<endl;
    }
    }

    

    

};



int main(){
    //trail run
    singlyLinkedList<int> list;
    list.insertStart(10);
    list.insertStart(20);
    list.insertStart(30);
    list.Print();



    return 0;

}