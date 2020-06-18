package ningenme.net.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import ningenme.net.batch.kick.JobKick;


@SpringBootApplication
@EnableScheduling
public class BatchApplication {

	public static final Logger logger = LoggerFactory.getLogger(BatchApplication.class);
	public static JobKick jobKick;
	BatchApplication(JobKick jobKick) {
		this.jobKick = jobKick;
	}	
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);

		if(args.length > 0) {
			jobKick.batchKick(args[0]);
		}

		System.exit(0);
	}
}
