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
        
        //cargar cliente 
        //para cargar otro cliente modificar el dni
        Cliente cli=new Cliente( 3,2,  "facundo", "nn","chaco", 50000,"facundo@gmail.com");
        control.crearCliente(cli) ;
        
//        Tecnico tec=new Tecnico(12, "Jose", "Perez");
//        control.crearTecnico(tec);
//        
    }
    
}
