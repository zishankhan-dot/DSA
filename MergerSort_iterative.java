 import java.util.Arrays;
 class Sort{
  
  void merge(int []arr,int low, int mid, int high){
      int size=arr.length;
      int[] temp= new int[size];
      int i=low;
      int j=mid+1;
      int point=low;
      while(i<=mid && j<=high){
          if(arr[i]<arr[j]){
              temp[point++]=arr[i];
              i++;
              
              
          }
          else{
              temp[point++]=arr[j];
              j++;
          }
      }
      
      while(i<=mid){
         temp[point++]=arr[i];
         i++;
      }
      
      while(j<=high){
          temp[point++]=arr[j];
          j++;
      }
      // put everything from temp to original array;
      for(int k=low;k<=high;k++){
          arr[k]=temp[k];
      }
  }
  
  
 void mergeSort(int [] arr){
     int size=arr.length;
     for (int i=1;i<size;i*=2){
         
         //low= subsets
         for(int low=0;low<size;low+=i*2){
             int mid=Math.min(low+i-1,size-1);
             int high=Math.min(low+(i*2)-1,size-1);
             this.merge(arr,low,mid,high);
             
         }
     }
    
 }   
 }

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
Sort s1=new Sort();
int[] arr= {2,1,5,4,6,7,3,8};
s1.mergeSort(arr);
for (int i =0;i<arr.length;i++){
    System.out.print(arr[i]);
}
    }
}