package br.com.zup.edu.nossosistemadereservadesala.sala;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.time.LocalDateTime;

import static br.com.zup.edu.nossosistemadereservadesala.sala.StatusOcupacao.*;

@Entity
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

//    @Column(nullable = false)
    private String reservadoPara;

//    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOcupacao status;

//    @Column(nullable = false)
    private LocalDateTime criadoEm;

//    @Column(nullable = false)
    private LocalDateTime atualizadoEm;

    public void reservar(String reservadoPara){
        criadoEm = LocalDateTime.now();
        atualizadoEm = LocalDateTime.now();
        status = OCUPADO;
        this.reservadoPara = reservadoPara;
    }

    @Deprecated
    /**
     * @deprecated construtor para uso
     */
    public Sala() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getReservadoPara() {
        return reservadoPara;
    }

    public StatusOcupacao getStatus() {
        return status;
    }
}
