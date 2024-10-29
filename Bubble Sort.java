

import java.util.Arrays;
public class BubbleSortExample 
{
  public static void main(String[] args) 
  {
    Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
 
    bubbleSort(array, 0, array.length);
 
    System.out.println(Arrays.toString(array));
  }
 
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void bubbleSort(Object[] array, int fromIndex, int toIndex) 
  {
    Object d;
    for (int i = toIndex - 1; i > fromIndex; i--) 
    {
      boolean isSorted = true;
      for (int j = fromIndex; j < i; j++) 
      {
        if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) 
        {
          isSorted = false;
          d = array[j + 1];
          array[j + 1] = array[j];
          array[j] = d;
        }
      }
      if (isSorted)
        break;
    }
  }
}

Output:
[3, 6, 10, 12, 13, 24, 70, 90].

//Sorting an Array In Descending Order:
public class BubbleSortDemo {
  static void bubbleDescending(int[] myarray) {
    int n = myarray.length;
    int temp = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (myarray[j - 1] < myarray[j]) {
          temp = myarray[j - 1];
          myarray[j - 1] = myarray[j];
          myarray[j] = temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    int myarray[] = {
      4,
      15,
      12,
      21,
      2,
      25,
      10,
      18
    };
    System.out.println("Array on which we apply Bubble Sort: ");
    for (int i = 0; i < myarray.length; i++) {
      System.out.print(myarray[i] + " ");
    }
    System.out.println();
    bubbleDescending(myarray); 
    System.out.println("Array after applying Bubble Sort: ");
    for (int i = 0; i < myarray.length; i++) {
      System.out.print(myarray[i] + " ");
    }
  }
}
Output:
Array on which we apply Bubble Sort: 
4 15 12 21 2 25 10 18 
Array after applying Bubble Sort: 
25 21 18 15 12 10 4 2


//Java Program to Check Armstrong Number:

public class BubbleSort1 {
 
	public static void main(String[] args)
	{  
		int arr[] ={860,8,200,9};  
 
		System.out.println("---Array BEFORE Bubble Sort---"); 
		
	    printArray(arr);
 
		bubbleSort(arr);
 
		System.out.println("---Array AFTER Bubble Sort---");  
		
		printArray(arr); 
 
	}  
 	static void bubbleSort(int[] array)
	{  
		int n = array.length;  
		int temp = 0;  
		for(int i=0; i < n; i++) 
		{  System.out.println("Sort Pass Number "+(i+1)); 
			for(int j=1; j < (n-i); j++)
			{  
			    System.out.println("Comparing "+ array[j-1]+ " and " + array[j]);    
				if(array[j-1] > array[j])
				{   
				    
					temp = array[j-1];  
					array[j-1] = array[j];  
					array[j] = temp;  
				    System.out.println(array[j]  + " is greater than " + array[j-1]);
				    System.out.println("Swapping Elements: New Array After Swap");
					printArray(array);
				}  
 
			}  
		}  
 
	} 
	
	static void printArray(int[] array){
	    
	    for(int i=0; i < array.length; i++)
		{  
			System.out.print(array[i] + " ");  
		} 
	    System.out.println();
	    
	}
}

Output:

---Array BEFORE Bubble Sort---
860 8 200 9 
Sort Pass Number 1
Comparing 860 and 8
860 is greater than 8
Swapping Elements: New Array After Swap
8 860 200 9 
Comparing 860 and 200
860 is greater than 200
Swapping Elements: New Array After Swap
8 200 860 9 
Comparing 860 and 9
860 is greater than 9
Swapping Elements: New Array After Swap
8 200 9 860 
Sort Pass Number 2
Comparing 8 and 200
Comparing 200 and 9
200 is greater than 9
Swapping Elements: New Array After Swap
8 9 200 860 
Sort Pass Number 3
Comparing 8 and 9
Sort Pass Number 4
---Array AFTER Bubble Sort---
8 9 200 860
  
//BubbleSort Using BufferedReader:

import java.io.*;
public class BSort 
{
 
public static void Sort(int a[])
{ 
int n=a.length,i,j,p,temp;
for (i = 0;i < n-1; i++) 
{ 
 
for (j=0; j<n-i-1; j++)
{ 
if(a[j+1]<a[j])
{temp=a[j+1];
a[j+1]=a[j];
a[j]=temp;}
 
} 
 
} 
}
public static void printarray(int a[])
{
for(int i=0; i < a.length; i++)
{
 
System.out.print(a[i]+" ");
}
 
}
public static void main(String[] args) throws IOException
{
 
int n,i;
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
 
System.out.println("enter N: ");
n=Integer.parseInt(b.readLine());
int a[] = new int[n]; 
System.out.println("enter "+n+" elements ");
for(i= 0; i< n; i++)
 
a[i] = Integer.parseInt(b.readLine());
 
System.out.println("elements in array ");
printarray(a);
Sort(a);
System.out.println("\nelements after sorting");
printarray(a);
 
}
}
Output:
*********
enter N: 
3
enter 3 elements 
32
11
10
elements in array 
32 11 10 
elements after sorting
10 11 32



