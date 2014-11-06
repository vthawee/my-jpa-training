package myjpa.springbatch.csv_jpa;

import java.util.*;
import org.springframework.batch.item.file.*;
import org.springframework.batch.item.file.mapping.*;
import org.springframework.batch.item.file.transform.*;
import org.springframework.core.io.*;
import org.springframework.validation.*;

public class DataCsvItemReader extends FlatFileItemReader<Data> {

    public DataCsvItemReader() {
        setResource(new ClassPathResource("myjpa/springbatch/csv_jpa/data.csv"));
        setLineMapper(new DefaultLineMapper<Data>() {
            // This block will be executed before constructor because this anonymous class does not declare constructor.
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    // This block will be executed before constructor because this anonymous class does not declare constructor.
                    {
                        setNames(new String[]{"date", "name", "value", "digit"});
                    }
                });

                setLinesToSkip(1);

                // We can use BeanWrapperFieldSetMapper to map fields with String  type
                setFieldSetMapper(new FieldSetMapper<Data>() {
                    @Override
                    public Data mapFieldSet(FieldSet fs) throws BindException {
                        Data ret = new Data();

                        ret.setName(fs.readString("name"));
                        ret.setValue(fs.readInt("value"));
                        ret.setDigit(fs.readDouble("digit"));
                        ret.setDate(getDate(fs.readString("date")));

                        return ret;
                    }

                    private Date getDate(String date) {
                        int pos0 = date.indexOf('/');
                        int pos1 = date.indexOf('/', pos0 + 1);
                        int month = Integer.parseInt(date.substring(0, pos0)) - 1;
                        int day = Integer.parseInt(date.substring(pos0 + 1, pos1));
                        int year = Integer.parseInt(date.substring(pos1 + 1)) + 100;

                        return new Date(year, month, day);
                    }
                });
            }
        });
    }
}
