package leet.w52;

public class MaximumSumof3NonOverlappingSubarrays {

    public static void main(String[] args) {
        MaximumSumof3NonOverlappingSubarrays m = new MaximumSumof3NonOverlappingSubarrays();

        System.out.println("{\"validationErrors\":[{\"code\":\"ds_error-20137\",\"message\":\"Notwoanswerscanbethesame.\",\"path\":\"questions[0].answer\"},{\"code\":\"ds_error-20137\",\"message\":\"Notwoanswerscanbethesame.\",\"path\":\"questions[1].answer\"}]}".contains("ds_error-20137"));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] output = new int[3];
        if (nums.length < ( k * 2) ){
            return output;
        }

        for (int i=0; i < nums.length; i++) {

            for (int j=i; i < i+k; j++) {
            }
        }

        return output;
    }
}
