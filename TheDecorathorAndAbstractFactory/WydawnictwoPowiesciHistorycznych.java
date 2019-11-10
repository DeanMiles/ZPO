public class WydawnictwoPowiesciHistorycznych extends Wydawnictwo {
    static String authorOfBook = " ";
    public WydawnictwoPowiesciHistorycznych(String nameOfAuthor){
        this.authorOfBook = nameOfAuthor;
    }

    public static Ksiazka createBook(String tittle, Integer pages) {
        Ksiazka ksiazka = new PowiescHistoryczna(authorOfBook, tittle, pages);
        return ksiazka;
    }
}
