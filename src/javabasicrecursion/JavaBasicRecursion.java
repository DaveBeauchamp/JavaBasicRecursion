
package javabasicrecursion;

import java.util.*;

/**
 *
 * @author Lazy
 */
public class JavaBasicRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            JavaBasicRecursion jbr = new JavaBasicRecursion();

            // generate random list
            ArrayList list = jbr.GenerateListOfRandomNumbers();

            System.out.println("This is the start list \r\n");

            for (Object item : list)
            {
                System.out.println(item);
            }

            System.out.println("");

            // Call recursive method
            ArrayList sortedList = jbr.RemoveDuplicates(list);
            Collections.sort(sortedList);

            System.out.println("This is the list without duplicates (sorted) \r\n");

            for (Object item : sortedList)
            {
                System.out.println(item);
            }

        }
    
    public ArrayList GenerateListOfRandomNumbers()
        {
            //Random rn = new Random();
            ArrayList randomList = new ArrayList();

            for (int i = 0; i < 100; i++)
            {
                randomList.add(getRandomNumberInRange(1, 20));
            }

            return randomList;
        }
    
    private static int getRandomNumberInRange(int min, int max)
    {
        if (min >= max) {
            throw new IllegalArgumentException("Max needs to be greater than Min");
        }
        
        Random rn = new Random();
        return rn.nextInt((max - min) + 1) + min;
        
    }
    
    // don't want list or pointer reinstanced in the recursion
        int checkIndex = 0;
        ArrayList tempList = new ArrayList();

        public ArrayList RemoveDuplicates(ArrayList list)
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (checkIndex >= list.size())
                {
                    // keep the pointer in bounds
                    checkIndex = 0;
                }
                if (list.get(checkIndex) == list.get(i) && checkIndex == i)
                {
                    // found same record so do nothing
                }
                else if (list.get(checkIndex) == list.get(i))
                {
                    list.remove(i);
                    // found duplicate, so remove the duplicate
                }
            }
            // move pointer
            checkIndex++;

            if (checkIndex < list.size())
            {
                // recursive call
                RemoveDuplicates(list);
            }
            else if (checkIndex == list.size())
            {
                //store in temp 
                tempList = list;
            }

            // return temp
            return tempList;
        }
    
}
