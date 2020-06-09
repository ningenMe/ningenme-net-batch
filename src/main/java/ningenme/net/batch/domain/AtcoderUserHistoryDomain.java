package ningenme.net.batch.domain;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtcoderUserHistoryDomain implements Serializable {

    private String  atcoderId;
    private List<AtcoderUserContestDomain> atcoderUserContestDomains;
    static final String urlPrefix = "https://atcoder.jp/users/";
    static final String urlSuffix = "/history/json";

    public AtcoderUserHistoryDomain(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public String getAtcoderId() {
        return this.atcoderId;
    }
    public void setAtcoderId(String atcoderId) {
        this.atcoderId = atcoderId;
    }
    public void setAtcoderUserContestDomainsFromAtcoderPage() {
        try {
			HttpRequest request = HttpRequest.newBuilder(URI.create(AtcoderUserHistoryDomain.urlPrefix+this.atcoderId+AtcoderUserHistoryDomain.urlSuffix)).build();
			BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, bodyHandler);
            ObjectMapper mapper = new ObjectMapper();
            this.atcoderUserContestDomains = mapper.readValue(response.body(),new TypeReference<List<AtcoderUserContestDomain>>(){});
            for (AtcoderUserContestDomain atcoderUserContestDomain : atcoderUserContestDomains) {
                processAtcoderUserContestDomain(atcoderUserContestDomain);
            }
            Thread.sleep(1500L);
		} catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public List<AtcoderUserContestDomain> getAtcoderUserContestDomains(){
        return this.atcoderUserContestDomains;
    }

    //データ加工する内部メソッド
    private void processAtcoderUserContestDomain(AtcoderUserContestDomain atcoderUserContestDomain) {
        atcoderUserContestDomain.setAtcoderId(this.atcoderId);
        //コンテスト英名が空なら和名をset
        if(atcoderUserContestDomain.getContestNameEn().isEmpty()) {
            atcoderUserContestDomain.setContestNameEn(atcoderUserContestDomain.getContestName());
        }

        //コンテスト名を解析してtypeを決定 (ここは一旦雑にABC or AGC or ARCだけ拾う)
        String[] contestNameArray = atcoderUserContestDomain.getContestNameEn().split(" ");
        String contestType = "";
        if(contestNameArray.length >= 3 && contestNameArray[0].equals("AtCoder") && contestNameArray[1].equals("Beginner") && contestNameArray[2].equals("Contest")) {
            contestType = "ABC";
        }
        if(contestNameArray.length >= 3 && contestNameArray[0].equals("AtCoder") && contestNameArray[1].equals("Regular") && contestNameArray[2].equals("Contest")) {
            contestType = "ARC";
        }
        if(contestNameArray.length >= 3 && contestNameArray[0].equals("AtCoder") && contestNameArray[1].equals("Grand") && contestNameArray[2].equals("Contest")) {
            contestType = "AGC";
        }
        atcoderUserContestDomain.setContestType(contestType);
    }
}