package Sort.Java;
import java.util.ArrayList;
import java.util.Arrays;

class sort{

    // entry point
     public static void radixsort(ArrayList<Integer> arr){
        if(arr.size()<=1){
            return;
        }
        
        RadixSort(arr);
    }

    // radix fxn 
    private static void RadixSort(ArrayList<Integer> arr){
        int max=arr.get(0);
        for (int i =0;i<arr.size();i++){
            if(max<arr.get(i)){
                max=arr.get(i);
            }
        }

        for(int i=1;max/i>0;i*=10){
            countingSort(arr,i);
        }

}

//countingSort 
private static void countingSort(ArrayList<Integer> arr, int exp){
    int[] count=new int[10];
    ArrayList<Integer> output=new ArrayList<Integer>(arr.size());
    for(int i =0;i<arr.size();i++){
        output.add(0);
    }

    // count 
    for (int i =0;i<arr.size();i++){
        count[(arr.get(i)/exp)%10]++;
    }

    //prefix sum
    for(int i =1;i<count.length;i++){
        count[i]+=count[i-1];
    }

   //loop back and copy in temp array
    for(int i=arr.size()-1;i>=0;i--){
        int index=(arr.get(i)/exp) %10;
        output.set(count[index]-1,arr.get(i));
        count[index]--;

    }

    // loop to copy back 
    for (int i =0;i<arr.size();i++){
        arr.set(i,output.get(i));
    }


}

}

class Main{
    public static void main(String[] args){
  
    ArrayList<Integer> data = new ArrayList<>(Arrays.asList(384, 45, 12, 90, 802));
    sort.radixsort(data);
    
    System.out.println( "Perfectly Sorted: ");
    for (int num : data) System.out.println(num+" ");

    }
}