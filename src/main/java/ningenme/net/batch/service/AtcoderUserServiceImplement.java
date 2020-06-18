package ningenme.net.batch.service;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ningenme.net.batch.BatchApplication;
import ningenme.net.batch.domain.AtcoderUserDomain;
import ningenme.net.batch.domain.AtcoderUserHistoryDomain;
import ningenme.net.batch.repository.AtcoderUserHistoryRepositoryInterface;
import ningenme.net.batch.repository.AtcoderUserRepositoryInterface;
import ningenme.net.batch.util.LogCode;

@Service
public class AtcoderUserServiceImplement implements AtcoderUserServiceInterface {

    private final AtcoderUserRepositoryInterface atcoderUserRepositoryInterface;
    private final AtcoderUserHistoryRepositoryInterface atcoderUserHistoryRepositoryInterface;
    public AtcoderUserServiceImplement(
        AtcoderUserRepositoryInterface atcoderUserRepositoryInterface,
        AtcoderUserHistoryRepositoryInterface atcoderUserHistoryRepositoryInterface
    ) {
        this.atcoderUserRepositoryInterface = atcoderUserRepositoryInterface;
        this.atcoderUserHistoryRepositoryInterface =  atcoderUserHistoryRepositoryInterface;
    }

    @Override
    public void updateAtcoderUser() {
        //ユーザーリストを取得
        List<AtcoderUserDomain> atcoderUserDomains = atcoderUserRepositoryInterface.select();
        // List<AtcoderUserDomain> atcoderUserDomains = atcoderUserRepositoryInterface.select("ningenMe");
        
        //ユーザごとに情報を取得
        for (AtcoderUserDomain atcoderUserDomain : atcoderUserDomains) {
            BatchApplication.logger.info(atcoderUserDomain.getAtcoderId() + " information update start");

            //ユーザー情報取得
            try{
                atcoderUserDomain.setAtcoderUserDomainFromAtcoderPage();
            }
            catch(Exception e) {
                //失敗したら論理削除
                atcoderUserDomain.setDeletedTime(new Timestamp(System.currentTimeMillis()));

                BatchApplication.logger.error(LogCode.map.get(e.toString()));
                BatchApplication.logger.info(atcoderUserDomain.getAtcoderId() + " user information get failed");
            }

            //ユーザー情報更新
            try{
                atcoderUserRepositoryInterface.update(atcoderUserDomain);
            }
            catch(Exception e) {
                BatchApplication.logger.error(LogCode.map.get(e.toString()));
                BatchApplication.logger.info(atcoderUserDomain.getAtcoderId() + " user information update failed");
            }

            try{
                // rated historyを取得
                AtcoderUserHistoryDomain atcoderUserHistoryDomain = new AtcoderUserHistoryDomain(atcoderUserDomain.getAtcoderId());
                atcoderUserHistoryDomain.setAtcoderUserContestDomainsFromAtcoderPage();
                //更新
                atcoderUserHistoryRepositoryInterface.update(atcoderUserHistoryDomain);
            }
            catch(Exception e) {
                BatchApplication.logger.error(LogCode.map.get(e.toString()));
                BatchApplication.logger.info(atcoderUserDomain.getAtcoderId() + " history information update failed");
            }

            BatchApplication.logger.info(atcoderUserDomain.getAtcoderId() + " information update end");
        }
    } 
}