package ningenme.net.batch.domain;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtcoderUserContestDomain implements Serializable {

    private String  atcoderId;
    @JsonProperty("IsRated")
    private Boolean isRated;
    @JsonProperty("Place")
    private Integer place;
    @JsonProperty("OldRating")
    private Integer oldRating;
    @JsonProperty("NewRating")
    private Integer newRating;
    @JsonProperty("Performance")
    private Integer performance;
    @JsonProperty("InnerPerformance")
    private Integer innerPerformance;
    @JsonProperty("ContestScreenName")
    private String contestScreenName;
    @JsonProperty("ContestName")
    private String contestName;
    @JsonProperty("ContestNameEn")
    private String contestNameEn;
    @JsonProperty("EndTime")
    private LocalDateTime endTime;
    private String contestType;

    public AtcoderUserContestDomain(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public AtcoderUserContestDomain() {
        this.atcoderId = "";
    }
    public String getAtcoderId() {
        return this.atcoderId;
    }
    public void setAtcoderId(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public Boolean getIsRated() {
        return this.isRated;
    }
    public void setIsRated(Boolean isRated) {
        this.isRated = isRated;
    }
    public Integer getPlace() {
        return this.place;
    }
    public void setPlace(Integer place) {
        this.place = place;
    }
    public Integer getOldRating() {
        return this.oldRating;
    }
    public void setOldRating(Integer oldRating) {
        this.oldRating = oldRating;
    }
    public Integer getNewRating() {
        return this.newRating;
    }
    public void setNewRating(Integer newRating) {
        this.newRating = newRating;
    }
    public Integer getPerformance() {
        return this.performance;
    }
    public void setPerformance(Integer performance) {
        this.performance = performance;
    }
    public Integer getInnerPerformance() {
        return this.innerPerformance;
    }
    public void setInnerPerformance(Integer innerPerformance) {
        this.innerPerformance = innerPerformance;
    }
    public String getContestScreenName() {
        return this.contestScreenName;
    }
    public void setContestScreenName(String contestScreenName) {
        this.contestScreenName = contestScreenName;
    }
    public String getContestName() {
        return this.contestName;
    }
    public void setContestName(String contestName) {
        this.contestName = contestName;
    }
    public String getContestNameEn() {
        return this.contestNameEn;
    }
    public void setContestNameEn(String contestNameEn) {
        this.contestNameEn = contestNameEn;
    }
    public LocalDateTime getEndTime() {
        return this.endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime= endTime;
    }
    public void setEndTime(String endTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        this.endTime= LocalDateTime.parse(endTime, dtf);
    }
    public String getContestType() {
        return this.contestType;
    }
    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

}