package entidades;

import entidades.Incidente;
import entidades.Tecnico;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-03T23:57:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Rrhh.class)
public class Rrhh_ { 

    public static volatile SingularAttribute<Rrhh, Date> fechaCierre;
    public static volatile SingularAttribute<Rrhh, Boolean> estado;
    public static volatile SingularAttribute<Rrhh, Date> fechaInicio;
    public static volatile SingularAttribute<Rrhh, Incidente> incidente;
    public static volatile SingularAttribute<Rrhh, Integer> id;
    public static volatile SingularAttribute<Rrhh, Tecnico> tecnico;
    public static volatile SingularAttribute<Rrhh, String> operador;

}