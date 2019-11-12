package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/contest/weekly-contest-130/problems/next-greater-node-in-linked-list/
public class NextGreaterNode {

    public static void main(String[] args) {
        printOutput(new NextGreaterNode().nextLargerNodes(constructLinkedList(new int[] {2,1, 5})));
        printOutput(new NextGreaterNode().nextLargerNodes(constructLinkedList(new int[] {2, 7, 4, 3, 5})));
        printOutput(new NextGreaterNode().nextLargerNodes(constructLinkedList(new int[] {1,7,5,1,9,2,5,1})));
    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> inputs = new ArrayList<>();
        while (head != null) {
            inputs.add(head.val);
            head = head.next;
        }

        int[] output = new int[inputs.size()];
        Stack<Integer> stack = new Stack<>();
        for (int counter = 0; counter < output.length; ++counter) {
            while (!stack.isEmpty() && inputs.get(stack.peek()) < inputs.get(counter)) {
                output[stack.pop()] = inputs.get(counter);
            }
            stack.push(counter);
        }
        return output;
    }

    public static ListNode constructLinkedList(int []input) {
        ListNode head = null;
        for (int counter= input.length-1; counter >=0; counter--){
            ListNode tmp = new ListNode(input[counter]);
            tmp.next = head;
            head = tmp;

        }
        return head;
    }

    public static void printOutput(int []output) {
        System.out.println(Arrays.stream(output).boxed().collect(Collectors.toList()));
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
