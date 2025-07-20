package com.pachu.FirstJob.Job.JobServiceimpl;

import com.pachu.FirstJob.Job.Job;
import com.pachu.FirstJob.Job.JobRepository;
import com.pachu.FirstJob.Job.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJob_ById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJod_Byid(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJobByid(Long id, Job updated_job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updated_job.getTitle());
            job.setLocation(updated_job.getLocation());
            job.setDescription(updated_job.getDescription());
            job.setMin_salary(updated_job.getMin_salary());
            job.setMax_salary(updated_job.getMax_salary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
