package ningenme.net.batch.service;
import java.util.List;

import org.springframework.stereotype.Service;

import ningenme.net.batch.domain.AtcoderUserDomain;
import ningenme.net.batch.repository.AtcoderUserRepositoryInterface;

@Service
public class AtcoderUserServiceImplement implements AtcoderUserServiceInterface {

    private final AtcoderUserRepositoryInterface atcoderUserRepositoryInterface;
    public AtcoderUserServiceImplement(AtcoderUserRepositoryInterface atcoderUserRepositoryInterface) {
        this.atcoderUserRepositoryInterface = atcoderUserRepositoryInterface;
    }

    @Override
    public void updateHistory() {
        //ユーザーリストを取得
        List<AtcoderUserDomain> atcoderUserDomains = atcoderUserRepositoryInterface.get();
        atcoderUserDomains.add(new AtcoderUserDomain("hoge"));
        atcoderUserDomains.add(new AtcoderUserDomain("fuga"));
        for (AtcoderUserDomain atcoderUserDomain : atcoderUserDomains) {
            System.out.println(atcoderUserDomain.getAtcoderId());            
        }
    } 
}