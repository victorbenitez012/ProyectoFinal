package entidades;

import entidades.Cliente;
import entidades.Servicio;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-12-03T23:57:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, Cliente> cliente;
    public static volatile SingularAttribute<Contrato, Servicio> servicio;
    public static volatile SingularAttribute<Contrato, Integer> id;

}