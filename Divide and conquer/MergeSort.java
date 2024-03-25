public class MergeSort{
    
    int merge(int a[], int start, int mid, int end){
        
        int leftArr[] = new int[mid - start + 1]; // mid is inclusive, and whenever there is inclusive we add one, like in: i = 0; i <= arr.length+1  
        int rightArr[] = new int [end - mid];
        
        
        for(int i=0; i<leftArr.length; i++){
            leftArr[i] = a[i + start];
        }

        for(int i=0; i<rightArr.length; i++){
            rightArr[i] = a[mid + 1 + i]; // elements after mid
        }

        int i = 0; 
        int j = 0;
        int k = start;

        while (i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] < rightArr[j]){
                a[k] = leftArr[i];
                i++;
                k++;
            }
            else{
                a[k] = rightArr[j];
                j++;
                k++;
            }
        }

        while (i >= leftArr.length && j < rightArr.length) {
            a[k] = rightArr[j];
            k++;
            j++;
            
        }

        while (i < leftArr.length && j >= rightArr.length) {
            a[k] = leftArr[i];
            i++;
            k++;
        }

        return 1;
        

    }


    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        // Corrected array initialization
        int[] a = { 1, 8, 74, 4 };

        mergeSort.merge(a, 0, a.length - 1, 0);

        System.out.println("Sorted array:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
