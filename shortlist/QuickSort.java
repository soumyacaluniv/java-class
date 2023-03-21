package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSort {
    static int[] arr = new int[100];
    static int arrSize = 0;
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];    
        int i = (low - 1);
        for (int j = low; j < high; j++) {
          if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
      }
    
      static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
          int pi = partition(arr, low, high);
          quickSort(arr, low, pi - 1);      
          quickSort(arr, pi + 1, high);
        }
      }
      static void takeInput(){
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
        }catch(Exception e){
            
        }
    }
    static void displayArray(){
        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
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
        takeInput();
        quickSort(arr,0,arrSize-1);
        writeBackToFile();
    }
}
