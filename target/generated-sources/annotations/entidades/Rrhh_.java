package entidades;

import entidades.Cliente;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-03T21:22:31", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Rrhh.class)
public class Rrhh_ { 

    public static volatile SingularAttribute<Rrhh, Date> fechaCierre;
    public static volatile SingularAttribute<Rrhh, Cliente> Tecnico;
    public static volatile SingularAttribute<Rrhh, Boolean> estado;
    public static volatile SingularAttribute<Rrhh, Date> fechaInicio;
    public static volatile SingularAttribute<Rrhh, Cliente> Incidente;
    public static volatile SingularAttribute<Rrhh, Integer> id;
    public static volatile SingularAttribute<Rrhh, String> operador;

}