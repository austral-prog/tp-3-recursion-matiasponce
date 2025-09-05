package com.recursion;

import java.util.List;

public class RecursiveFunctions {

    public static int recursiveIndexOf(List<String> list, String target) {
        return recursiveIndexOfByIndex(list, target, 0);
    }

    public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
        // Base case: if index is out of bounds, return -1
        if (index >= list.size()) {
            return -1;
        }

        // Base case: if we found the target, return the current index
        if (list.get(index).equals(target)) {
            return index;
        }

        // Recursive case: search in the rest of the list
        return recursiveIndexOfByIndex(list, target, index + 1);
    }

    public static int recursiveIndexOfEmpty(List<String> list) {
        return recursiveIndexOfEmptyByIndex(list, 0);
    }

    private static int recursiveIndexOfEmptyByIndex(List<String> list, int index) {
        // Base case: if index is out of bounds, return -1
        if (index >= list.size()) {
            return -1;
        }

        // Base case: if we found an empty string, return the current index
        if (list.get(index).equals("")) {
            return index;
        }

        // Recursive case: search in the rest of the list
        return recursiveIndexOfEmptyByIndex(list, index + 1);
    }

    public static int recursivePut(String target, List<String> list) {
        return recursivePutByIndex(target, list, 0);
    }

    private static int recursivePutByIndex(String target, List<String> list, int index) {
        // Base case: if index is out of bounds, return -1 (no empty slot found)
        if (index >= list.size()) {
            return -1;
        }

        // Base case: if we found an empty slot, put the target there and return the index
        if (list.get(index).equals("")) {
            list.set(index, target);
            return index;
        }

        // Recursive case: search for empty slot in the rest of the list
        return recursivePutByIndex(target, list, index + 1);
    }

    public static int recursiveRemove(List<String> list, String target) {
        return recursiveRemoveByIndex(list, target, 0, 0);
    }

    private static int recursiveRemoveByIndex(List<String> list, String target, int index, int removedCount) {
        // Base case: if index is out of bounds, return the count of removed items
        if (index >= list.size()) {
            return removedCount;
        }

        // If we found the target, remove it and increment the count
        if (list.get(index).equals(target)) {
            list.remove(index);
            // Don't increment index since removing shifts elements left
            return recursiveRemoveByIndex(list, target, index, removedCount + 1);
        }

        // Recursive case: continue searching in the rest of the list
        return recursiveRemoveByIndex(list, target, index + 1, removedCount);
    }

    public static int recursiveSum(List<Integer> list) {
        return recursiveSumByIndex(list, 0);
    }

    private static int recursiveSumByIndex(List<Integer> list, int index) {
        // Base case: if index is out of bounds, return 0
        if (index >= list.size()) {
            return 0;
        }

        // Recursive case: add current element to sum of the rest
        return list.get(index) + recursiveSumByIndex(list, index + 1);
    }

    public static int recursiveFactorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) {
            return 1;
        }

        // Recursive case: n! = n * (n-1)!
        return n * recursiveFactorial(n - 1);
    }

    public static int recursivePow(int base, int exponent) {
        // Base case: any number to the power of 0 is 1
        if (exponent == 0) {
            return 1;
        }

        // Base case: any number to the power of 1 is itself
        if (exponent == 1) {
            return base;
        }

        // Recursive case: base^exponent = base * base^(exponent-1)
        return base * recursivePow(base, exponent - 1);
    }

    public static int recursiveFibonacci(int n) {
        // Base cases: F(1) = 1, F(2) = 1
        if (n <= 2) {
            return 1;
        }

        // Recursive case: F(n) = F(n-1) + F(n-2)
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static boolean recursivePalindrome(String word) {
        // Convert to lowercase for case-insensitive comparison
        return recursivePalindromeHelper(word.toLowerCase(), 0, word.length() - 1);
    }

    private static boolean recursivePalindromeHelper(String word, int left, int right) {
        // Base case: if left >= right, we've checked all characters
        if (left >= right) {
            return true;
        }

        // If characters at left and right positions don't match, it's not a palindrome
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }

        // Recursive case: check the next pair of characters
        return recursivePalindromeHelper(word, left + 1, right - 1);
    }


}
