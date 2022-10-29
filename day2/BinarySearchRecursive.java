package day2;

public class BinarySearchRecursive {
    public static int binarySearch(int arr[], int first, int last, int key){
		if (last>=first){
			int mid = first + (last - first)/2;
			if (arr[mid] == key){
			return mid;
            }
			if (arr[mid] > key){
			return binarySearch(arr, first, mid-1, key);
            }else{
			return binarySearch(arr, mid+1, last, key);
            }
		}
		return -1;
	}
    public static void main(String[] args) {
        int[] arr = {10,25,29,45,99,120,129};
        System.out.println("Searching the arr for the element 45:");
        if(binarySearch(arr, 0, arr.length-1, 45)==-1){
            System.out.println("Element is not found.");
        }else{
            System.out.println("Element is found.");
        }
    }
}
