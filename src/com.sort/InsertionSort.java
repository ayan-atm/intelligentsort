import java.util.Arrays;

public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] inputArray = {80, 30, 68, 71, 99, 99, 76, 65, 45, 53};
        System.out.println("Before: " + Arrays.toString(inputArray));
        int[] sortedArray = insertionSort(inputArray);
        System.out.println("After: " + Arrays.toString(sortedArray));
    }

    public static int[] insertionSort(int[] inputArray)
    {
        for (int i = 1; i < inputArray.length; i++)
        {
            int tempValue = inputArray[i];
            int j = i -1;
            while (j >= 0 && tempValue < inputArray[j])
            {
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = tempValue;
        }

        return inputArray;
    }
}