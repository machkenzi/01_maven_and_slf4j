package logger;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program implements CommandLineRunner {
    private LoggingService loggingService;

    public Program(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(Program.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.loggingService.LogMessage("TestService");
    }
}
