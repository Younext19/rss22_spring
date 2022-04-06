package fr.univrouen.rss22.model;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestRSS {

    public Resource loadFileXml(Resource resource){
        resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");
        return resource;
    }


}
