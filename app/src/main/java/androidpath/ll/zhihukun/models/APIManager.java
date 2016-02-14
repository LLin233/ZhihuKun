package androidpath.ll.zhihukun.models;

import java.util.List;

import androidpath.ll.zhihukun.Constants;
import androidpath.ll.zhihukun.interfaces.APIService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Le on 2016/1/28.
 */
public class APIManager {
    private final APIService mAPIService;

    public APIManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mAPIService = retrofit.create(APIService.class);
    }

    public Observable<List<Story>> getStoriesList() {
        return mAPIService.getStories()
                .map(Stories::getStories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}