package com.ues.dsi.sistemaadopcionbackend.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MASCOTAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascota_secuencia")
    @SequenceGenerator(name="mascota_secuencia", sequenceName="MASCOTAS_ID_seq", allocationSize=1)
    @Column(name = "ID")
    private Long idMascota;

    @NotNull(message = "El nombre de la mascota no puede quedar vacio")
    @Size(max = 20, message = "El nombre de la mascota no puede exceder los 20 caracteres")
    @Column(name = "NOMBRE", length = 20, nullable = false)
    private String nombre;

    @NotBlank(message = "La fecha de nacimiento no puede quedar vacía")
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    @NotNull(message = "La especie de la mascota debe especificarse")
    @Column(name = "ESPECIE", length = 20, nullable = false)
    private String especie;

    @NotNull(message = "El género de la mascota debe especificarse")
    @Column(name = "GENERO", length = 1, nullable = false)
    private String genero;

    @NotNull(message = "La raza de la mascota debe especificarse")
    @Column(name = "RAZA", length = 20, nullable = false)
    private String raza;

    @NotNull(message = "El color de la mascota debe especificarse")
    @Column(name = "COLOR", length = 20, nullable = false)
    private String color;

    @NotNull(message = "Se debe especificar el estado de salud de la mascota")
    @Size(max = 250, message = "El detalle de el estado de salud ha excedido los carácteres permitidos (250)")
    @Column(name = "ESTADO_SALUD", length = 250, nullable = false)
    private String estadoSalud;

    @Size(max = 250, message = "La descripcion ha excedido los carácteres permitidos (250)")
    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;

}