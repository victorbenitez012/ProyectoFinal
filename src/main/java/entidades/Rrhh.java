/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tbRrhh")
public class Rrhh implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String operador;
    
    @ManyToOne
    @JoinColumn(name = "idIncidente", referencedColumnName = "id")
    private Cliente Incidente;
    
    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "id")
    private Cliente Tecnico;
    
    @Column
    private Date fechaInicio;
    
    @OneToOne
    @JoinColumn(name = "fechaCierre", referencedColumnName = "fechaCierre")
    private Date fechaCierre;
    
    @Column
    private Boolean estado;

    public Rrhh() {
    }

    public Rrhh(int id, String operador, Cliente Incidente, Cliente Tecnico, Date fechaInicio, Date fechaCierre, Boolean estado) {
        this.id = id;
        this.operador = operador;
        this.Incidente = Incidente;
        this.Tecnico = Tecnico;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Cliente getIncidente() {
        return Incidente;
    }

    public void setIncidente(Cliente Incidente) {
        this.Incidente = Incidente;
    }

    public Cliente getTecnico() {
        return Tecnico;
    }

    public void setTecnico(Cliente Tecnico) {
        this.Tecnico = Tecnico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
