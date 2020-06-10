package ningenme.net.batch.kick;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ningenme.net.batch.service.AtcoderUserServiceInterface;

@Component
public class JobKick {

    private final AtcoderUserServiceInterface atcoderUserServiceInterface;
    public JobKick(AtcoderUserServiceInterface atcoderUserServiceInterface) {
        this.atcoderUserServiceInterface = atcoderUserServiceInterface;
    }

    // @Scheduled(fixedDelay = 50000000)
    @Scheduled(cron = "0 0 3 * * 1", zone = "Asia/Tokyo")
    public void updateAtcoderUser() {
        atcoderUserServiceInterface.updateAtcoderUser();
    }
}