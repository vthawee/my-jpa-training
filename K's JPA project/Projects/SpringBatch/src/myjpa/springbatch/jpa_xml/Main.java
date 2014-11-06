package myjpa.springbatch.jpa_xml;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "myjpa/springbatch/jpa_xml/config.xml");
        JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);
        JobParameters params = new JobParametersBuilder().addString("id", "3").toJobParameters();
        Job job = ctx.getBean("jpaXmlJob", Job.class);

        jobLauncher.run(job, params);
    }
}
