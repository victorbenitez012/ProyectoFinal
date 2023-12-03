/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import entidades.ControladoraLogica;
import entidades.Cliente;
import entidades.Tecnico;
import persistencia.ControladoraPersistencia;
public class Cargar {
    
    public static void main(String[] arg){
        
          ControladoraPersistencia controlPersis=new ControladoraPersistencia();
        
        ControladoraLogica control=new ControladoraLogica();
        Cliente cli=new Cliente( 15,30,  "nombre", "apellido","direccion","email");
        control.crearCliente(cli) ;
        
        Tecnico tec=new Tecnico(12, "nombre", "apellido");
        control.crearTecnico(tec);
        
    }
    
}
