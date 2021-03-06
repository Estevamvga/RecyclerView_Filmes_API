package br.edu.edu.appfilmelist.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class  FilmesResult {

    @Json(name= "results")
    private final List<FilmesResponse> resultadoFilmes;

    public FilmesResult(List<FilmesResponse> resultadoFilmes) {
        this.resultadoFilmes = resultadoFilmes;
    }

    public List<FilmesResponse> getResultadoFilmes() {

        return resultadoFilmes;
    }
}
