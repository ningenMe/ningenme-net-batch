package ningenme.net.batch.mybatis;

import org.apache.ibatis.annotations.Mapper;

import ningenme.net.batch.domain.AtcoderUserContestDomain;

@Mapper
public interface AtcoderUserContestMapper {
    int replace(AtcoderUserContestDomain atcoderUserContestDomain);
}