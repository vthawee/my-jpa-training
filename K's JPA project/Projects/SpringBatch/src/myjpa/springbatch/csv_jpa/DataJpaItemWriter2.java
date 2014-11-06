package myjpa.springbatch.csv_jpa;

import java.util.*;
import javax.persistence.*;
import org.springframework.batch.item.*;
import org.springframework.orm.jpa.*;

public class DataJpaItemWriter2 implements ItemWriter<Data> {

    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void write(List<? extends Data> items) {
        EntityManager em
                = EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerFactory);

        System.out.println("Items: " + items);

        if (!items.isEmpty()) {
            for (Data item : items) {
                if (!em.contains(item)) {
                    em.merge(item);
                }
            }
        }

        em.flush();
    }
}
