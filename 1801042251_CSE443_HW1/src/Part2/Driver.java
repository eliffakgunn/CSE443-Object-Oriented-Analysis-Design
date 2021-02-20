package Part2;


public class Driver {
    public static void main(String[] args) {
        Website website = new Website();

        Observer o1 = new Observer("Elif");
        o1.getContentList().add(new TextContent());

        Observer o2 = new Observer("Esra");
        o2.getContentList().add(new PhotoContent());
        o2.getContentList().add(new AudioContent());

        Observer o3 = new Observer("Seda");
        o3.getContentList().add(new PhotoContent());
        o3.getContentList().add(new AudioContent());
        o3.getContentList().add(new TextContent());

        website.addObserver(o1);
        website.addObserver(o2);
        website.addObserver(o3);

        website.addContents(new PhotoContent("Moon"));
        website.addContents(new AudioContent("Evgeny Grinko - Field"));
        website.addContents(new TextContent("Sound of Space"));
    }
}

