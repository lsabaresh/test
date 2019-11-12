package leet;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {

    public static void main(String[] args) {

        NextGreaterNode.printOutput(new NextGreaterElement().nextGreaterElements(new int[] {1, 2, 1}));
        NextGreaterNode.printOutput(new NextGreaterElement().nextGreaterElements(new int[] {1, 11, 10, 2, 7}));
    // 6, 2, 1, 5
    }

    public int[] nextGreaterElements(int[] nums) {

        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for (int i=0; !stack.isEmpty() && i < stack.peek(); i++) {
            while (nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;

    }
}
