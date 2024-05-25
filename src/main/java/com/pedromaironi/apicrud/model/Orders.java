package com.pedromaironi.apicrud.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orden")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden", nullable = false, unique = true)
    private int id_orden;

    @Column(name = "id_cliente", nullable = false, unique = true)
    private int id_cliente;

    @Column(name = "fecha", nullable = false, length = 1000)
    private LocalDate fecha;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "estado", nullable = false, length = 1000)
    private String estado;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "taxes", nullable = false)
    private Double taxes;

    @Column(name = "pago_envio", nullable = false)
    private Double pago_envio;

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getPago_envio() {
        return pago_envio;
    }

    public void setPago_envio(Double pago_envio) {
        this.pago_envio = pago_envio;
    }
}
