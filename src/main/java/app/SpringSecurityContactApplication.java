package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringSecurityContactApplication {

    private static final Logger LOGGER =
            Logger.getLogger(SpringSecurityContactApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityContactApplication.class, args);
        LOGGER.info("APP is running...");
    }

}
