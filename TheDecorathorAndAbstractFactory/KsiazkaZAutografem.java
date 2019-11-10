public class KsiazkaZAutografem implements Publikacja{

    Publikacja ksiazka;
    String dedykacja;
    public KsiazkaZAutografem(Publikacja ksiazka, String dedykacja) throws KsiazkaException {
        if( ksiazka instanceof  KsiazkaZAutografem)
            throw  new KsiazkaException("Ksiazka moze miec jeden autograf");
        this.ksiazka = ksiazka;
        this.dedykacja = dedykacja;
    }

    @Override
    public String toString() {
        String string = ksiazka.toString() + " " + dedykacja + " |";
        return string;
    }
}
