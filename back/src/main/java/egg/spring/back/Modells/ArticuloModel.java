package egg.spring.back.Modells;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class ArticuloModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idArticulo;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nroArticulo; // Número autogenerado y correlativo

    @NotNull
    @Column(nullable = false)
    private String nombreArticulo;

    @NotNull
    @Column(nullable = false)
    private String descripcionArticulo;

    @ManyToOne
    @JoinColumn(name = "id_fabrica", nullable = false)
    private FabricaModel fabrica;

    // Constructor por defecto
    public ArticuloModel() {
    }

    // Constructor con parámetros
    public ArticuloModel(String nombreArticulo, String descripcionArticulo, FabricaModel fabrica) {
        this.nombreArticulo = nombreArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.fabrica = fabrica;
    }

    // Getters y Setters
    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getNroArticulo() {
        return nroArticulo;
    }

    public void setNroArticulo(Integer nroArticulo) {
        this.nroArticulo = nroArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public FabricaModel getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaModel fabrica) {
        this.fabrica = fabrica;
    }
}
