/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Cliente;
import entidades.Tecnico;


public class ControladoraPersistencia {
    
    ClienteJpaController cliJpa=new ClienteJpaController();
    AsignarEJpaController asiJpa=new AsignarEJpaController();
    ContratoJpaController contraJpa=new ContratoJpaController();
    EspecialidadJpaController espeJpa=new EspecialidadJpaController();
    IncidenteJpaController inciJpa=new IncidenteJpaController();
    RrhhJpaController rrhJpa=new RrhhJpaController();
    ServicioJpaController serviJpa=new ServicioJpaController();
    TecnicoJpaController tecJpa=new TecnicoJpaController();

    public void crearCliente(Cliente cli) {
        cliJpa.create(cli);
    }

    public void crearTecnico(Tecnico tec) {
        tecJpa.create(tec);
    }
    
}
