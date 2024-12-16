import java.util.*;
import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.translate.TranslateException;

// Main Class
public class SortingDecisionTreeWithML {

    public static void decideAndSort(int[] arr) {
        try {
            String predictedAlgorithm = MLModel.predictAlgorithm(arr);

            if (predictedAlgorithm.equals("insertion")) {
                System.out.println("Using Insertion Sort (predicted by ML).");
                InsertionSort.sort(arr);
            } else {
                System.out.println("Using Merge Sort (predicted by ML).");
                MergeSort.sort(arr, 0, arr.length - 1);
            }
        } catch (Exception e) {
            System.out.println("Error in ML model: Defaulting to Merge Sort.");
            MergeSort.sort(arr, 0, arr.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println("Original Array: " + Arrays.toString(arr));

        decideAndSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

