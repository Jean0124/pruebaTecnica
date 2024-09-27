package pruebaTecnica.controlador;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaTecnica.dto.PalindromoEntrada;
import pruebaTecnica.dto.PalindromoSalida;
import pruebaTecnica.servicio.PalindromoServicio;

@RestController
@RequestMapping("/api")
public class PalindromoControlador {

    private final PalindromoServicio palindromoServicio;

    // Inyección de dependencias a través del constructor
    public PalindromoControlador(PalindromoServicio palindromoServicio) {
        this.palindromoServicio = palindromoServicio;
    }

    @Operation(
            summary = "Obtiene el palíndromo ingresado",
            description = "Devuelve el número de caracteres, si la cadena es un palíndromo y si tiene caracteres especiales"
    )
    @PostMapping("/palindromo")
    public ResponseEntity<PalindromoSalida> palindromo (@RequestBody PalindromoEntrada entrada){

        // Llamamos al servicio para procesar el palíndromo
        PalindromoSalida salida = palindromoServicio.palindromo(entrada);

        // Devolvemos la respuesta con un estado HTTP 200 (OK)
        return ResponseEntity.ok(salida);
    }
}

