public class KsiazkaZObwoluta implements Publikacja{
    Publikacja ksiazka;

    public KsiazkaZObwoluta(Publikacja ksiazka) throws KsiazkaException {
        if( ksiazka instanceof  KsiazkaZObwoluta)
            throw  new KsiazkaException("Ksiazka moze miec jedna obwolute");
        if( !(ksiazka instanceof  KsiążkaZOkładkaTwarda) )
            throw  new KsiazkaException("Ksiazka musi miec twarda okladke by miec obwolute");

        this.ksiazka = ksiazka;
    }

    @Override
    public String toString() {
        String string = ksiazka.toString() + " Okładka z obwoluta | ";
        return string;
    }
}
