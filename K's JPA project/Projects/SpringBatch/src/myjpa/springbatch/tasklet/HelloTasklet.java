package myjpa.springbatch.tasklet;

import org.springframework.batch.core.*;
import org.springframework.batch.core.scope.context.*;
import org.springframework.batch.core.step.tasklet.*;
import org.springframework.batch.repeat.*;

public class HelloTasklet implements Tasklet {
  private int count = 0;
  
  @Override
  public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
    System.out.println("Hello Spring Batch");
    
    count++;
    
    if (count < 10) {
      return RepeatStatus.CONTINUABLE;
    } else {
      return RepeatStatus.FINISHED;
    }
  }
}