package ningenme.net.batch.mybatis;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ningenme.net.batch.domain.AtcoderUserDomain;

@Mapper
public interface AtcoderUserMapper {
    List<AtcoderUserDomain> select(@Param("atcoderId") String atcoderId);
    int update(AtcoderUserDomain atcoderUserDomain);
}