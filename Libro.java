import java.util.Scanner;

public class Libro implements Comparable<Libro> {
    static Scanner sc= new Scanner(System.in);
    private String titulo;
    private String autor;
    private String isbn;
    private int edicion;

    public Libro(String titulo, String autor, String isbn, int edicion){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.edicion = edicion;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public int getEdicion() {
        return edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public int compareTo(Libro libro) {
        int resultado = this.isbn.compareTo(libro.getIsbn());
        if(resultado == 0){ //titulos igual
            int resultado2 = this.titulo.compareTo(libro.getTitulo());
            if (resultado2  == 0){
                int resultado3 = this.autor.compareTo(libro.getAutor());
                if( resultado3 == 0){
                    if(this.edicion == libro.getEdicion()){
                        return 0;
                    }
                }
                if(resultado3 > 0){
                    return 1;
                }else{
                    return -1;
                }
            }
            if(resultado2 > 0){
                return 1;
            }else{
                return -1;
            }
        }
        return resultado;
    }

    @Override
    public String toString(){
        return (this.isbn +"\t"+ this.titulo + "\t" + this.autor + "\t" + this.edicion);
    }


}
