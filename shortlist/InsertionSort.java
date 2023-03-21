package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class InsertionSort {

    static int[] arr = new int[100];
    static int arrSize = 0;
    static void writeBackToFile(){
        try {
          File file = new File("./input.txt");
          FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    try (PrintWriter pr = new PrintWriter(br)) {
                        pr.print("\nAfter sort the array is : ");
                        System.out.print("\nAfter sort the array is : ");
                        for (int i = 0; i < arrSize; i++) {
                            pr.print(arr[i] + " ");
                            System.out.print(arr[i] + " ");
                        }
                        pr.close();
                    }
        } catch (Exception e) {
        }
      }
    public static void main(String[] args) {
        try {
            File file = new File("./input.txt");
            try (Scanner scanner = new Scanner(file)) {
                int i = 0;
                while (scanner.hasNextInt()) {
                    String x = scanner.next();
                    arr[i++] = Integer.parseInt(x);
                    arrSize++;
                }
                System.out.print("The array is : ");
                for (i = 0; i < arrSize; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (i = 1; i < arrSize; i++) {
                    int key = arr[i];
                    int j = i - 1;
                    while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j = j - 1;
                    }
                    arr[j + 1] = key;
                }
                writeBackToFile();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}
