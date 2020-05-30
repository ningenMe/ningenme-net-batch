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

    @Scheduled(fixedRate = 500)
    public void updateHistory() {
        atcoderUserServiceInterface.updateHistory();
    }
}