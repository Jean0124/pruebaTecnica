package pruebaTecnica.servicio;

import org.springframework.stereotype.Service;
import pruebaTecnica.dto.PalindromoEntrada;
import pruebaTecnica.dto.PalindromoSalida;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PalindromoServicio {

    public PalindromoSalida palindromo (PalindromoEntrada entrada){

        // Obtiene la cadena desde la entrada
        String cadena = entrada.getPalindromo();

        // Calcula la longitud de la cadena
        int lengthCadena = cadena.length();

        // Verifica si la cadena es un palíndromo
        boolean isPalindromo = new StringBuilder( cadena).reverse().toString().equals(cadena);

        // Contar los caracteres especiales (no alfanuméricos)
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(cadena);
        int numeroCaracteresEspeciales = 0;

        // Contar cada coincidencia del patrón de caracteres especiales
        while (matcher.find()){
            numeroCaracteresEspeciales ++;
        }

        // Crea el objeto de salida con los resultados
        PalindromoSalida salida = new PalindromoSalida();
        salida.setLengthCadena(lengthCadena);
        salida.setPalindromo(isPalindromo);
        salida.setNumeroCaracteresEspeciales(numeroCaracteresEspeciales);

        return salida;

    }
}
