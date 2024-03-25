package Divide and conquer;

public class FindMinMax {
    public static class Pair{
        int min;
        int max;
        Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    Pair minMax(int a[], int startIndex, int end){
        if(start == end){
            // int min = a[start];
            // int max = a[start];
            return new Pair(a[start], a[start]);
        }

        // raw comparison code
        
        if(start+1 == end){
            int min, max;
            if(a[start] == a[end]){
                min=max=a[start];
            }
            else if(a[start] < a[end]){
                min = a[start];
                max = a[end]; 
            }
            else{
                max = a[start];
                min = a[end];
            }
        }
        
        return new Pair(Math.min(a[start],a[end]), Math.max(a[start],a[end]));
    }   

    int mid = (start+end)/2; // finding the mid value
    Pair leftminmax = minMax(a, start, mid); // cuz start to mid is the left half  
    Pair rightminmax = minMax(a, mid+1, end);
    
    return new Pair(Math.min(leftminmax.min, rightminmax.min), Math.max(leftminmax.max, rightminmax.max));
}
