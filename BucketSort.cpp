#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class sort{
public: 
static void bucketSort(vector<int> &arr){
    if(arr.size()<=1){
        return;
    }
    int bucketSize=arr.size()/10;
    if(bucketSize<1){
        bucketSize=1;
    }
    BucketSort(arr, bucketSize);
}

private: 
static void BucketSort(vector<int> &arr, int bucketSize){
// 1. create bucket and set buckets 
vector<vector<int>> bucket(bucketSize);
int min=*min_element(arr.begin(), arr.end());
int max=*max_element(arr.begin(),arr.end());
int range=max-min;





for (int i =0;i<arr.size();i++){
int index=0;
    if(range>0){
    index=(arr[i]-min)*(bucketSize-1)/range;}
    else{
    index=0;
    }
    bucket[index].push_back(arr[i]);
}

//2 sort using insertion sort
for (int i =0;i<bucketSize;i++){
    insertionSort(bucket[i]);
}


//3. put it back to original array 
int index=0;
for (int i=0;i<bucketSize;i++){
    for(int j =0;j<bucket[i].size();j++){
        arr[index++]=bucket[i][j];
    }
}

}


static void insertionSort(vector<int> &arr){
for(int i =1;i<arr.size();i++){
    
        int j=i;
        int temp=arr[i];
        while(j>0 && arr[j-1]>temp){
            arr[j]=arr[j-1];
            j--;
        }
        arr[j]=temp;
}
}







};



int main (){
    // Structure to hold our test scenarios
    struct TestCase {
        string description;
        vector<int> data;
    };

    vector<TestCase> testCases = {
        { "Standard Uniform Distribution", {45, 12, 89, 23, 67, 34, 55, 78, 91, 10} },
        { "Already Sorted Array",          {10, 20, 30, 40, 50, 60, 70, 80, 90, 100} },
        { "Reverse Sorted Array",          {100, 90, 80, 70, 60, 50, 40, 30, 20, 10} },
        { "All Identical Elements",        {7, 7, 7, 7, 7, 7, 7, 7} },          
        { "Small Array (< 10 elements)",   {42, 17, 88} },                      
        { "Single Element Array",          {99} },                              
        { "Negative and Positive Mixture", {-50, 25, 0, -12, 85, -99, 43, 1} }, 
        { "Large Range with Huge Gap",     {1, 2, 5, 3, 1000000} }  
    };           

    // Run each test case
    for (auto& test : testCases) {
        cout << "--- Testing: " << test.description << " ---" << endl;
        
        cout << "Before: ";
        for (int num : test.data) cout << num << " ";
        cout << endl;

        sort::bucketSort(test.data);

        cout << "After:  ";
        for (int num : test.data) cout << num << " ";
        cout << "\n\n";
    }

    return 0;
}
