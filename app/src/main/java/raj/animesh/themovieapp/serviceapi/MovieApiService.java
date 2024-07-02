package raj.animesh.themovieapp.serviceapi;

import raj.animesh.themovieapp.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    /*
    Android app and remote API ke bich mai bridge ke tarah kaam krta hai.

    An retrofit The service interface is a key component
    that defines the structure and behavior of the API requests.
    It acts as a bridge between your Android app and the remote API.
     */

    // specify end point of URL
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key")String apiKey);

}
