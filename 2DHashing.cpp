#include <iostream>
#include <vector>

using namespace std;


class hash2D{
    
    int BucketSize;
  vector<vector<int>> bucket;
  
  public:
  hash2D(int buck){
      this->BucketSize=buck;
      bucket.resize(this->BucketSize);
  };
  
  void insert(int valuex){
      int key=valuex%this->BucketSize;
      bucket[key].push_back(valuex);
  };
  
  
  bool search(int valuex){
      int key=valuex%this->BucketSize;
      int inside=0;
      for(int val:bucket[key]){
          if(val==valuex){
              cout<<"inside"<<inside<<endl;
              return true;
          }
          else{
              inside++;
          };
      };
      cout<<"notFound"<<endl;
      return false;
  };
  int deleteNode(int valuex){
      int key=valuex%this->BucketSize;
      int inside=0;
      for(int val :bucket[key]){
          if(val==valuex){
              bucket[key].erase(bucket[key].begin()+inside);
              cout<<"inside"<<inside<<endl;
              return 1;
          }
          else{
              inside++;
      }
  }
  return -1;
};

};

int main() {
hash2D h1(5);
h1.insert(5);
h1.insert(10);
h1.insert(15);
h1.insert(20);
cout<<h1.search(20)<<endl;
cout<<h1.search(5)<<endl;
cout<<h1.deleteNode(5)<<endl;
cout<<h1.search(5)<<endl;
    return 0;
};