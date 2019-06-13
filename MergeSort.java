public class MergeSort {
    public static void main(String args[]) {
        int [] arr= {42,15,69,12,35,14,47,53};
        mergeSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void mergeSort(int [] arr,int p, int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
            
            
        }
        else return;
        
        
        
    }
    public static void merge(int []arr,int p,int q, int r){
        int length1=q-p+1;
        int length2=r-q;
        int [] left =new int [length1+1];
        int [] right=new int [length2+1];
        
        for(int i=0;i<length1;i++){
            left[i]=arr[p+i];
        }
        for(int i=0;i<length2;i++){
            right[i]=arr[q+1+i];
        }
        System.out.println(length1+" "+ length2+" "+r+"  "+p );
        
        left[length1]=Integer.MAX_VALUE;
        right[length2]=Integer.MAX_VALUE;
        
        int l=0;
        int k=0;
        
        for(int i=p;i<=r;i++){
            if(left[l]<=right[k]){
                arr[i]=left[l];
                l++;
            }
            else {
                arr[i]=right[k];
                k++;
            }
        }
    }
    
    
    
}
