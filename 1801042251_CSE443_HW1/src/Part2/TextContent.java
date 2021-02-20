package Part2;

public class TextContent implements Content {
    private String content;
    private String contentType;

    public TextContent(){}

    public TextContent(String content) {
        this.contentType = "text";
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

