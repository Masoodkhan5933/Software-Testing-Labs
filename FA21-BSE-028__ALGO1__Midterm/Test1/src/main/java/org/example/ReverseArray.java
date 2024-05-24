/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author masoo
 */

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] reversedArray = reverseArray(array);
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        int left = 0, right = array.length - 1;
        while (left < array.length) {
            reversedArray[left] = array[right];
            left++;
            right--;
        }
        return reversedArray;
    }
}
