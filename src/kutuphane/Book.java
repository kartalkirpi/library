package kutuphane;

public class Book extends Library{
    String name;
    String yazar;
    String tur;
    String sayfaSayisi;
    static int count;
    String id;
    Free durum;

    public Book(String name, String yazar) {
        this.name = name;
        this.yazar = yazar;
        count++;
        this.id=name+count;

        durum=Free.reserve;



    }
}
