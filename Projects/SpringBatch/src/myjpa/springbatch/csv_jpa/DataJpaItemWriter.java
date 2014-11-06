package myjpa.springbatch.csv_jpa;

import org.springframework.batch.item.database.*;

public class DataJpaItemWriter extends JpaItemWriter<Data> {
  public DataJpaItemWriter() {
  }
}