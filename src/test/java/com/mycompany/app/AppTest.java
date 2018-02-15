package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testDeterminantIsTrue() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        
        assertEquals("Congrats. You guessed right! The determinant is -306! ",new App().determinant(firstArray, secondArray,thirdArray, -306));
      }
  
     public void testDeterminantIsFalse() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        
        assertEquals("Sorry, but you guessed wrong. The determinant is -306. Please try again! ",new App().determinant(firstArray, secondArray,thirdArray,200));
      }
      public void testFirstSizeIsNotThree() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1,8));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        
        assertEquals("Every box needs to contain exactly 3 integers.",new App().determinant(firstArray,secondArray,thirdArray,-306));
      }  
      public void testSecondSizeIsNotThree() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5,8));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        
        assertEquals("Every box needs to contain exactly 3 integers.",new App().determinant(firstArray,secondArray,thirdArray,-306));
      }  
      public void testThirdSizeIsNotThree() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7,9));
        
        assertEquals("Every box needs to contain exactly 3 integers.",new App().determinant(firstArray,secondArray,thirdArray,-306));
      }  
      public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7,9));
        assertEquals("Every box needs to contain exactly 3 integers.",new App().determinant(array,secondArray ,thirdArray, -306));
      }
  
      public void testAllNull() {
        assertEquals("One of the boxes is empty. Please enter three 3 sized arrays.",new App().determinant(null, null, null, 1));
      }
       public void testFirstIsNull() {
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));    
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        assertEquals("One of the boxes is empty. Please enter three 3 sized arrays.",new App().determinant(null, secondArray, thirdArray, 1));
      }
      public void testSecondIsNull() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> thirdArray = new ArrayList<>(Arrays.asList(2,8,7));
        assertEquals("One of the boxes is empty. Please enter three 3 sized arrays.",new App().determinant(firstArray, null, thirdArray, 1));
      }
      public void testThirdIsNull() {
        ArrayList<Integer> firstArray = new ArrayList<>(Arrays.asList(6,1,1));
        ArrayList<Integer> secondArray = new ArrayList<>(Arrays.asList(4,-2,5));
        assertEquals("One of the boxes is empty. Please enter three 3 sized arrays.",new App().determinant(firstArray, secondArray, null, 1));
      }  
}
