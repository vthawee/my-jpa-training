package myjpa.springbatch.tasklet;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

/*
 *  JobRepository controls all business.
 *  1. JobLauncher runs one Job.
 *  2. Job has many steps.
 *  3. Step can be Tasklet
 *              or ItemReader + ItemProcessor + ItemWriter
 */
public class Main {
  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
                              "myjpa/springbatch/tasklet/config.xml");
    JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);
		Job job = ctx.getBean("helloJob", Job.class);
    
    jobLauncher.run(job, new JobParameters());
  }
}