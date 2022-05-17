package br.com.zup.edu.nossosistemadereservadesala.sala;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/reserva-sala")
public class ReservaSalaController {

    @Autowired
    private SalaRepository salaRepository;

    @PutMapping("/{id}")
    public ResponseEntity<?> reservaSala(@RequestBody @Valid ReservaSalaRequest reservaSalaRequest,
                                         @PathVariable Long id){
        Sala sala= salaRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));

        if (sala.getStatus().equals(StatusOcupacao.OCUPADO)){
            return ResponseEntity.unprocessableEntity().build();
        }

        sala.reservar(reservaSalaRequest.getReservadoPara());
        
        return ResponseEntity.ok().body(salaRepository.save(sala));
    }
}
