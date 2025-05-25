import java.util.HashMap;
import java.util.Map;

public class RegistroReproducciones {
    
    private Map<Usuario, Map<Contenido, Integer>> registros = new HashMap<>();

    public void registrarReproduccion(Usuario usuario, Contenido contenido) {
        if (usuario == null || contenido == null) return;

        registros
            .computeIfAbsent(usuario, u -> new HashMap<>())
            .merge(contenido, 1, Integer::sum);
    }

    public void mostrarReproducciones() {
        for (Map.Entry<Usuario, Map<Contenido, Integer>> entry : registros.entrySet()) {
            Usuario usuario = entry.getKey();
            System.out.println("👤 Usuario: " + usuario.getNombre());
            for (Map.Entry<Contenido, Integer> subEntry : entry.getValue().entrySet()) {
                System.out.println("   ▶ " + subEntry.getKey().getTitulo() + ": " + subEntry.getValue() + " reproducciones");
            }
        }
    }
}
