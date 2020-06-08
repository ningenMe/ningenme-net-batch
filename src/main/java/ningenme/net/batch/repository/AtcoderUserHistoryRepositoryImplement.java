package ningenme.net.batch.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ningenme.net.batch.domain.AtcoderUserContestDomain;
import ningenme.net.batch.domain.AtcoderUserHistoryDomain;
import ningenme.net.batch.mybatis.AtcoderUserContestMapper;

@Repository
public class AtcoderUserHistoryRepositoryImplement implements AtcoderUserHistoryRepositoryInterface {

    private final SqlSessionTemplate sqlSessionTemplate;
    public AtcoderUserHistoryRepositoryImplement(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public void update(AtcoderUserHistoryDomain atcoderUserHistoryDomain){
        for(AtcoderUserContestDomain atcoderUserContestDomain : atcoderUserHistoryDomain.getAtcoderUserContestDomains()) {
            try{
                this.sqlSessionTemplate.getMapper(AtcoderUserContestMapper.class).replace(atcoderUserContestDomain);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}