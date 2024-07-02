package raj.animesh.themovieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import raj.animesh.themovieapp.R;
import raj.animesh.themovieapp.serviceapi.MovieApiService;
import raj.animesh.themovieapp.serviceapi.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    // provides clean API interface to viewmodel
    // to load and fetch data

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData< List<Movie> > mutableLiveData = new MutableLiveData<>();

    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLIvedata(){

        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService
                .getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null){

                    movies = (ArrayList<Movie>) result.getResults();

                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });

        return mutableLiveData;
    }

}
