package ningenme.net.batch.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AtcoderUserPageDomain {
    private final String atcoderUserPageUrlPrefix = "https://atcoder.jp/users/";
    private String atcoderId;
    private AtcoderUserDomain atcoderUserDomain;
    private Document document;
    private Elements element;
    public AtcoderUserPageDomain(String atcoderId) {
        this.atcoderId = atcoderId;
        this.atcoderUserDomain = new AtcoderUserDomain(atcoderId);
    }
    public void setAtcoderUserDomain(){
        for(int i = 0; i < 2; i++) {
            try{
                this.document = Jsoup.connect(this.atcoderUserPageUrlPrefix+this.atcoderId).get();
                this.element = document.select("table tr");
                setTableElementToDomain();
                System.out.println(this.atcoderId);
            }
            catch(Exception e) {
                continue;
            }
            break;
        }
    }

    private void setTableElementToDomain(){
        for(int i = 0; i < element.size(); i++) {
            String key = element.get(i).select("th").text();
            String value = element.get(i).select("td").text();
            
            System.out.println("key: " + key);
            System.out.println("val: " + value);
        }
    }
}