package AdvanceLevel;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class q13_LogFileMonitor {
    public static void main(String[] args) {
        Path logFilePath = Paths.get("/Users/htiwari/IdeaProjects/IO/myLog.log"); // Replace with your log file path

        try (BufferedReader reader = Files.newBufferedReader(logFilePath, StandardCharsets.UTF_8)) {
            // Move the reader to the end of the file
            reader.skip(Files.size(logFilePath));

            WatchService watchService = FileSystems.getDefault().newWatchService();
            logFilePath.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        Path modifiedFile = (Path) event.context();
                        if (modifiedFile.equals(logFilePath.getFileName())) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.contains("ERROR")) {
                                    System.out.println(line);
                                }
                            }
                        }
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

