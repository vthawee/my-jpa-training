package myjpa.springbatch.jpa_xml;

import org.springframework.batch.item.database.*;

public class UserJpaItemReader extends JpaPagingItemReader<User> {
  public UserJpaItemReader() {
  }
}