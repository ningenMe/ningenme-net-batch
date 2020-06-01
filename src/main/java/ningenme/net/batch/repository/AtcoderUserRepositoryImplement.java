package ningenme.net.batch.repository;

import java.util.ArrayList;
import java.util.List;

// import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ningenme.net.batch.domain.AtcoderUserDomain;
import ningenme.net.batch.domain.AtcoderUserListDomain;

@Repository
public class AtcoderUserRepositoryImplement implements AtcoderUserRepositoryInterface {

    // private final SqlSessionTemplate sqlSessionTemplate;
    // public AtcoderUserRepositoryImplement(SqlSessionTemplate sqlSessionTemplate) {
    //     this.sqlSessionTemplate = sqlSessionTemplate;
    // }

    @Override
    public List<AtcoderUserDomain> get() {
        // AtcoderUserListDomain atcoderUserDomains =  this.sqlSessionTemplate.getMapper(AtcoderUserMapper.class).selectAll();
        AtcoderUserListDomain atcoderUserDomains = new AtcoderUserListDomain();
        return atcoderUserDomains.getAtcoderUserDomains();
    }
}