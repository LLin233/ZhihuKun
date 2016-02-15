package androidpath.ll.zhihukun.interfaces;


import androidpath.ll.zhihukun.models.Stories;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Le on 2015/11/2.
 */
public interface APIService {
    //http://news-at.zhihu.com/api/4/news/latest
    @GET("/api/4/news/latest")
    Observable<Stories> getStories();
}
