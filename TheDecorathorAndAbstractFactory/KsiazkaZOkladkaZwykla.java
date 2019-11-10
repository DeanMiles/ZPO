public class KsiazkaZOkladkaZwykla implements Publikacja{
    Publikacja ksiazka;
    public KsiazkaZOkladkaZwykla(Publikacja ksiazka) throws KsiazkaException {
        if( (ksiazka instanceof  KsiążkaZOkładkaTwarda) || ( ksiazka instanceof  KsiazkaZOkladkaZwykla) )
            throw  new KsiazkaException("Ksiazka moze miec jedna okladke");
        this.ksiazka = ksiazka;
    }

    @Override
    public String toString() {
        String string = ksiazka.toString() + " Okładka zwykła | ";
        return string;
    }
}
