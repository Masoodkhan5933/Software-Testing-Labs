package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeCheckTest {

    @Test
    public void test1() {
        String str = "x";
        
        boolean result = PalindromeCheck.isPlaindrome(str);
        
        assertTrue(result);
    }

    @Test
    public void test2() {
        String str = "xy";
        
        boolean result = PalindromeCheck.isPlaindrome(str);
        
        assertFalse(result);
    }

    @Test
    public void test3() {
        String str = "DAD";
        
        boolean result = PalindromeCheck.isPlaindrome(str);
        
        assertTrue(result);
    }

    @Test
    public void test4() {
        String str = "";
        
        boolean result = PalindromeCheck.isPlaindrome(str);
        
        assertTrue(result);
    }
}
