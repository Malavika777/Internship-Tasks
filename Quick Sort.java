import java.util.*;

public class QuickSortExample 
{
  public static void main(String[] args) 
  {
    Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
 
    quickSort( array, 0, array.length - 1 );
 
    System.out.println(Arrays.toString(array));
  }
 
  public static void quickSort(Integer[] arr, int low, int high) 
  {
    if (arr == null || arr.length == 0){
      return;
    }
     
    if (low >= high){
      return;
    }
 
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];
 
    int i = low, j = high;
    while (i <= j) 
    {
      while (arr[i] < pivot) 
      {
        i++;
      }
      while (arr[j] > pivot) 
      {
        j--;
      }
      if (i <= j) 
      {
        swap (arr, i, j);
        i++;
        j--;
      }
    }
    if (low < j){
      quickSort(arr, low, j);
    }
    if (high > i){
      quickSort(arr, i, high);
    }
  }
   
  public static void swap (Integer array[], int x, int y)
    {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
    }
}


Output:
[3, 6, 10, 12, 13, 24, 70, 90]


 
Example2:
import java.util.Arrays;

class QuicksortEx {

  static int partition(int array[], int low, int high) {
    
    int pivot = array[high];
    
    int i = (low - 1);

    
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {

        
        i++;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }

    }

    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return (i + 1);
  }

  static void quickSort(int array[], int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      
      quickSort(array, low, pi - 1);

      quickSort(array, pi + 1, high);
    }
  }
}

class Main {
  public static void main(String args[]) {

    int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

    QuicksortEx.quickSort(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order ");
    System.out.println(Arrays.toString(data));
  }
}


