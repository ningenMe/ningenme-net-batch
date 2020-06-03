package ningenme.net.batch.domain;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtcoderUserDomain implements Serializable {

    private String  atcoderId;
    private String  topcoderId;
    private String  codeforcesId;
    private String  yukicoderId;
    private Integer rank;
    private String  country;
    private String  affiliation;
    private Integer currentRate;
    private Integer highestRate;
    private Integer ratedMatches;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    public AtcoderUserDomain() {
        this.atcoderId = "";
    }
    public AtcoderUserDomain(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public String getAtcoderId() {
        return this.atcoderId;
    }
    public void setAtcoderId(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public String getTopcoderId() {
        return this.topcoderId;
    }
    public void setTopcoderId(String topcoderId) {
        this.topcoderId = topcoderId;
    }
    public String getCodeforcesId() {
        return this.codeforcesId;
    }
    public void setCodeforcesId(String codeforcesId) {
        this.codeforcesId = codeforcesId;
    }

    public Integer getRank() {
        return this.rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public Timestamp getCreatedTime() {
        return this.createdTime;
    }
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
    public Timestamp getUpdatedTime() {
        return this.updatedTime;
    }
    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
    @Override
    public String toString(){
        String ret = "{";
        ret += "atcoderId: "    + this.atcoderId    + ",\n";
        ret += "topcoderId: "   + this.topcoderId   + ",\n";
        ret += "codeforcesId: " + this.codeforcesId + ",\n";
        ret += "}";
        return ret;
    }
}