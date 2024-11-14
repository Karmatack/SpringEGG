package egg.spring.back.Modells;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class FabricaModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idFabrica;

    @NotNull
    @Column(nullable = false)
    private String nombreFabrica;

    // Constructor por defecto
    public FabricaModel() {
    }

    // Constructor con parámetros
    public FabricaModel(String nombreFabrica) {
        this.nombreFabrica = nombreFabrica;
    }

    // Getters y Setters
    public String getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(String idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getNombreFabrica() {
        return nombreFabrica;
    }

    public void setNombreFabrica(String nombreFabrica) {
        this.nombreFabrica = nombreFabrica;
    }
}
