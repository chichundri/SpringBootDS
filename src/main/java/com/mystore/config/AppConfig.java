package com.mystore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mystore.dao.RepositoryMarker;
import com.mystore.service.ServiceMarker;

@Configuration
@Import({ PersistenceConfig.class })
@ComponentScan(basePackageClasses = { ServiceMarker.class, RepositoryMarker.class })
public class AppConfig {

}