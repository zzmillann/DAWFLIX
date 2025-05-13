import java.util.Comparator;

public class Comparadores {
    public static Comparator<Pelicula> porDuracion = new Comparator<>() {
        public int compare(Pelicula p1, Pelicula p2) {
            return Double.compare(p1.getDuracion(), p2.getDuracion());
        }
    };

    public static Comparator<Pelicula> porAño = new Comparator<>() {
        public int compare(Pelicula p1, Pelicula p2) {
            return Integer.compare(p1.getAño(), p2.getAño());
        }
    };
}