package shortlist;

import java.io.*;
import java.util.*;

class ModifiedLinearSearch {

  static int[] arr = new int[100];
  static int arrSize = 0;
  static int index=-1;

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

  static void selectionSort() {
    for (int i = 0; i < arrSize - 1; i++) {
      int j, k = i;
      for (j = i + 1; j < arrSize; j++) {
        if (arr[j] < arr[i]) {
          k = j;
        }
      }
      if (k != i) {
        int temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
      }
    }
  }

  static void writeBackToFile(int index) {
    try {
      File file = new File("./input.txt");
      FileWriter fr = new FileWriter(file, true);
      BufferedWriter br = new BufferedWriter(fr);
      try (PrintWriter pr = new PrintWriter(br)) {
        if (index != -1) {
          System.out.print("\nElement found at index : " + (index + 1));
          pr.print("\nElement found at index : " + (index + 1));
        } else {
          System.out.print("\nElement not found.");
          pr.print("\nElement not found.");
        }
        pr.close();
      }
    } catch (Exception e) {}
  }

  static void modifiedLinearSearch(int[] arr, int arrSize, int key) {
    int i = 0;
    while (i < arrSize && arr[i] < key) {
      if (arr[i] == key) {
        index = i;
        break;
      }
      i++;
      System.out.print("\n"+i+" : "+index);
      if (i == arrSize || arr[i] > key) {
        index = -1;
      }
    }
  }

  public static void main(String[] args) {
    takeInput();
    selectionSort();
    System.out.println("\nenter the key element : ");
    Scanner sc = new Scanner(System.in);
    int key = sc.nextInt();
    sc.close();
    System.out.print("\nAfter sort the array is : ");
    displayArray();
    modifiedLinearSearch(arr, arrSize, key);
    writeBackToFile(index);
  }
}
