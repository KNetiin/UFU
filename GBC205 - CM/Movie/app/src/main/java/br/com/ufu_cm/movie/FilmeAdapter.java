package br.com.ufu_cm.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmeAdapter extends ArrayAdapter<Filme>
{
    private final Context context;
    private final ArrayList<Filme> elementos;

    public FilmeAdapter(Context context, ArrayList<Filme> elementos)
    {
        super(context, R.layout.list_line, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View consertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_line, parent, false);

        ImageView imagemFilme = (ImageView) rowView.findViewById(R.id.filmeImagem);
        TextView nomeFilme = (TextView) rowView.findViewById(R.id.filmeNome);
        TextView sinopseFilme = (TextView) rowView.findViewById(R.id.filmeSinopse);

        imagemFilme.setImageResource(elementos.get(position).getImagem());
        nomeFilme.setText(elementos.get(position).getNome());
        sinopseFilme.setText(elementos.get(position).getSinopse());

        return rowView;
    }
}
