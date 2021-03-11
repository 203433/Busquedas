import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class cMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        int decision, posicion;

        ArrayList<Libro> listaLibros = new ArrayList<>();

        listaLibros.add(new Libro("100 Anios de soledad", "Gabriel Garcia Marques", "1234567890234", 2002));
        listaLibros.add(new Libro("Bajo la misma estrella", "John Green", "0929283818121", 2010));
        listaLibros.add(new Libro("Lo que fue de ella", "Gayle Forman", "1029283345231", 2002));
        listaLibros.add(new Libro("Desde mi cielo", "Alice Sebold", "5643218654348", 2002));
        listaLibros.add(new Libro("Viaje al centro de la tierra", "Julio Verne", "9878768565434", 2002));
        listaLibros.add(new Libro("El anticristo", "Friedrich Nietzsche", "3425769807864", 2002));
        listaLibros.add(new Libro("La metamosfosis", "Franz Kafka", "2938947583741", 2002));
        listaLibros.add(new Libro("La naranja mecanica", "Anthony Burgess", "1902837458692", 2002));

        Search busqueda = new Search();

        //System.out.println(listaLibros.toString());

        do{
            
            System.out.println("Elija la accion que desee: ");
            System.out.println("1.-Agregar libro");
            System.out.println("2.-Remover");
            System.out.println("3.-Listar ");
            System.out.println("4.-Buscar libro");
            System.out.println("5.-Salir");
            decision = sc.nextInt();

            switch (decision) {
                case 1:
                    Libro libro = registrarLibro();
                    listaLibros.add(libro);
                break;
                case 2:
                    Libro libro2 = registrarLibro();
                    Collections.sort(listaLibros);
                    posicion = busqueda.binaria(listaLibros, libro2, false);
                    if(posicion >= 0){
                        //System.out.println("Posicion: " + posicion);
                        listaLibros.remove(posicion);
                        System.out.println("El libro ha sido borrado con exito");
                    }else{
                        System.out.println("Libro no encontrado");
                    }
                    
                break;
                case 3:
                    System.out.println("Elementos ordenados");
                    Collections.sort(listaLibros);
                    System.out.println("ISBN \t\tTitulo \tAutor \tEdicion");
                    for(int i = 0; i < listaLibros.size(); i++){
                        System.out.println(listaLibros.get(i).toString());
                    }
                break;
                case 4:
                    Libro libro3 = registrarLibro();
                    Collections.sort(listaLibros);
                    posicion = busqueda.binaria(listaLibros, libro3, false);
                    if(posicion >= 0){
                        System.out.println("Libro encontrado en la posicion: " + posicion);
                    }else{
                        System.out.println("Libro no encontrado");
                    }
                    
                break;    

            }
        
        }while(decision != 5);
        
    }
    public static Libro registrarLibro()
    {
        String autor;
        String titulo;
        String isbn;
        int edicion;
        sc.nextLine();
        System.out.println("Ingresar autor");
        autor = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingrese el titulo del libro");
        titulo = sc.nextLine();
        do {
            System.out.println("Ingrese el isbn");
            isbn = sc.next();
        } while (isbn.length() != 13);
        System.out.println("Ingrese la edicion");
        edicion = sc.nextInt();
        Libro libro = new Libro(titulo, autor, isbn, edicion);
        return libro;
    }
}


