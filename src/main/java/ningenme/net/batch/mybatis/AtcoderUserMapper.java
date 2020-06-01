package ningenme.net.batch.mybatis;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ningenme.net.batch.domain.AtcoderUserDomain;
import ningenme.net.batch.domain.AtcoderUserListDomain;

@Mapper
public interface AtcoderUserMapper {
    List<AtcoderUserDomain> selectAll(String atcoderId);
    AtcoderUserDomain select(String atcoderId);
}