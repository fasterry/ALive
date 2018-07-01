package com.zcl.alive.ui.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zcl.alive.R;

import io.realm.log.LogLevel;

public class TestActivity extends AppCompatActivity {
    private static String TAG ="TestActivty";
    private TextView test ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Logger.t(this.getClass().getName()).d("chenglin log");
    }
      /*  test = (TextView)findViewById(R.id.test);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        service.getTopMovie(0,10).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Moviess>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Moviess movie) {
                Log.d(TAG, "onNext: " + movie.getTitle());
                List<Subjects> list = movie.getSubjects();
                for (Subjects sub : list) {
                    Toast.makeText(getApplicationContext(),sub.getId()+"",Toast.LENGTH_LONG).show();
                    test.setText(sub.getTitle());
                    Log.d(TAG, "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Over!");
            }
        });;

       
    }
}
interface ApiService {
    @GET("top250")
    Observable<Moviess> getTopMovie(@Query("start") int start, @Query("count") int count);
}

class Moviess {
    private String title;
    private List<Subjects> subjects;


    public String getTitle() {
        return title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }
}

class Subjects {
    private String title, year, id;

    public Subjects(String title, String year, String id) {
        this.title = title;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }*/

}