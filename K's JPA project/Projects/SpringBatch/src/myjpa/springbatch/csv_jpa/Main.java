package myjpa.springbatch.csv_jpa;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class Main {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
                              "myjpa/springbatch/csv_jpa/config.xml");
    JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);
		Job job = ctx.getBean("csvJpaJob", Job.class);
    
    jobLauncher.run(job, new JobParameters());
  }
}