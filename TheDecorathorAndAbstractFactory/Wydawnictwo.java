public abstract class Wydawnictwo{
    static String authorOfBook = " ";


    public static Wydawnictwo getInstance(String author) {
        authorOfBook = author;
        if(author.equals("Józef Ignacy Kraszewskki")){
            return new WydawnictwoPowiesciHistorycznych(author);
        }
        else if(author.equals("Remigiusz Mróz")){
            return new WydawnictwoThrillerow();
        }
        else if(author.equals("Julian Tuwim")){
            return new WydawnictwoPoematow();
        }
        return null;
    }
    public static Ksiazka createBook(String tittle, Integer pages) {
        Ksiazka ksiazka = new PowiescHistoryczna(authorOfBook, tittle, pages);
        return ksiazka;
    }
}
