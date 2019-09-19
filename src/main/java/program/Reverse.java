package Program;

public class Reverse{
    private final long id;
    private final String content;

    public Reverse(long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }
}