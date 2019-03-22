package algorithm.dp;

public class LongestIncreasingSubSequence {


    public static void main(String[] args) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        System.out.println("input length "+arr.length);
        int result = lis.longestSubsequenceWithActualSolution(arr);
//        int result1 = lis.longestSubsequenceRecursive(arr);
        System.out.println(result);

        System.out.println(longestSubSequenceIterative(arr));
    }

    public static int longestSubSequenceIterative(int arr[]){

        int res[] = new int[arr.length];

        for(int i=0; i < arr.length; i++) {
            int counter = 1;
            for(int j=+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    counter++;
                }
            }
            res[i] = counter;
        }

        int result = -1;
        for(int i=0; i < res.length; i++) {
            if (res[i] > result) {
                result = res[i];
            }
        }

        return result;

    }






























    public int longestSubsequenceWithActualSolution(int arr[]){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        for(int i=0; i < actualSolution.length; i++) {
            System.out.print(actualSolution[i]+" ");
        }
        System.out.println();
        for(int i=0; i < T.length; i++) {
            System.out.print(T[i]+" ");
        }
        System.out.println();
        System.out.println("maxIndex : "+maxIndex);

        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();

        return T[maxIndex];
    }
}
