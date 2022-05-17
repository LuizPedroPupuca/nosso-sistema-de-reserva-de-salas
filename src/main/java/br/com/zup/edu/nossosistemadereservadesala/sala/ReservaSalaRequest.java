package br.com.zup.edu.nossosistemadereservadesala.sala;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ReservaSalaRequest {

    @NotBlank
    private String reservadoPara;

    public ReservaSalaRequest() {
    }

    public ReservaSalaRequest(String reservadoPara) {
        this.reservadoPara = reservadoPara;
    }



    public String getReservadoPara() {
        return reservadoPara;
    }
}
