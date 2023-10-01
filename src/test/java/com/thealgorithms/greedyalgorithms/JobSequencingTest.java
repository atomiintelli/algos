package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class JobSequencingTest {
    @Test
    public void testJobSequencingWithExampleCase() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        jobs.add(new JobSequencing.Job('a', 2, 100));
        jobs.add(new JobSequencing.Job('b', 1, 19));
        jobs.add(new JobSequencing.Job('c', 2, 27));
        jobs.add(new JobSequencing.Job('d', 1, 25));
        jobs.add(new JobSequencing.Job('e', 3, 15));
        String jobSequence = JobSequencing.findJobSequence(jobs, jobs.size());

        assertEquals("Job Sequence: a -> c -> e -> ", jobSequence);
    }

    @Test
    public void testJobSequencingWithNoJobs() {
        ArrayList<JobSequencing.Job> jobs = new ArrayList<>();
        String jobSequence = JobSequencing.findJobSequence(jobs, jobs.size());

        assertEquals("Job Sequence: ", jobSequence);
    }
}
