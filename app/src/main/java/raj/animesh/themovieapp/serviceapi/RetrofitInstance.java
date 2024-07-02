package raj.animesh.themovieapp.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    /*
    The retrofit library is used for making Http requests to web services or APIs.
    The retrofit instance class is a crucial component of retrofit that acts as a
    central configuration point for defining how Http requests and responses should
    be handled.
    It provides settings like base URL, converters and other configurations
    necessary for making API requests.
     */

    // simply manager hai ye

    private static Retrofit retrofit = null;
    private static String  BASE_URL = "https://api.themoviedb.org/3/";

    public static MovieApiService getService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieApiService.class);

    }


}
