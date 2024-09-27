package pruebaTecnica.dto;


import lombok.Data;

@Data
public class Usuario {

        private Long id;
        private String name;
        private String username;
        private String email;

        // Constructor
        public Usuario(Long id, String name, String username, String email) {
                this.id = id;
                this.name = name;
                this.username = username;
                this.email = email;
        }
}
