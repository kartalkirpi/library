package kutuphane;

import java.util.Scanner;

public abstract class Person extends Library {
    String name;
    String id;
    Type type;
    static int counter;

    public Person(String name, Type type) {
        this.name = name;
        this.type = type;
        counter++;
        this.id = name + counter;


    }

    public Person() {
    }
    public static void personelEkle(Person person1){
        person.add(person1);
    }

    public abstract void oduncKitap();

    public abstract void alinabilecekKitapListesi();

    public abstract void kitapTeslimEt();

    public abstract void personelEkle();

    public abstract void kitapListesi();

    public abstract void kitapEkle();

    public abstract void kitapSil();

    public abstract void personelleriListele();

    public abstract void adminleriListele();

    public abstract void uyeleriListele();

    public abstract void personelsil();

    public abstract void benimKitaplarim();

    public abstract void adminIslemleri();


    public void anaSayfa() {
        System.out.println("Lütfen id'nizi yazınız : ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        for (int i = 0; i < person.size(); i++) {

            if (id.equals(person.get(i).id)) {
                person.get(i).adminIslemleri();
            }


        }anaSayfa();

    }


}

