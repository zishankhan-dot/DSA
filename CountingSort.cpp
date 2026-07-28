#include<iostream>
#include<vector>
using namespace std;

class Sort{

    public:
    static void countingSort(vector<int> &arr,int frequency){
        if(arr.size()<=1){
            return ;
        }
        CountingSort(arr,frequency+1);
    }
  


    private:
    



    static void CountingSort(vector<int> &arr, int frequency){

        vector<int> count(frequency,0);
        vector<int> temp(arr.size(),0);
        // increase count 
        for(int i =0; i<arr.size();i++){
            count[arr[i]]++;
        }

        // do prefixsum
        for(int i=1;i<frequency;i++){
            count[i]+=count[i-1];
        }

        //loop through the array and place the elements in the temp array 
        for(int i =arr.size()-1;i>=0;i--){
            temp[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;

        }

        //copy back to original array 
        for (int i =0;i<arr.size();i++){
            arr[i]=temp[i];

        }


    }

};


int main(){
vector<int> arr = {4, 5, 3, 5, 1, 0, 2};
    int maxVal = 5; // The maximum number in our array is 5

    Sort::countingSort(arr, maxVal);

    cout << "Sorted array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;
    
    return 0;
}