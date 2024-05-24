package org.example;

public class PalindromeCheck {
    public static void main(String[] args){
        String str= "a";
        boolean isPlaindrome = isPlaindrome(str);
        System.out.println("Is the string a plaindrome ? "+ isPlaindrome);
    }

    public static boolean isPlaindrome(String str){
        int left=0,right=str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
