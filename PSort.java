

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class PSort {


  public static void parallelSort(int[] arr, int low, int high) {

    // TODO: Implement your parallel sort function
    int processors = Runtime.getRuntime().availableProcessors();
    sort result = new sort(arr, low, high);

    ForkJoinPool pool = new ForkJoinPool(processors);

    pool.invoke(result);

  }

  public static void main(String[] args) {
    int[] x = {9, 2, 4, 7, 3, 7, 10};
    System.out.println(Arrays.toString(x));

    int low = 0;
    int high = x.length - 1;


    parallelSort(x, low, high);
    System.out.println(Arrays.toString(x));
  }
}



class sort extends RecursiveAction {
  int a[];
  int low;
  int high;

  public sort(int[] a, int low, int high) {
    this.a = a;
    this.low = low;
    this.high = high;
  }

  @Override
  public void compute() {
    if (low < high) {
    	int pi = partition(a, low, high);
        sort left = new sort(a, low, pi - 1);
        sort right = new sort(a, pi + 1, high);
        left.fork();
        right.compute();
        left.join();
    } 
  }
  public static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1); 
    for (int j = low; j < high; j++) {
   
      if (arr[j] <= pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }
}



