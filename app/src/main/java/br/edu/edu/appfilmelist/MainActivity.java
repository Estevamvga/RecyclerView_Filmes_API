package br.edu.edu.appfilmelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import br.edu.edu.appfilmelist.data.model.Filme;
import br.edu.edu.appfilmelist.data.network.ApiService;
import br.edu.edu.appfilmelist.data.network.response.FilmesResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=ae993c59e99db0e4fce8f24b080fede0";
    RecyclerView recyclerFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFilmes = findViewById(R.id.recycler_filmes);

        ApiService.getInstance()
                .obterFilmesPopulares("ae993c59e99db0e4fce8f24b080fede0")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if(response.isSuccessful()){
                             RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                             recyclerFilmes.setLayoutManager(linearLayoutManager);
                             recyclerFilmes.setAdapter(new ListaFilmesAdapter(response.body().getResultadoFilmes()));
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {

                    }
                });
        }

}
