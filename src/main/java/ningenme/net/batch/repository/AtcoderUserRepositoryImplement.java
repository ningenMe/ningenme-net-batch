package ningenme.net.batch.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ningenme.net.batch.domain.AtcoderUserDomain;
import ningenme.net.batch.mybatis.AtcoderUserMapper;

@Repository
public class AtcoderUserRepositoryImplement implements AtcoderUserRepositoryInterface {

    private final SqlSessionTemplate sqlSessionTemplate;
    public AtcoderUserRepositoryImplement(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<AtcoderUserDomain> select(String atcoderId) {
        List<AtcoderUserDomain> atcoderUserDomains = this.sqlSessionTemplate.getMapper(AtcoderUserMapper.class).select(atcoderId);
        return atcoderUserDomains;
    }

    @Override
    public List<AtcoderUserDomain> select() {
        return select(null);
    }

    @Override
    public void update(AtcoderUserDomain atcoderUserDomain){
        this.sqlSessionTemplate.getMapper(AtcoderUserMapper.class).update(atcoderUserDomain);
    }
}