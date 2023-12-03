/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbAsignarE")
public class AsignarE implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String operador;
    
    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "id")
    private Cliente Tecnico;
    
    @ManyToOne
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "id")
    private Cliente Especialidad;

    public AsignarE() {
    }

    public AsignarE(int id, String operador, Cliente Tecnico, Cliente Especialidad) {
        this.id = id;
        this.operador = operador;
        this.Tecnico = Tecnico;
        this.Especialidad = Especialidad;
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

    public Cliente getTecnico() {
        return Tecnico;
    }

    public void setTecnico(Cliente Tecnico) {
        this.Tecnico = Tecnico;
    }

    public Cliente getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(Cliente Especialidad) {
        this.Especialidad = Especialidad;
    }
    
    
}
