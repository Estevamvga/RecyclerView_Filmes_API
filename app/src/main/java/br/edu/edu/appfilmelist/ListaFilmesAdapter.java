package br.edu.edu.appfilmelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.edu.appfilmelist.data.model.Filme;
import br.edu.edu.appfilmelist.data.network.response.FilmesResponse;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

   private List<FilmesResponse> filmes;

    public ListaFilmesAdapter(List<FilmesResponse> filmes) {
        this.filmes=filmes;
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.textTituloFilme.setText(filmes.get(position).getTituloOriginal());

    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size()> 0) ? filmes.size() : 0 ;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder{

        private final TextView textTituloFilme;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);

            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
        }

    }
}
