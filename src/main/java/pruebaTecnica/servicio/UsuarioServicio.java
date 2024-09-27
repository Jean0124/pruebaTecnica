package pruebaTecnica.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pruebaTecnica.dto.Usuario;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServicio {

    private final RestTemplate restTemplate;

    // Constructor con inyección de RestTemplate
    @Autowired
    public UsuarioServicio(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "usuarios")
    public List<Usuario> getUsuarios(){
        try {
            String url = "https://jsonplaceholder.typicode.com/users";
            // Llamada a la API externa con RestTemplate
            ResponseEntity<Usuario[]> response = restTemplate.getForEntity(url, Usuario[].class);

            // Se convierte el array en una lista
            return Arrays.asList(response.getBody());

        } catch (RestClientException e) {
            // Manejo de excepciones para errores en el consumo de la API
            throw new RuntimeException("Error al consumir el API", e);
        }
    }
}
