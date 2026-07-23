// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>
using namespace std;


class linkedlist{
    public:
    int value;
    linkedlist* next=NULL;
    
    
    //constructor to take val and next pointer address
    linkedlist( int value,linkedlist* next){
        this->value=value;
        this->next=next;
    }
    
    //constructor to take value 
    linkedlist(int value){
        this->value=value;
        this->next=NULL;
    }
    
    
};



class hashing {
    public:
    int BucketSize;
    vector<linkedlist *> l1;
    
    //constructor 
    hashing(int bucketSize){
    this->BucketSize=bucketSize;
    l1.resize(bucketSize,nullptr);
    }
    
    //insert operation will create new Linkedlist as a pointer
    // and that pointer will point to what head was pointing to 
    // and head will point to this new Linkedlist node now
    // head is just type linkedlist* which is default as nullptr
   void insert(int value){
        int key=value%this->BucketSize;
        linkedlist* node=new linkedlist(value,l1[key]);
        
        l1[key]=node;
        cout<<"added node"<<l1[key]<<endl;
        cout<<(*l1[key]).value<<endl;
        
    };
    
  bool search(int valuex){
      int key=valuex%this->BucketSize;
     linkedlist* node=l1[key];
     int inside=0;
      while(node){
          if(node->value==valuex){
              cout<<"inside: "<<inside<<endl;
              return true;
          }
        else{
            node=node->next;
            inside++;
        }
      }
      
      return false;
  };
  
  int deleteNode(int valuex){
      int key=valuex%this->BucketSize;
      bool found=false;
      linkedlist* node=l1[key];
      linkedlist* prenode=nullptr;
     // linkedlist* nextnode=nullptr;
      while(node){
          
          
          if(node->value==valuex){
              if(prenode==nullptr){
                  linkedlist* temp=l1[key];
                  l1[key]=node->next;
                  found=true;
                  delete temp;
                  break;
              }
              found=true;
              prenode->next=node->next;
              delete node;
                break;
          }
          else{
              prenode=node;
              node=node->next;
          }
      }
      
      if(found){
          return 1;
      }
    return -1;
  }
    
    
    
    
};

int main() {
hashing h1(5);
h1.insert(5);
h1.insert(10);
h1.insert(15);
h1.insert(20);
cout<<h1.search(20)<<endl;
cout<<h1.search(5)<<endl;
cout<<h1.deleteNode(5)<<endl;
cout<<h1.search(5)<<endl;
    return 0;
}