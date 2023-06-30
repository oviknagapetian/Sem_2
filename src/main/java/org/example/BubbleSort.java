import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        bubbleSort(array);
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        String logFileName = "bubble_sort_log.txt";

        try (FileWriter writer = new FileWriter(logFileName)) {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap arr[j] and arr[j+1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                // Write the current state of the array to the log file
                writer.write("Iteration " + (i + 1) + ": ");
                for (int num : arr) {
                    writer.write(num + " ");
                }
                writer.write("\n");

                // If no two elements were swapped in the inner loop, the array is already sorted
                if (!swapped) {
                    break;
                }
            }
            System.out.println("Array sorted successfully. Check the log file: " + logFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
