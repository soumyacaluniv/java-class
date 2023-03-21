package shortlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class BubbleSort {
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
                    for(i=0;i<arrSize-1;i++){
                        for(int j = 0; j < arrSize - i - 1; j++){
                            if(arr[j]>arr[j+1]){
                                int temp = arr[j+1];
                                arr[j+1] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    writeBackToFile();
                }catch(Exception e){
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }
    }
}