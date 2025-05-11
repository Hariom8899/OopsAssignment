package RealLifeMiniChallenge;

import java.util.*;
import java.util.stream.Collectors;

class Job {
    private String name;
    private String status;

    // Constructor
    public Job(String name, String status) {
        this.name = name;
        this.status = status;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}

public class q55_BatchJobSimulator {

    // Method to return the names of failed jobs in uppercase, sorted alphabetically
    public static List<String> getFailedJobsInUppercase(List<Job> jobs) {
        return jobs.stream()
                .filter(job -> "failed".equalsIgnoreCase(job.getStatus()))  // Filter failed jobs
                .map(job -> job.getName().toUpperCase())  // Convert job names to uppercase
                .sorted()  // Sort job names alphabetically
                .collect(Collectors.toList());  // Collect the result into a List
    }

    public static void main(String[] args) {
        // Sample list of jobs with name and status
        List<Job> jobs = Arrays.asList(
                new Job("Job1", "completed"),
                new Job("Job2", "failed"),
                new Job("Job3", "failed"),
                new Job("Job4", "completed"),
                new Job("Job5", "failed")
        );

        // Get the names of failed jobs in uppercase and sorted alphabetically
        List<String> failedJobNames = getFailedJobsInUppercase(jobs);

        // Output the result
        System.out.println("Failed Jobs (Uppercase and Sorted): " + failedJobNames);
    }
}

