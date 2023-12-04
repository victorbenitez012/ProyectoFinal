package entidades;

import entidades.Especialidad;
import entidades.Tecnico;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-03T23:57:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(AsignarE.class)
public class AsignarE_ { 

    public static volatile SingularAttribute<AsignarE, Integer> id;
    public static volatile SingularAttribute<AsignarE, Tecnico> tecnico;
    public static volatile SingularAttribute<AsignarE, String> operador;
    public static volatile SingularAttribute<AsignarE, Especialidad> especialidad;

}