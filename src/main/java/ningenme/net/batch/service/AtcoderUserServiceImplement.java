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
    public void updateAtcoderUser() {
        //ユーザーリストを取得
        List<AtcoderUserDomain> atcoderUserDomains = atcoderUserRepositoryInterface.get(null);
        //ユーザごとに情報を取得
        for (AtcoderUserDomain atcoderUserDomain : atcoderUserDomains) {
            System.out.println(atcoderUserDomain.getAtcoderId());            
        }
    } 
}