import java.util.*;


/**
 * Esta clase guarda una agenda con los festivales programados
 * en una serie de meses
 * <p>
 * La agenda guardalos festivales en una colecci�n map
 * La clave del map es el mes (un enumerado festivales.modelo.Mes)
 * Cada mes tiene asociados en una colecci�n ArrayList
 * los festivales  de ese mes
 * <p>
 * Solo aparecen los meses que incluyen alg�n festival
 * <p>
 * Las claves se recuperan en orden alfab�ico
 */
public class AgendaFestivales {
    private TreeMap<Mes, ArrayList<Festival>> agenda;

    public AgendaFestivales() {
        this.agenda = new TreeMap<>();
    }

    /**
     * a�ade un nuevo festival a la agenda
     * <p>
     * Si la clave (el mes en el que se celebra el festival)
     * no existe en la agenda se crear� una nueva entrada
     * con dicha clave y la colecci�n formada por ese �nico festival
     * <p>
     * Si la clave (el mes) ya existe se a�ade el nuevo festival
     * a la lista de festivales que ya existe ese ms
     * insert�ndolo de forma que quede ordenado por nombre de festival.
     * Para este segundo caso usa el m�todo de ayuda
     * obtenerPosicionDeInsercion()
     */
    public void addFestival(Festival festival) {

        Mes mes = festival.getMes();
        if (!agenda.containsKey(mes)){
            ArrayList<Festival> festi = new ArrayList<>();
            festi.add(festival);
            agenda.put(mes, festi);
        } else {
            ArrayList<Festival> festi = agenda.get(mes);
            int insercionOrden = obtenerPosicionDeInsercion(festi, festival);
            festi.add(insercionOrden,festival);
        }
    }

    /**
     * @param festivales una lista de festivales
     * @param festival
     * @return la posici�n en la que deber�a ir el nuevo festival
     * de forma que la lista quedase ordenada por nombre
     */
    private int obtenerPosicionDeInsercion(ArrayList<Festival> festivales, Festival festival) {

        int pos = 0;
        for (Festival festivall : festivales) {
            if (festivall.getNombre().compareTo(festival.getNombre()) > 0){
                break;
            }
            pos++;
        }

        return pos;

    }

    /**
     * Representaci�n textual del festival
     * De forma eficiente
     * Usa el conjunto de entradas para recorrer el map
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nFestivales\n");

        for (Map.Entry<Mes, ArrayList<Festival>> entry : agenda.entrySet()) {
            Mes mes = entry.getKey();
            ArrayList<Festival> festivalMes = entry.getValue();
            int num = festivalMes.size();

            sb.append("\n" + mes + "  (" + festivalesEnMes(mes) + " festival" + "/es)\n");
            for (Festival festival : entry.getValue()) {
                sb.append(festival + "\n");
            }
        }

        return sb.toString();
    }

    /**
     * @param mes el mes a considerar
     * @return la cantidad de festivales que hay en ese mes
     * Si el mes no existe se devuelve -1
     */
    public int festivalesEnMes(Mes mes) {
        if (agenda.containsKey(mes)){
            ArrayList<Festival> festivalM = agenda.get(mes);
            return festivalM.size();
        }else {
            return -1;
        }
    }

    /**
     * Se trata de agrupar todos los festivales de la agenda
     * por estilo.
     * Cada estilo que aparece en la agenda tiene asociada una colecci�n
     * que es el conjunto de nombres de festivales que pertenecen a ese estilo
     * Importa el orden de los nombres en el conjunto
     * <p>
     * Identifica el tipo exacto del valor de retorno
     */
    public TreeMap<Estilo, TreeSet<String>> festivalesPorEstilo() {
        TreeMap<Estilo, TreeSet<String>> festEstilos = new TreeMap<>();
        for (Mes mes : agenda.keySet()) {
            ArrayList<Festival> festivalMes = agenda.get(mes);

            for (Festival festival : festivalMes) {
                Set<Estilo> estilos = festival.getEstilos();

                for (Estilo estilo : estilos) {
                    if (!festEstilos.containsKey(estilo)){
                        TreeSet<String> nombres = new TreeSet<>();
                        nombres.add(festival.getNombre());
                        festEstilos.put(estilo, nombres);
                    } else {
                        festEstilos.get(estilo).add(festival.getNombre());
                    }

                }
            }
        }


        return festEstilos;
    }

    /**
     * Se cancelan todos los festivales organizados en alguno de los
     * lugares que indica el conjunto en el mes indicado. Los festivales
     * concluidos o que no empezados no se tienen en cuenta
     * Hay que borrarlos de la agenda
     * Si el mes no existe se devuelve -1
     * <p>
     * Si al borrar de un mes los festivales el mes queda con 0 festivales
     * se borra la entrada completa del map
     */
    public int cancelarFestivales(HashSet<String> lugares, Mes mes) {
        int borrados = 0;
        if (!agenda.containsKey(mes)) {
            return -1;
        }

        //

        return borrados;
    }
}
