package com.zhuojh;

import com.zhuojh.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by snow on 2016/2/16.
 */
@SpringBootApplication
public class Application {

//    private final Logger log = LoggerFactory.getLogger(Application.class);
//
//    @Inject
//    private Environment env;
//
//    @PostConstruct
//    public void initApplication() throws IOException {
//        if (env.getActiveProfiles().length == 0) {
//            log.warn("No Spring profile configured, running with default configuration");
//        } else {
//            log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
//        }
//    }
    public static void main(String[] args){
//        SpringApplication app = new SpringApplication(Application.class);
//        app.setShowBanner(true);
//        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
//
//        // Check if the selected profile has been set as argument.
//        // if not the development profile will be added
//        addDefaultProfile(app, source);
//        app.run(args);
        SpringApplication.run(Application.class, args);
    }

//    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
//        if (!source.containsProperty("spring.profiles.active")) {
//            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
//        }
//    }
}
