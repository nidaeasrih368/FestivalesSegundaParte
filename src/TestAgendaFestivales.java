 
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class TestAgendaFestivales {
    
    /**
     * C�digo para probar la clase AgendaFestivales
     *
     */
    public static void main(String[] args) {
        AgendaFestivales agenda = new AgendaFestivales();
        
        testCargarAgenda(agenda);
        testFestivalesEnMes(agenda);
        testFestivalesPorEstilo(agenda);
        testCancelarFestivales(agenda);
        
        
    }
    
    
    private static void testCargarAgenda(AgendaFestivales agenda) {
        // FestivalesIO.cargarFestivales(agenda);
        // System.out.println(agenda);
        // System.out.println();
    }
    
    
    private static void testFestivalesEnMes(AgendaFestivales agenda) {
        // System.out.println("Meses y n� festivales en ese mes\n");
        // Mes[] meses = {Mes.FEBRERO, Mes.ABRIL, Mes.MAYO, Mes.JUNIO,
                // Mes.SEPTIEMBRE, Mes.OCTUBRE};
        // for (Mes mes : meses) {
            // System.out.println(mes + ": " + agenda.festivalesEnMes(mes));
            
        // }
        // System.out.println();
    }
    
    
    private static void testFestivalesPorEstilo(AgendaFestivales agenda) {
        // System.out.println("Nombres de festivales agrupados por estilos\n");
        // for (Map.Entry<Estilo, TreeSet<String>> entrada :
                // agenda.festivalesPorEstilo().entrySet()) {
            // System.out.println(entrada.getKey() + " - " + entrada.getValue());
            
        // }
        // System.out.println();
    }
    
    private static void testCancelarFestivales(AgendaFestivales agenda) {
   
        // HashSet<String> lugares = new HashSet<>(Arrays.asList("VITORIA",
                // "BILBAO", "ZARAGOZA"));
        // testCancelarFestivales(agenda, Mes.JUNIO, lugares);
 
        // lugares = new HashSet<>(Arrays.asList("SEVILLA"));
        // testCancelarFestivales(agenda, Mes.MARZO, lugares);
    
        // lugares = new HashSet<>(Arrays.asList("MALLORCA"));
        // testCancelarFestivales(agenda, Mes.DICIEMBRE, lugares);
        
    }

    private static void testCancelarFestivales(AgendaFestivales agenda,
                                               Mes mes,
                                               HashSet<String> lugares) {
        // System.out.println(lugares + " cancela/n su/s festival/es de " + mes +
                // "\n\n");
        // int borrados = agenda.cancelarFestivales(lugares, mes);
        // if (borrados == -1) {
            // System.out.println("No hay programados festivales en " + mes);
        // } else {
            // System.out.println("Cancelados " + borrados + " festival/es");
        // }
        // System.out.println("Despu�s de borrar ....");
        // System.out.println(agenda);
    }
}
