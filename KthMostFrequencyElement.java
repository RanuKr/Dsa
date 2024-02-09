public class KthMostFrequencyElement {
    public static void main(String[] args) {
        int arr[]={1,1,1,2,2,3};
        int k=2;
        solution(arr,k);
    }

    private static void solution(int[] arr, int k) {
        int max=Integer.MIN_VALUE;
        for(int item:arr){
            max=Math.max(item,max);
        }
        int freq[]=new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }   
        for (int i = 0; i < freq.length; i++) {
            if(freq[i]>=k){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
