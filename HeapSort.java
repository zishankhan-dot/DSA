import java.util.Arrays;



public class HeapSort {
    //entry point for heapsort
    public static void heapsort(int arr[]){
        if(arr.length<=1){
            return;
        }
        heapSort(arr);
    }

    // worker fxn
    private static void heapSort(int arr[]){
        maxTree(arr);
        for(int i=arr.length-1;i>0;i--){
            swapTwo(arr,0,i);
            heapify(arr,i,0);
        }
    }

    //maxtree buildup fxn
    private static void maxTree(int[] arr){
        int size=arr.length;
        for(int i =(size-2)/2; i>=0 ;i--){
            heapify(arr,size,i);
        }
    }

    //heapify fxn
    private static void heapify(int[] arr,int size,int parentindex){
        int currentMax=parentindex;
        int left=(2*parentindex)+1;
        int right = (2*parentindex)+2;
        if(left<size && arr[left]>arr[currentMax]){
            currentMax=left;
        }
        if(right<size && arr[right]>arr[currentMax]){
            currentMax=right;
        }

        if(currentMax!=parentindex){
            swapTwo(arr,currentMax,parentindex);
            heapify(arr,size,currentMax);
        }




    }


//swap helper fxn
    private static void swapTwo(int[] arr,int a,int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
}






//main fxn

class  Main{
    static class TestCase {
        String description;
        int[] input;
        int[] expected;

        TestCase(String description, int[] input, int[] expected) {
            this.description = description;
            this.input = input;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- STARTING ARRAY-DRIVEN HEAPSORT TESTS --- \n");

        TestCase[] testSuite = new TestCase[] {
            new TestCase("Standard Mixed Array", new int[]{4, 10, 3, 5, 1}, new int[]{1, 3, 4, 5, 10}),
            new TestCase("Already Sorted Array", new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
            new TestCase("Reverse Sorted Array", new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
            new TestCase("Array with Duplicates", new int[]{4, 2, 4, 1, 2}, new int[]{1, 2, 2, 4, 4}),
            new TestCase("Single Element Array", new int[]{7}, new int[]{7}),
            new TestCase("Empty Array Boundary", new int[]{}, new int[]{})
        };

        for (TestCase test : testSuite) {
            System.out.println("Executing: " + test.description);
            System.out.println("-> Original: " + Arrays.toString(test.input));

            // Call your heapsort implementation
            HeapSort.heapsort(test.input);

            System.out.println("-> Sorted:   " + Arrays.toString(test.input));

            // Validate correctness
            if (Arrays.equals(test.input, test.expected)) {
                System.out.println("Result: PASSED\n");
            } else {
                System.out.println("Result: FAILED (Expected: " + Arrays.toString(test.expected) + ")\n");
            }
        }
    }
}
