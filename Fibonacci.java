import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by gydoy on 1/31/2018.
 */
public class Fibonacci extends RecursiveTask<Integer> {

    public static void main(String[] args) {
        int times = 5;
        int n = 5;
        while (--times > 0) {
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Integer> task = new Fibonacci(n);
            long start = System.nanoTime();
            System.out.println(String.format("fib(%d) = %d", n, pool.invoke(task)));
            System.out.println(String.format("%f [msec]", (System.nanoTime() - start) / 1000000.0));
        }
    }

    private final int n;

    public Fibonacci(int n) { this.n = n; }

    public Integer compute() {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}
