package Part2;

public class AudioContent implements Content {
    private String content;
    private String contentType;

    public AudioContent(){}

    public AudioContent(String content) {
        this.contentType = "audio";
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

