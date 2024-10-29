import java.util.*;
 
public class MergeSort 
{
  public static void main(String[] args) 
  {
    Integer[] a = { 2, 6, 3, 5, 1 };
     
    mergeSort(a);
     
    System.out.println(Arrays.toString(a));
  }
 
  @SuppressWarnings("rawtypes") 
  public static Comparable[] mergeSort(Comparable[] list) 
  {
        if (list.length <= 1) {
            return list;
        }
         
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
         
        mergeSort(first);
        mergeSort(second);
         
        merge(first, second, list);
        return list;
    }
     
  @SuppressWarnings({ "rawtypes", "unchecked" }) 
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) 
  {
        int iFirst = 0;
         
        int iSecond = 0;
         
        int iMerged = 0;
         
        while (iFirst < first.length && iSecond < second.length) 
        {
            if (first[iFirst].compareTo(second[iSecond]) < 0) 
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}

Output:
[1, 2, 3, 5, 6]

class MergeSort2 {

  void merge(int arr[], int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p
    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = M[j];
        j++;
      }
      k++;
    }

   
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = M[j];
      j++;
      k++;
    }
  }

  void mergeSort(int arr[], int l, int r) {
    if (l < r) {

      int m = (l + r) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      merge(arr, l, m, r);
    }
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) {
    int arr[] = { 6, 5, 12, 10, 9, 1 };

    MergeSort2 ob = new MergeSort2();
    ob.mergeSort(arr, 0, arr.length - 1);

    System.out.println("Sorted array:");
    printArray(arr);
  }
}
Output:
Sorted array:
1 5 6 9 10 12 

 

