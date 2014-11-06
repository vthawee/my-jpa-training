package myjpa.springbatch.jpa_xml;

import java.util.*;
import org.springframework.batch.item.xml.*;
import org.springframework.core.io.*;
import org.springframework.oxm.xstream.*;

public class UserXmlItemWriter extends StaxEventItemWriter {

    public UserXmlItemWriter() {
        setResource(new FileSystemResource("src/myjpa/springbatch/jpa_xml/user.xml"));

        setRootTagName("users");

        setMarshaller(new XStreamMarshaller() {
            {
                Map<String, String> aliases = new HashMap<>();

                aliases.put("user", "myjpa.springbatch.jpa_xml.User");

                setAliases(aliases);
            }
        });
    }
}
