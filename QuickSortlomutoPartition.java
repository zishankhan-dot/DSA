import java.util.Arrays;

// quickSort 
 class sortArray{

    // entry point 
    public static void quickSort(int []arr){
        if(arr.length <= 1){return ; }


        sort(arr,0,arr.length-1);

    }

    
    //helper function to sort the array
    private static void sort(int[] arr,int low,int high){
        //base case to return
     if(low>=high){return ;}
     int pivot=randomizedpartition(arr,low,high);


     sort(arr,low,pivot-1);
     sort(arr,pivot+1,high);

    }




    //helper fxn to randomize partition
    private static int randomizedpartition(int arr[], int low,int high){
        int pivot = low+(high-low)/2;
        swap(arr,pivot,high);
        return partition(arr,low,high);
    }

    //helper fxn to find pivot
    private static int partition(int[] arr,int low ,int high){
        int pivot = arr[high];
        int j=low-1;
        for (int i =low;i < high;i++){
            if(arr[i]<=pivot){
                j++;
                swap(arr,i,j);
            }
        }

        swap(arr,++j,high);

        return j;



    }

    private static  void swap(int []arr,int i, int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

}










// Main function 
class Main{
    public static void main(String[] args){
        int[] exampleArray = {34, 7, 23, 32, 5, 62};
        
        System.out.println("Before sorting: " + Arrays.toString(exampleArray));
        
        sortArray.quickSort(exampleArray);
        
        System.out.println("After sorting:  " + Arrays.toString(exampleArray));
    }

}
