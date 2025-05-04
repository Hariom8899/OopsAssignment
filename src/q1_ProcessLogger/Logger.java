package q1_ProcessLogger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Logger {

    public enum LogLevel { INFO, WARN, ERROR }

    private final BlockingQueue<LogEntry> logQueue = new LinkedBlockingQueue<>();
    private final AtomicBoolean isRunning = new AtomicBoolean(true);
    private final Thread workerThread;
    private final boolean writeToFile;
    private final File outputFile;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public Logger(boolean writeToFile, String filePath) {
        this.writeToFile = writeToFile;
        this.outputFile = writeToFile ? new File(filePath) : null;

        this.workerThread = new Thread(this::processLogs);
        this.workerThread.start();
    }

    public void log(String message) {
        log(LogLevel.INFO, message);
    }

    public void log(LogLevel level, String message) {
        if (isRunning.get()) {
            logQueue.offer(new LogEntry(level, message, System.currentTimeMillis()));
        }
    }

    private void processLogs() {
        List<LogEntry> buffer = new ArrayList<>();

        while (isRunning.get() || !logQueue.isEmpty()) {
            try {
                LogEntry entry = logQueue.poll(5, TimeUnit.SECONDS);
                if (entry != null) {
                    buffer.add(entry);
                    logQueue.drainTo(buffer);  // drain the rest of the queue quickly
                    flush(buffer);
                    buffer.clear();
                } else {
                    flush(buffer);
                    buffer.clear();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Final flush
        try {
            flush(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void flush(List<LogEntry> buffer) throws IOException {
        if (buffer.isEmpty()) return;

        StringBuilder output = new StringBuilder();
        for (LogEntry entry : buffer) {
            String timestamp = dateFormat.format(new Date(entry.timestamp));
            output.append(String.format("[%s] [%s] %s\n", timestamp, entry.level, entry.message));
        }

        if (writeToFile && outputFile != null) {
            try (FileWriter writer = new FileWriter(outputFile, true)) {
                writer.write(output.toString());
            }
        } else {
            System.out.print(output);
        }
    }

    public void shutdown() {
        isRunning.set(false);
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static class LogEntry {
        final LogLevel level;
        final String message;
        final long timestamp;

        LogEntry(LogLevel level, String message, long timestamp) {
            this.level = level;
            this.message = message;
            this.timestamp = timestamp;
        }
    }

    // Test Method
    public static void main(String[] args) {
        Logger logger = new Logger(false, "logs.txt"); // Change to true for file output

        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    logger.log(Logger.LogLevel.INFO, "Thread " + threadId + " - Message " + j);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logger.shutdown();
        System.out.println("Logging completed.");
    }
}

