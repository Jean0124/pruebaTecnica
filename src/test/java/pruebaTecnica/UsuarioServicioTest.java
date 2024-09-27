package pruebaTecnica;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pruebaTecnica.dto.Usuario;
import pruebaTecnica.servicio.UsuarioServicio;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServicioTest {

    @InjectMocks
    private UsuarioServicio usuarioServicio;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        // Este método se ejecutará antes de cada prueba
    }

    /*
     Prueba el caso donde llegan todos los usuarios de la api
     */
    @Test
    public void getUsuariosExitoso() {
        // Se configura la respuesta
        Usuario[] usuariosArray = {
                new Usuario(),
                new Usuario()
        };
        ResponseEntity<Usuario[]> responseEntity = ResponseEntity.ok(usuariosArray);

        //Mockito del restTemplate
        when(restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Usuario[].class))
                .thenReturn(responseEntity);

        // Se hace la consulta al metodo
        List<Usuario> usuarios = usuarioServicio.getUsuarios();

        // Assert
        Assert.assertNull(usuarios);
    }

    /*
     Prueba el caso donde llegan vacios los datos
     */
    @Test
    public void getUsuariosError() {
        // Mock del restTemplate
        when(restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Usuario[].class))
                .thenThrow(new RuntimeException("Error al consumir el API"));

        // Se hace la consulta al metodo
        RuntimeException thrown = Assert.assertThrows(RuntimeException.class, () -> {
            usuarioServicio.getUsuarios();
        });

        //Validaciones
        Assert.assertEquals("Error al consumir el API", thrown.getMessage());
    }

}


