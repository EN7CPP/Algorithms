import java.util.Arrays;

public class CountingSort {
    public static int [] countingSort(int [] arr){
        int max=arr[0];
        int [] sortedArr=new int [arr.length];
        for(int i:arr){
            if(i>max)max=i;
        }
        
        int [] counts= new int [max+1]; 
        Arrays.fill(counts,0);
        
        for(int i:arr){
            counts[i]++;
        }
        
        for(int i=1;i<counts.length;i++){
            counts[i]=counts[i-1]+counts[i];
        }
        
        for(int i=0;i<arr.length;i++){
            sortedArr[counts[arr[i]]-1]=arr[i];
            counts[arr[i]]--;
        }
        return sortedArr;
    }
    
    
    
    
    public static void main(String args[]) {
        
        int [] arr= {6,1,3,5,14,6,7};
        int [] sortedArr=countingSort(arr);
        System.out.println(Arrays.toString(sortedArr));
        
    }
    
}
