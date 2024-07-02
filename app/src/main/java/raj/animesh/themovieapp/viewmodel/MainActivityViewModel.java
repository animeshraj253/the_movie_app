package raj.animesh.themovieapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import raj.animesh.themovieapp.model.Movie;
import raj.animesh.themovieapp.model.MovieRepository;

public class MainActivityViewModel extends AndroidViewModel {


    private MovieRepository movieRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    // getting live data
    public LiveData<List<Movie>> getAllMovies(){
       return movieRepository.getMutableLIvedata();
    }
}
