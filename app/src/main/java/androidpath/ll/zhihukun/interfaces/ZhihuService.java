package androidpath.ll.zhihukun.interfaces;

import androidpath.ll.zhihukun.models.Stories;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Le on 2015/11/2.
 */
public interface ZhihuService {
    //http://news-at.zhihu.com/api/4/news/latest
    @GET("/api/4/news/latest")
    Call<Stories> listStories();
}
