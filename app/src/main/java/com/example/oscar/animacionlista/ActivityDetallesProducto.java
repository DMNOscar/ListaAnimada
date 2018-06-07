package com.example.oscar.animacionlista;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActivityDetallesProducto extends AppCompatActivity {

    private static final String EXTRA_POSITION = "com.example.oscar.animacionlista.POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto_);

        int position = getIntent().getIntExtra(EXTRA_POSITION, -1);
        setupViews(position);

        Window window = getWindow();
        Transition transition = TransitionInflater.from(this)
                                .inflateTransition(R.transition.transicion_detalles);
        window.setEnterTransition(transition);



    }



    private void setupViews(int position) {
        TextView nombre = (TextView) findViewById(R.id.detallesNombre);
        TextView precio = (TextView) findViewById(R.id.detallesPrecio);
        TextView descripcion = (TextView) findViewById(R.id.destallesDescripcion);
        ImageView image = (ImageView) findViewById(R.id.detallesImagen);

        ModeloArticulo detallesArticulo = Articulos.getArticuloPossicion(position);
        nombre.setText(detallesArticulo.getNombreProducto());
        precio.setText(detallesArticulo.getPrecioProducto());
        descripcion.setText(detallesArticulo.getModeloProducto());
        Glide.with(this).load(detallesArticulo.getImagenProduto()).into(image);
    }

    public static void launch(Activity context, int position, View sharedView) {
        Intent intent = new Intent(context, ActivityDetallesProducto.class);
        intent.putExtra(EXTRA_POSITION, position);

            ActivityOptions abrirActivity = ActivityOptions.makeSceneTransitionAnimation(context, sharedView, sharedView.getTransitionName());
            context.startActivity(intent, abrirActivity.toBundle());

    }


}
