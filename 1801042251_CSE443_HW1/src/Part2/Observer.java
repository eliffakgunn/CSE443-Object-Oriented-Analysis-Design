package Part2;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    private List<Content> contentList = new ArrayList();
    private String name;;

    public Observer(String name){
        this.name = name;
    }

    public void update(Observable obs, Object arg){
        Website website = (Website) obs;
        System.out.println(name +" -  New " + website.getContent().getContentType() + " content: "+website.getContent().getContent());
    }

    public List<Content> getContentList(){
        return contentList;
    }
}
