public class Ksiazka implements Publikacja{
    String tittle;
    String author;
    Integer numberOfPages;

    public Ksiazka(String tittle, String author, Integer numberOfPages){
        this.author = author;
        this.tittle = tittle;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        String string = "| " + author +" | " + tittle + " | " + numberOfPages + " |";
        return string;
    }
}
