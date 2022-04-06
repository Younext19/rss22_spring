package fr.univrouen.rss22.model;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestRSS {


    public String loadFileXML() {
        org.springframework.core.io.Resource resource;
        resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            return e.getMessage();
        }

    }

}
