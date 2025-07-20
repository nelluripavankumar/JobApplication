package com.pachu.FirstJob.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface JobRepository extends JpaRepository<Job,Long> {
}
