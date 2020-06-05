package ningenme.net.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class BatchApplication {

	public static final Logger logger = LoggerFactory.getLogger(BatchApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
}
