public class MyClass {
    public static void sort(int [] arr){
        for(int i=1;i<arr.length;i++){
            int toBeInserted=arr[i];
            int k=i-1;
            
            while(k>=0&&arr[k]>toBeInserted){
                arr[k+1]=arr[k];
                k--;
            }
            arr[k+1]=toBeInserted;
            
        }
    }
    
    
    
    public static void main(String args[]) {
      int [] a={5,4,3,0,14,56,79,123,12,59};
      sort(a);
      for(int k:a){
          System.out.println(k);
      }
    }
}
