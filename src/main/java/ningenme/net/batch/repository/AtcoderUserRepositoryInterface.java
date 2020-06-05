package ningenme.net.batch.repository;

import java.util.List;

import ningenme.net.batch.domain.AtcoderUserDomain;

public interface AtcoderUserRepositoryInterface {
    List<AtcoderUserDomain> select(String atcoderId);
    List<AtcoderUserDomain> select();
    void update(AtcoderUserDomain atcoderUserDomain);
}