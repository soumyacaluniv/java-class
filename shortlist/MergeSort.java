package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeSort {

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

  static void merge(int a[], int beg, int mid, int end) {
    int i, j, k;
    int n1 = mid - beg + 1;
    int n2 = end - mid;
    int LeftArray[] = new int[n1];
    int RightArray[] = new int[n2];
    for (i = 0; i < n1; i++) LeftArray[i] = a[beg + i];
    for (j = 0; j < n2; j++) RightArray[j] = a[mid + 1 + j];
    i = 0;
    j = 0;
    k = beg;
    while (i < n1 && j < n2) {
      if (LeftArray[i] <= RightArray[j]) {
        a[k] = LeftArray[i];
        i++;
      } else {
        a[k] = RightArray[j];
        j++;
      }
      k++;
    }
    while (i < n1) {
      a[k] = LeftArray[i];
      i++;
      k++;
    }
    while (j < n2) {
      a[k] = RightArray[j];
      j++;
      k++;
    }
  }

  static void mergeSort(int[] arr, int beg, int end) {
    if (beg < end) {
      int mid = (beg + end) / 2;
      mergeSort(arr, beg, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, beg, mid, end);
    }
  }

  public static void main(String[] args) {
      takeInput();
      mergeSort(arr, 0, arrSize-1);
      writeBackToFile();
  }
}
