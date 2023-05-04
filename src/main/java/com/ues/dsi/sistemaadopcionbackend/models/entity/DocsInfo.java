package com.ues.dsi.sistemaadopcionbackend.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "DOCS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocsInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_info_secuencia")
    @SequenceGenerator(name="doc_info_secuencia", sequenceName="DOCS_INFO_ID_seq", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "El tipo de documento no puede quedar vacio")
    @Size(max = 20, message = "El tipo de documento no puede exceder los 20 caracteres")
    @Column(name = "TIPO", length = 20, nullable = false)
    private String tipo;

    @Lob
    @Column(name = "DOCUMENTO", nullable = false)
    private byte[] documento;

    @Size(max = 250, message = "La descripcion de el documento ha excedido los caracteres permitidos (250)")
    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;

}
