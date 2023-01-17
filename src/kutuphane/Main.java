package kutuphane;

public class Main {
    public static void main(String[] args) {
        Admin nur = new Admin("Nur", Type.admin);
        nur.personelEkle(nur);
        System.out.println(nur.id);
        nur.anaSayfa();


    }
}
