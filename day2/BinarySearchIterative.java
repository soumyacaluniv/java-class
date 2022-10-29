package day2;

class BinarySearchIterative{
    public static void binarySearch(int arr[], int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
           if ( arr[mid] == key ){
             System.out.println("Element is found at index: " + mid);
             break;
          }else if (arr[mid] < key){
            first = mid + 1;   
           }else{
              last = mid - 1;
           }
           mid = (first + last)/2;
        }
        if ( first > last ){
           System.out.println("Element is not found!");
        }
      }
    public static void main(String[] args) {
        int[] arr = {10,25,29,45,99,120,129};
        System.out.println("Searching the arr for the element 45:");
        binarySearch(arr, 0, arr.length-1, 45);
        System.out.println("Searching the arr for the element 225:");
        binarySearch(arr, 0, arr.length-1, 225);
    }
}