
package javastandonzanzibar;

import java.util.Scanner;


public class JavaStandOnZanzibar {

    // https://open.kattis.com/problems/zanzibar
    // (*) simple calculation program (accepted in kattis).
    // (*) The current number of people, if there are migrants, must be greater than double of 
    // original inhabitants. Otherwise, there are no migrants. (lower bound migrants situation).
    // (*) in case of lower bound: 
    // A turtle can have a child or not. And it is not necessary that all turtles 
    // have their babies at the same year. 
    
    public static void main(String[] args) {
        
        Scanner in =new Scanner(System.in);
        
        int numOfTests=GetNumberOfTests(in);
        
        int[] migrants=GetMigrantsNumbers(in, numOfTests);
        
        PrintArray(migrants);
        
    }// end main()
    
    private static int[] GetMigrantsNumbers(Scanner input, int numOfTests)
    {
        String tempStr;
        String[] tempStrArray=null;
        int[] tempIntArray=null;
        int[] migrants =new int[numOfTests];
        
        
        for (int i = 0; i < migrants.length; i++) {
            
            tempIntArray=OneLine2IntegerArray(input);
            migrants[i]=LowerBoundOfNumOfTurtlesNotBornOnZanzibar(tempIntArray);
            
        } // end for
        return migrants;
    }
    
    private static int[] OneLine2IntegerArray(Scanner input)
    {
        String oneLine;
        String[] oneLineArray=null;
        int[] res=null;
        try{
            oneLine=GetString(input);
            oneLineArray=String2StringArray(oneLine);
            res=StringArray2IntegerArray(oneLineArray);
            return res;
        }
        catch(Exception e)
        {
            return OneLine2IntegerArray(input);
        }
    }
    
    private static int GetNumberOfTests(Scanner input)
    {
        int numOfTests=0;
        try{
        String numOfTestsStr=GetString(input);
        numOfTests=String2Int(numOfTestsStr);
        if(numOfTests<1|| numOfTests>13)
            throw new Exception();
        return numOfTests;
        }// end try
        catch(Exception e)
        {
            return GetNumberOfTests(input);
        }
    }// end GetNumberOfTests()
    
    private static int LowerBoundOfNumOfTurtlesNotBornOnZanzibar(int[] array)
    {
        int numOfMigrants=0;
        
        int dubble;
        int prevCell;
        int currentCell;
        for (int i = 1; i < array.length; i++) {
            
            
            prevCell=array[i-1];
            dubble=2*prevCell;
            currentCell=array[i];
            if(currentCell> dubble)
            {
                numOfMigrants = numOfMigrants + currentCell-dubble; 
            }
        }// end for
        return numOfMigrants;
    }
    
    private static int[] StringArray2IntegerArray(String[] array)
    {
        int[] res=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i]=Integer.parseInt(array[i]);
        }
        return res;
    }
    
    private static String[] String2StringArray(String str)
    {
        String[] res=str.split(" ");
        return res;
    }
    
    private static String GetString(Scanner input)
    {
        String str=input.nextLine();
        return str;
    }
    
    private static int String2Int(String str)
    {
        int res=Integer.parseInt(str);
        return res;
    }
    
    private static void PrintArray(int[] a)
    {
        for (int i : a) {
            System.out.println(i);
        }
    }
}
