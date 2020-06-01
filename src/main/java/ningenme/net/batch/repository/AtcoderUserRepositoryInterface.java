package ningenme.net.batch.repository;

import java.util.List;

import ningenme.net.batch.domain.AtcoderUserDomain;

public interface AtcoderUserRepositoryInterface {
    List<AtcoderUserDomain> get();
}