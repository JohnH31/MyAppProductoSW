package com.jherrera.myappproductosw.complementos;

public class ProductoVO {
    
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String categoriaProducto;
    private int presioProducto;

    public ProductoVO() {
    }

    public ProductoVO(int idProducto, String nombreProducto, String descripcionProducto, String categoriaProducto, int presioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.categoriaProducto = categoriaProducto;
        this.presioProducto = presioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getPresioProducto() {
        return presioProducto;
    }

    public void setPresioProducto(int presioProducto) {
        this.presioProducto = presioProducto;
    }
}
