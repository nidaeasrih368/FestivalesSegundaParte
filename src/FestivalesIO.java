

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * La clase contiene méodos estáticos que permiten
 * cargar la agenda de festivales leyendo los datos desde
 * un fichero
 */
public class FestivalesIO {

    
    public static void cargarFestivales(AgendaFestivales agenda) {
        Scanner sc = null;
        try {
            sc = new Scanner(FestivalesIO.class.
                    getResourceAsStream("/festivales.csv"));
            while (sc.hasNextLine()) {
                String lineaFestival = sc.nextLine();
                Festival festival = parsearLinea(lineaFestival);
                agenda.addFestival(festival);
                
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        
    }

    /**
     * se parsea la línea extrayendo sus datos y creando y
     * devolviendo un objeto Festival
     * @param lineaFestival los datos de un festival
     * @return el festival creado
     */
    public static Festival parsearLinea(String lineaFestival) {
        Festival nuevoFestival;
        String[] lineaLimpia = lineaFestival.trim().split(":");

        String nombre = capitalizarNombre(lineaLimpia[0].trim());
        String lugar = lineaLimpia[1].trim().toUpperCase();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaInicio = LocalDate.parse(lineaLimpia[2].trim(), formatter);

        int duracion = Integer.parseInt(lineaLimpia[3].trim());

        HashSet<Estilo> estilosMusica = new HashSet<>();
        for (int i = 4; i < lineaLimpia.length; i++) {
            String estiloNombre = lineaLimpia[i].trim().toUpperCase();
            Estilo estilo = Estilo.valueOf(estiloNombre.toUpperCase());
            estilosMusica.add(estilo);
        }
        Festival festivall = new Festival(nombre, lugar, fechaInicio, duracion, estilosMusica);
        return festivall;
    }

    private static String capitalizarNombre(String nombre) {
        String[] palabras = nombre.split("\\s");
        StringBuilder capitalizarStr = new StringBuilder();

        for (String palabra : palabras) {
            String primeraLetra = palabra.substring(0, 1);
            String restoLetras = palabra.substring(1);
            capitalizarStr.append(primeraLetra.toUpperCase()).append(restoLetras.toLowerCase()).append(" ");
        }
        return capitalizarStr.toString().trim();
    }
}
