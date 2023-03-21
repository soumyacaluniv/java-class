package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class HeapSort {

  static int[] arr = new int[100];
  static int arrSize = 0;

  static void takeInput() {
    File file = new File("./input.txt");
    try (Scanner scanner = new Scanner(file)) {
      int i = 0;
      while (scanner.hasNextInt()) {
        String x = scanner.next();
        arr[i++] = Integer.parseInt(x);
        arrSize++;
      }
      System.out.print("The arr is : ");
      displayArray();
    } catch (Exception e) {}
  }

  static void displayArray() {
    for (int i = 0; i < arrSize; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void writeBackToFile() {
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
    } catch (Exception e) {}
  }

  static void heapsort() {
    for (int i = arrSize / 2 - 1; i >= 0; i--) heapify(arr, arrSize, i);
    for (int i = arrSize - 1; i > 0; i--) {
        // System.out.println("\n"+i+" : ");
        // displayArray();
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
    }
  }

  static void heapify(int arr[], int N, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < N && arr[l] > arr[largest]) largest = l;
    if (r < N && arr[r] > arr[largest]) largest = r;
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;
      heapify(arr, N, largest);
    }
  }

  public static void main(String[] args) {
    takeInput();
    heapsort();
    writeBackToFile();
  }
}
