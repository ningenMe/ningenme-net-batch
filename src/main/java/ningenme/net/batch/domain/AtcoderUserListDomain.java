package ningenme.net.batch.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtcoderUserListDomain {
    private List<AtcoderUserDomain> atcoderUserDomains;
    public AtcoderUserListDomain(){
        this.atcoderUserDomains = new ArrayList<>();
    }
    public AtcoderUserListDomain(List<AtcoderUserDomain> atcoderUserDomains) {
        this.atcoderUserDomains = atcoderUserDomains;
    }
    public void setAtcoderUserDomains(List<AtcoderUserDomain> atcoderUserDomains) {
        this.atcoderUserDomains = atcoderUserDomains;
    }
    public List<AtcoderUserDomain> getAtcoderUserDomains() {
        return this.atcoderUserDomains;
    }
}