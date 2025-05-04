package q4_ThreadPoolImageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ImageProcessor {

    private static final int NUM_IMAGES = 50;
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Future<String>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= NUM_IMAGES; i++) {
            final int imageId = i;
            Callable<String> task = () -> {
                Thread.sleep(100); // Simulate image processing
                return "Image " + imageId + " processed";
            };
            futures.add(executor.submit(task));
        }

        // Collect and print results in submission order
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        long endTime = System.currentTimeMillis();
        System.out.printf("Total execution time: %d ms\n", (endTime - startTime));
    }
}

