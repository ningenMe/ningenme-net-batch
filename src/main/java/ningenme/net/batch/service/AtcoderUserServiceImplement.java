package ningenme.net.batch.service;
import org.springframework.stereotype.Service;

@Service
public class AtcoderUserServiceImplement implements AtcoderUserServiceInterface {
    @Override
    public void updateHistory() {
        System.out.println("hoge");
    } 
}