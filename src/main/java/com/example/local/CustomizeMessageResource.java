package com.example.local;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class CustomizeMessageResource {
	 
    private static MessageSourceAccessor accessor;
    private static final String PATH_PARENT = "classpath:i18n/";
    private static final String SUFFIX = ".properties";
     
    public CustomizeMessageResource() {}
     
    private void initMessageSourceAccessor() throws IOException{
         
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource(PATH_PARENT + "message" + SUFFIX);
        String fileName = resource.getURL().toString();
        int lastIndex = fileName.lastIndexOf(".");
        String baseName = fileName.substring(0,lastIndex);
         
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
reloadableResourceBundleMessageSource.setBasename(baseName);
reloadableResourceBundleMessageSource.setCacheSeconds(1800);
reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
      accessor = new MessageSourceAccessor(reloadableResourceBundleMessageSource);
    }
 
    public String getMessage(String key, String lang) throws IOException {
        initMessageSourceAccessor();
        Locale locale = new Locale("en", "US");
         if (lang!=null&&!lang.isEmpty()) {
               locale = new Locale(lang.split("_")[0], lang.split("_")[1]);
         }
         return accessor.getMessage(key, null, "No such Property key", locale);
      }
     
    public String getMessage(String key, String lang, Object... parameters) throws IOException {
        initMessageSourceAccessor();
        Locale locale = new Locale("en", "US");
        if (lang!=null&&!lang.isEmpty()) {
            locale = new Locale(lang.split("_")[0], lang.split("_")[1]);
        }
        return accessor.getMessage(key, parameters, "No such Property key", locale);
    }
}
