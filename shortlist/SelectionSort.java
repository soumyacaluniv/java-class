package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class SelectionSort{
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
    static void takeInput(){
        File file = new File("./input.txt");
        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNextInt()) {
                String x = scanner.next();
                arr[i++] = Integer.parseInt(x);
                arrSize++;
            }
            System.out.print("The array is : ");
            displayArray();
        }catch(Exception e){
            
        }
    }
    static void displayArray(){
        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void selectionSort(){
        for(int i=0;i<arrSize-1;i++){
            int j,k=i;
            for(j=i+1;j<arrSize;j++){
                if(arr[j]<arr[i]){
                    k=j;
                }
            }
            if(k!=i){
                int temp = arr[k];
                arr[k]=arr[i];
                arr[i] = temp;
            }
            // System.out.println("");
            // displayArray();
        }
    }
    public static void main(String[] args) {
        takeInput();
        selectionSort();
        writeBackToFile();
    }
}