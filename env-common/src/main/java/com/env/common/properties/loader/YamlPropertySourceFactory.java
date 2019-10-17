package com.env.common.properties.loader;

import com.sun.istack.Nullable;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/29 9:17
 */
public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        Properties propertiesFromYaml = loadYamlIntoProperties(resource);

        String sourceName = name != null ? name : resource.getResource().getFilename();

        return new PropertiesPropertySource(sourceName, propertiesFromYaml);
    }

    private Properties loadYamlIntoProperties(EncodedResource resource) throws FileNotFoundException {
        try {
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();

            factory.setResources(resource.getResource());
            factory.afterPropertiesSet();

            return factory.getObject();
        } catch (IllegalStateException e) {
            Throwable cause = e.getCause();

            if (cause instanceof FileNotFoundException)
                throw (FileNotFoundException) e.getCause();

            throw e;
        }
    }
}
