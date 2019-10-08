public class SubarraySum {
    public static int getMaxSum(int [] arr, int s,int e){
        
        if(s==e){
            return arr[s];
        }
        int mid=(s+e)/2;
        int max=Math.max(getMaxSum(arr,s,mid),getMaxSum(arr,mid+1,e));
        
        int max_1=arr[mid];
        int sum_1=0;
        
        for(int i=mid;i>=0;i--){
            sum_1+=arr[i];
            
            if(sum_1>max_1){
                max_1=sum_1;
            }
            
        }
        
        int max_2=arr[mid+1];
        int sum_2=0;
        
        for(int i=mid+1;i<=e;i++){
            sum_2+=arr[i];
            
            if(sum_2>max_2){
                max_2=sum_2;
            }
        }
        
        return Math.max(max,max_1+max_2);
        
    }
    
    
    
    
    public static void main(String args[]) {
        
        int [] arr= {6,-7,-1,3,5};
        System.out.println(getMaxSum(arr,0,arr.length-1));
        
    }
    
}
