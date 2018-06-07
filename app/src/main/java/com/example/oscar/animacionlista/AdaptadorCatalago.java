package com.example.oscar.animacionlista;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by Oscar on 07/06/2018.
 */

public class AdaptadorCatalago extends RecyclerView.Adapter<AdaptadorCatalago.ArticuloViewHolder> implements ItemClickListener {


    private final Context context;
    private List<ModeloArticulo> items;

    public AdaptadorCatalago(Context context, List<ModeloArticulo> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ArticuloViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_articulo, viewGroup, false);
        return new ArticuloViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ArticuloViewHolder viewHolder, int position) {

        // Item procesado actualmente
        ModeloArticulo articuloItem = items.get(position);

        viewHolder.nombreProducto.setText(articuloItem.getNombreProducto());
        viewHolder.precioProducto.setText(articuloItem.getPrecioProducto());
        viewHolder.marcaProducto.setText(articuloItem.getMarcaProducto());
        viewHolder.modeloProducto.setText(articuloItem.getModeloProducto());
        //viewHolder.btnAgregarCarrito.(articuloItem.getNombreProducto());

        // Cargar imagen
        Glide.with(context)
                .load(articuloItem.getImagenProduto())
                .into(viewHolder.imgProducto);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemClick(View view, int position) {

        // Imagen a compartir entre transiciones
        View sharedImage = view.findViewById(R.id.cardImagenProducto);
        ActivityDetallesProducto.launch((Activity) context, position, sharedImage);

    }

    /**
     * View holder para reciclar elementos
     */
    public static class ArticuloViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Views para un curso
        public final ImageView imgProducto;
        public final TextView nombreProducto;
        public final TextView precioProducto;
        public final TextView marcaProducto;
        public final TextView modeloProducto;
        public final Button btnAgregarCarrito;

        // Interfaz de comunicación
        public ItemClickListener listener;

        public ArticuloViewHolder(View view, ItemClickListener listener) {
            super(view);

            imgProducto=view.findViewById(R.id.cardImagenProducto);
            nombreProducto =view.findViewById(R.id.cardTxtTituloProducto);
            precioProducto=view.findViewById(R.id.cardTxtPrecioProducto);
            marcaProducto=view.findViewById(R.id.cardTxtMarcaProducto);
            modeloProducto=view.findViewById(R.id.cardTxtModeloProducto);
            btnAgregarCarrito=view.findViewById(R.id.btnAgregarCarrito);

            view.setOnClickListener(this);

            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
}

    interface ItemClickListener {
        void onItemClick(View view, int position);
    }