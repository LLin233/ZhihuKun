package androidpath.ll.zhihukun.models;

import java.util.List;

/**
 * Created by Le on 2015/10/26.
 */
public class Story {

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
     *
     * Story {
     * images : url,
     * type : int,
     * id: string,
     * ga_prefix: string,
     * title: string
     * }
     */

    private String title;
    private String id;
    private String[] images;

    @Override
    public String toString() {
        return  id + "; " + title + "; " + images[0] ;
    }
}
