package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ControlerApp.class,PersistentApp.class,ServiceApp.class})
public class ConfigApp {

}
