package shortlist;

import java.io.File;
import java.util.Scanner;

class LinearSearch{
    static int[] arr = new int[100];
    static int arrSize = 0;
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
        System.out.println("");
    }
    static void linearSearch(int key){
        for(int i =0; i<arrSize; i++){
            if(arr[i]==key){
                System.out.print("Element found at index : "+(i+1));
                System.exit(1);
            }
        }
        System.out.print("Element not found.");
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            takeInput();
            System.out.print("Enter the element to search : ");
            int key = scanner.nextInt();
            linearSearch(key);
        }
    }
}