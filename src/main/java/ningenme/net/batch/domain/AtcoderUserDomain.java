package ningenme.net.batch.domain;
import java.io.Serializable;
import java.sql.Timestamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ningenme.net.batch.BatchApplication;

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

    //for scraping
    private final String atcoderUserPageUrlPrefix = "https://atcoder.jp/users/";
    private Document document;
    private Elements element;

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
    public Integer getCurretntRate() {
        return this.currentRate;
    }
    public void setCurrentRate(Integer currentRate) {
        this.currentRate = currentRate;
    }
    public Integer getHighestRate() {
        return this.highestRate;
    }
    public void setHighestRate(Integer highestRate) {
        this.highestRate = highestRate;
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
    public void setAtcoderUserDomainFromAtcoderPage() throws Exception {
        for(int i = 0; i < 2; i++) {
            try{
                this.document = Jsoup.connect(this.atcoderUserPageUrlPrefix+this.atcoderId).get();
                this.element = document.select("table tr");
                setTableElementToDomain();
                Thread.sleep(3000L);
            }
            catch(Exception e) {
                BatchApplication.logger.error(e.toString());
                continue;
            }
            return;
        }
        throw new Exception("e001");
    }
    private void setTableElementToDomain(){
        for(int i = 0; i < element.size(); i++) {
            String key = element.get(i).select("th").text();
            String value = element.get(i).select("td").text();
            System.out.println(key+" : "+value);
            switch(key) {
                case "TopCoder ID":
                    setTopcoderId(value);
                    break;
                case "Codeforces ID":
                    setCodeforcesId(value);
                    break;
                case "Rank":
                    setRank( Integer.valueOf(value.substring(0, value.length()-2)) );
                    break;
                case "Rating":
                    setCurrentRate(Integer.valueOf(value));
                    break;
                case "Highest Rating":
                    setHighestRate(Integer.valueOf(value.split(" ")[0]));
                    break;
            }
        }
    }
    @Override
    public String toString(){
        String ret = "{";
        ret += "atcoderId: "    + this.atcoderId    + ",\n";
        ret += "topcoderId: "   + this.topcoderId   + ",\n";
        ret += "codeforcesId: " + this.codeforcesId + ",\n";
        ret += "rank: "         + this.rank         + ",\n";
        ret += "}";
        return ret;
    }
}