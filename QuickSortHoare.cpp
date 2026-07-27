#include <iostream>
#include <cstdlib> // For rand() and srand()
#include <ctime>  
#include <vector>
#include <string>
using namespace std;


class Sort{
    public:
     
     static void quicksort(int arr[],int size){
        if(size<=1){return; }
        int low=0;
        int high=size-1;
        sort(arr,low,high);

    

     };


     private:
     // start 
     static void sort(int arr[],int low,int high){

        if(low<high){
        int partition=randomizeHoare(arr,low,high);


        sort(arr,low,partition);
        sort(arr,partition+1,high);
        }





     };

     // randomize
     static int randomizeHoare(int arr[], int low, int high){
        int pivot=low+rand()%(high-low+1);
        swap(arr[low],arr[pivot]);
       return hoarePartition(arr,low,high);
     };

     //hoare partition
     static int hoarePartition(int arr[],int low,int high){

        int i=low-1;
        int j=high+1;
        int pivot=arr[low];


        while(true){
         

            do{i++;

            }while(arr[i]<pivot);
           do{
            j--;
           }while(arr[j]>pivot);

           if(i>=j){
            return j;}

           swap(arr[i],arr[j]);
          

        }


     };



     // helper swap fxn 
     static void swap(int &a,int &b){
        int temp=a;
        a=b;
        b=temp;
     };

};




    
int main() {
    srand(time(0));

    struct TestCase {
        string description;
        vector<int> data;
    };

    vector<TestCase> testCases = {
        { "Already Sorted Array",   {1, 2, 3, 4, 5, 6, 7, 8} },
        { "Reverse Sorted Array",   {8, 7, 6, 5, 4, 3, 2, 1} },
        { "All Identical Elements", {5, 5, 5, 5, 5, 5, 5, 5} }, // Tests if pointers cross safely
        { "Two Elements Unsorted",  {42, 17} },                 // Tests the smallest sortable tree
        { "Single Element Array",   {99} },                     // Tests base case boundary
        { "Empty Array",            {} },                       // Tests security of public entry point
        { "Negative & Zero Values", {-3, 0, -1, 5, -10, 2} },
        { "Duplicated Ribbons",     {1, 2, 1, 2, 1, 2, 1, 2} }  // Tests heavy duplicate handling
    };

    // Run the tests
    for (auto& test : testCases) {
        int size = test.data.size();
        
        int* arr = test.data.data(); 

        cout << "--- Testing: " << test.description << " ---" << endl;
        cout << "Before: ";
        if (size == 0) cout << "[Empty]";
        for (int i = 0; i < size; i++) cout << arr[i] << " ";
        cout << endl;

        Sort::quicksort(arr, size);

        cout << "After:  ";
        if (size == 0) cout << "[Empty]";
        for (int i = 0; i < size; i++) cout << arr[i] << " ";
        cout << "\n\n";
    }

    return 0;
}

