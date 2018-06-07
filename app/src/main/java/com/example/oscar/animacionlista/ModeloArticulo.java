package com.example.oscar.animacionlista;

/**
 * Created by Oscar on 07/06/2018.
 */

public class ModeloArticulo {

    private  int imagenProduto;
    private  String nombreProducto;
    private  String precioProducto;
    private  String marcaProducto;
    private  String modeloProducto;


    public ModeloArticulo(int imagenProduto, String nombreProducto, String precioProducto, String marcaProducto, String modeloProducto) {
        this.imagenProduto = imagenProduto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.marcaProducto = marcaProducto;
        this.modeloProducto = modeloProducto;
    }


    public int getImagenProduto() {
        return imagenProduto;
    }

    public void setImagenProduto(int imagenProduto) {
        this.imagenProduto = imagenProduto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(String modeloProducto) {
        this.modeloProducto = modeloProducto;
    }
}
