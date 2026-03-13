package pattern.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

public class Document implements Cloneable{
    private String content;
    private List<String> images;

    public Document(String content, List<String> images) {
        this.content = content;
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public Object clone() {
        Document clone = null;
        try {
            clone = (Document) super.clone();
            // Deep copy cho images
            clone.images = new ArrayList<>(this.images);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
