package day2;

import java.util.*;
class Linear_search
{
 public static void main(String args[])
 {
  try (Scanner sc = new Scanner(System.in)) {
    System.out.println("Enter the size of the array: ");
    int n=sc.nextInt();
    int[] A=new int[n];
    System.out.println("Enter the elements of the array: ");
    for(int i=0;i<n;i++)
       A[i]=sc.nextInt();
    
    System.out.println("Enter the key element: ");
    int key=sc.nextInt();
    int j=0;
    while((j<n) && (A[j]!=key))
    {
      j++;
    }
    if(j>=n || (A[j]!=key))
      System.out.println("The element is not present.");
    else
      System.out.println("key found at index"+(j+1));
  }
 }
}

