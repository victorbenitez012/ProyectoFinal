package entidades;

import entidades.Cliente;
import entidades.Contrato;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-04T20:44:15", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Incidente.class)
public class Incidente_ { 

    public static volatile SingularAttribute<Incidente, String> descripcion;
    public static volatile SingularAttribute<Incidente, Cliente> cliente;
    public static volatile SingularAttribute<Incidente, Date> fechaCierre;
    public static volatile SingularAttribute<Incidente, String> tipo;
    public static volatile SingularAttribute<Incidente, Contrato> contrato;
    public static volatile SingularAttribute<Incidente, Integer> id;
    public static volatile SingularAttribute<Incidente, String> operador;

}