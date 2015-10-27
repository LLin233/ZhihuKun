package androidpath.ll.zhihukun;

import java.util.List;

/**
 * Created by Le on 2015/10/26.
 */
public class story {

    /**
     * {
     * images: [
     * "http://pic2.zhimg.com/6464ad6eaf375f3e9ac26aabf2497841.jpg"
     * ],
     * type: 0,
     * id: 7352339,
     * ga_prefix: "102712",
     * title: "听起来有点复杂：美国选民并不直接选总统，而是选总统候选人"
     * }
     * <p/>
     * Story {
     * images : url,
     * type : int,
     * id: string,
     * ga_prefix: string,
     * title: string
     * }
     */
    private int id;
    private String title;
    private List<String> images;
    private int type;

    public int getId() {
        return id;
    }

    public story setId(int id) {
        this.id = id;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public story setImages(List<String> images) {
        this.images = images;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public story setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getType() {
        return type;
    }

    public story setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Story {" +
                "id=" + id +
                ", title='" + title + '\'' +
                /*", ga_prefix='" + ga_prefix + '\'' +*/
                ", images=" + images +
                ", type=" + type +
                '}';
    }


}
