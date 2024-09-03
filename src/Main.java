import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

//Obtener un sublistado con las películas estrenadas a partir del año 2000, inclusive
//Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg
//Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente

public class Main {
    public static void main(String[] args) {
        // Crear una lista de películas
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));

        //Problema 1
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Problema 1");
        System.out.println(" Obtener un sublistado con las películas estrenadas a partir del año 2000, inclusive ");
        System.out.println("   Por filtro: ");
        peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .forEach(p -> System.out.println("     "+p));
        System.out.println("   Por substream: ");
        List<Pelicula> peliculasSigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());

        for(Pelicula p: peliculasSigloXXI)
        {
            System.out.println("     "+p);
        }
        System.out.println(" ");
        System.out.println(" ");

        //Problema 2
        System.out.println("Problema 2");
        System.out.println(" Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg ");
        String peliculasSteven = peliculas.stream()
                .filter(p -> p.getDirector().equals("Steven Spielberg"))
                .map(p -> p.getTitulo())
                .collect(Collectors.joining(", ", "     Peliculas de Spielberg: ", "     The end."));
        System.out.println(peliculasSteven);
        System.out.println(" ");
        System.out.println(" ");

        //Problema 3
        System.out.println("Problema 3");
        System.out.println(" Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente");
        List<String> nombresPeliculas = peliculas.stream()
                .map(p -> p.getTitulo())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("     "+nombresPeliculas);
    }
}