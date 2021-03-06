package br.edu.edu.appfilmelist.data.network;

import br.edu.edu.appfilmelist.data.network.response.FilmesResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

     @GET("movie/popular")
     Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi);

}