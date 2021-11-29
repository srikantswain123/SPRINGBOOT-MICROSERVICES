package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistentConfig.class,ServiceConfig.class})
public class AppConfig {

}
