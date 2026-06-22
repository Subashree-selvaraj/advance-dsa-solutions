import java.util.Random;
import java.util.Scanner;

public class NaiveShuffle {

    
    public static void naiveShuffle(int[] arr) {
        int n = arr.length;
        Random rand = new Random();

        
        for (int i = 0; i < n; i++) {        
            int j = rand.nextInt(n);
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original array:");
        printArray(arr);

        naiveShuffle(arr);

        System.out.println("Shuffled array (NAIVE - BIASED):");
        printArray(arr);

        sc.close();
    }
}