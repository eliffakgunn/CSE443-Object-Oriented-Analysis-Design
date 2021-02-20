package Part2;

public class PhotoContent implements Content {
    private String content;
    private String contentType;

    public PhotoContent(){}

    public PhotoContent(String content) {
        this.contentType = "photo";
        this.content=content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String getContentType(){
        return this.contentType;
    }
}

