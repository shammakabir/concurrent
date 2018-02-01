import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PMerge{
  public static void parallelMerge(int[] A, int[] B, int[]C, int numThreads){

    ExecutorService es = Executors.newFixedThreadPool(numThreads);
    int numElements = C.length;
    int partition = (numElements)/numThreads;
    //TODO figure out way to partition A and B based on numThreads

    if(numElements%2==1){ //if num of elements is odd

    }

    for(int i = 0; i<numThreads;i++) {

      //assign partitions of A and B to each thread
      //pass indexes as parameters to new merge object
      //pass that new object to thread

    }


  }
  public static void main(String[] args) {
    int[] x = {0, 5, 9, 11, 17};
    int[] y = {1, 2, 6, 8};
    int[] c = new int[9];
    parallelMerge(x,y,c,4);
    System.out.println(c);
  }
}
class merge implements Runnable{
  private int[] a;
  private int[] c;
  private int p1;
  private int p2;

  public merge(int[] a, int[] c, int p1, int p2){
    this.a = a;
    this.c = c;
    this.p1 = p1;
    this.p2 = p2;
  }

  public void run(){

    //finds correct index to place element in array c
    //use binary search

  }


}

