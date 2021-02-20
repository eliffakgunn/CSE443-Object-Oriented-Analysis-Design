package Part2;

import java.util.ArrayList;
import java.util.List;

public class Website implements Observable {
    private List<Observer> observers ;
    Content content;

    public Website() {this.observers=new ArrayList(); }

    @Override
    public void notifyObservers() {
        for(Observer o:this.observers){
            for(Content c: o.getContentList()){
                if(c.getClass() == this.getContent().getClass()) {
                    o.update(this, null);
                    break;
                }
            }
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i=this.observers.indexOf(o);
        if (i>=0)
            this.observers.remove(i);
    }

    public void addContents(Content content) {
        this.content = content;
        notifyObservers();
    }

    public Content getContent() {
        return content;
    }
}
