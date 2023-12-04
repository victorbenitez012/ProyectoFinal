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
    private Tecnico tecnico;
    
    @ManyToOne
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "id")
    private Especialidad especialidad;

    public AsignarE() {
    }

    public AsignarE(int id, String operador, Tecnico tecnico, Especialidad especialidad) {
        this.id = id;
        this.operador = operador;
        this.tecnico = tecnico;
        this.especialidad = especialidad;
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

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
