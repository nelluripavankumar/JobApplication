package com.pachu.FirstJob.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJob_ById(Long id);

    boolean deleteJod_Byid(Long id);

    boolean updateJobByid(Long id,Job updated_job);
}
