public class KsiążkaZOkładkaTwarda implements Publikacja {
    Publikacja ksiazka;
    public KsiążkaZOkładkaTwarda(Publikacja ksiazka) throws KsiazkaException {
        if( (ksiazka instanceof  KsiążkaZOkładkaTwarda) || ( ksiazka instanceof  KsiazkaZOkladkaZwykla) )
            throw  new KsiazkaException("Ksiazka moze miec jedna okladke");
        this.ksiazka = ksiazka;
    }

    @Override
    public String toString() {
        String string = ksiazka.toString() + " Okładka twarda | ";
        return string;
    }
}
