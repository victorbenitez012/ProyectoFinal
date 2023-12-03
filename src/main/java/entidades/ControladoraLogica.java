/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import entidades.Cliente;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();
    
    public void crearCliente(Cliente cli){
        controlPersis.crearCliente(cli);
    }
    
    public void crearTecnico(Tecnico tec){
        controlPersis.crearTecnico(tec);
    }
    
    
}
