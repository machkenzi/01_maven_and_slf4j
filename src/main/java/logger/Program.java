package logger;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program {
    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(Program.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
