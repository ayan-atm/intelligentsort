import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    // Taking random inputs to populate array numbers
    public static void main(String[] args)
    {
        Random rand = new Random();
        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(10000);
        }

        System.out.println("Before: " + Arrays.toString(numbers));

        mergesort(numbers);

        System.out.println("After: " + Arrays.toString(numbers));
    }

    // Implementing mergesort on parameter inputArray
    private static void mergesort(int[] inputArray)
    {
        int inputLength = inputArray.length;
        if (inputLength < 2)
        {
            return;
        }

        // Initialization
        int midpoint = inputLength/2;
        int[] leftside = new int[midpoint];
        int[] rightside = new int[inputLength - midpoint];

        // Populating Left and right sides of the array after divide
        // 1) Leftside
        for (int i = 0; i < midpoint; i++)
        {
            leftside[i] = inputArray[i];
        }
        // 2) Rightside
        for (int i = midpoint; i < inputLength; i++)
        {
            rightside[i - midpoint] = inputArray[i];
        }

        mergesort(leftside);
        mergesort(rightside);
        merge(inputArray, leftside, rightside);
    }

    //Merging leftside and rightside after sorting through each of them
    private static void merge(int[] inputArray, int[] leftside, int[] rightside)
    {
        int i = 0, j = 0, k = 0;
        int LeftSize = leftside.length;
        int RightSize = rightside.length;
        while (i < LeftSize && j < RightSize)
        {
            if (leftside[i] <= rightside[j])
            {
                inputArray[k] = leftside[i];
                i++;
            }
            else
            {
                inputArray[k] = rightside[j];
                j++;
            }
            k++;
        }

        while (i < LeftSize)
        {
            inputArray[k] = leftside[i];
            i++;
            k++;
        }

        while (j < RightSize)
        {
            inputArray[k] = rightside[j];
            j++;
            k++;
        }
    }
}