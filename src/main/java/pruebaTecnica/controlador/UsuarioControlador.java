package pruebaTecnica.controlador;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pruebaTecnica.dto.Usuario;
import pruebaTecnica.servicio.UsuarioServicio;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    // Constructor para la inyección de dependencias
    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de usuarios")
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioServicio.getUsuarios();
    }
}
