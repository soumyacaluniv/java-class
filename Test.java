import java.io.*;
import java.util.Scanner;

public class Test {
    static int[] arr = new int[100];
    static int arrSize = 0;
    public static void binarySearch(int arr[], int first, int last, int key, File file){
        int mid = (first + last)/2;
        while( first <= last ){
           if ( arr[mid] == key ){
               String str = "\nElement is found at index: " + mid;
             System.out.println(str);
             try {
                FileWriter fr = new FileWriter(file, true);
                fr.write(str);
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             break;
          }else if (arr[mid] < key){
            first = mid + 1;   
           }else{
              last = mid - 1;
           }
           mid = (first + last)/2;
        }
        if ( first > last ){
            String str = "\nElement is not found!";
           System.out.println(str);
           try {
            FileWriter fr = new FileWriter(file, true);
            fr.write(str);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
      }
    public static void main(String[] args) {
        File file= new File("input.txt");
        try {
            // file.createNewFile();
            // FileWriter fileWriter = new FileWriter("input.txt");
            // fileWriter.write("hello this ia a string 25");
            // fileWriter.close();
            try (Scanner scanner = new Scanner(file)) {
                int i=0;
                while(scanner.hasNextInt()){
                    String x = scanner.next();
                    arr[i++] = Integer.parseInt(x);
                    arrSize++;
                }
                System.out.print("The array is : ");
                for(i=0;i<arrSize;i++){
                    System.out.print(arr[i]+" ");
                }
                int key=0;
                System.out.print("\nenter the key : ");
                scanner.close();
                Scanner sc = new Scanner(System.in);
                key = sc.nextInt();
                sc.close();
                System.out.println("Searching the arr for the element "+ key +":");
                binarySearch(arr, 0, arrSize, key, file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
