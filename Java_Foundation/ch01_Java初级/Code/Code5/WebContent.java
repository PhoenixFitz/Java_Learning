package com.kl.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContent {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;

    //key-->servlet-name value-->servlet-class
    private Map<String,String> entityMap = new HashMap<String,String>();
    //key-->url-pattern  value-->servlet-name
    private Map<String,String> mappingMap = new HashMap<String,String>();
    public WebContent(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        //将entity的List 传化为对应的map
        for(Entity entity:entities){
            entityMap.put(entity.getName(),entity.getClz());
        }

        //将map的List 传化为对应的map
        for(Mapping mapping:mappings){
            for(String pattern:mapping.getPatterns()){
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }
    //通过URL的路径找到对应的class
    public String getClz(String pattern){
        String name =mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
