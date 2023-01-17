package kutuphane;

import java.util.Scanner;

public class Admin extends Person {
    public Admin(String name, Type type) {
        super(name, type);
    }

    @Override
    public void oduncKitap() {
        System.out.println("----------------------------------------");
        System.out.println("******ALABİLECEĞİN ÖDÜNÇ KİTAPLAR LİSTESİ******");
        System.out.println("Almak istediğiniz kitabın id'sini yazınız : ");
        Scanner scan = new Scanner(System.in);

        String id = scan.nextLine();
        if (myBook.size() == 3) {
            System.out.println("Elinizde 3 tane kitap var ");
            alinabilecekKitapListesi();
        }
        for (int i = 0; i < book.size(); i++) {
            if (id.equals(book.get(i).id)) {
                book.get(i).durum = Free.reserve;
                System.out.println("Kitabı teslim etmek için 15 gün süreniz vardır.");

                myBook.add(book.get(i));
                break;

            }

        }

        System.out.println("Tekrar kitap almak için 1'i ana sayfaya dönmek için 2'yi tuşlayınız : ");
        String secim = scan.nextLine();
        switch (secim) {
            case "1":
                oduncKitap();
                break;
            case "2":
                adminIslemleri();
                break;
            default:
                System.out.println("hatalı tuşlama yaptınız ");
                oduncKitap();
                break;
        }
    }

    @Override
    public void alinabilecekKitapListesi() {
        System.out.println("----------------------------------------");
        System.out.println("******ALABİLECEĞİN KİTAPLAR LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).durum == Free.alinabilir) {
                System.out.println("Kitabın adı : " + book.get(i).name +
                        "  Yazarın adı  " + book.get(i).yazar + "  İd no:  " + book.get(i).id);

            }


        }
        adminIslemleri();


    }

    @Override
    public void kitapTeslimEt() {
        System.out.println("----------------------------------------");
        System.out.println("Teslim etmek istediğiniz kitabın id'sini giriniz : ");
        Scanner scan = new Scanner(System.in);
        String idNo = scan.nextLine();
        for (int i = 0; i < myBook.size(); i++) {
            if (idNo.equals(myBook.get(i).id)) {
                myBook.get(i).durum = Free.alinabilir;
                myBook.remove(myBook.get(i));

            }

        }
        System.out.println("Tekrar kitap teslim etmek için 1'i ana sayfaya dönmek için 2'yi tuşlayınız : ");
        String secim = scan.nextLine();
        switch (secim) {
            case "1":
                kitapTeslimEt();
                break;
            case "2":
                adminIslemleri();
                break;
            default:
                System.out.println("hatalı tuşlama yaptınız ");
                kitapTeslimEt();
                break;
        }


    }

    @Override
    public void personelEkle() {
        System.out.println("----------------------------------------");
        Scanner scan=new Scanner(System.in);
        System.out.println("Personel ekleme sayfasına Hoş geldiniz : ");
        System.out.println("Üye eklemek istiyorsanız 1'e Admin eklemek istiyorsanız " +
                "2'yi Ana sayfaya dönmek için 3'ü tuşlayınız : ");
        String secim = scan.nextLine();
       if(secim.equals("1")){
           System.out.println("Eklemek istediğiniz üyenin ismini yazınız : ");
           String name=scan.nextLine();
           Person member=new Member(name,Type.member);
           person.add(member);
           personelEkle();
       } else if (secim.equals("2")) {
           System.out.println("Eklemek istediğiniz adminin ismini yazınız : ");
           String name=scan.nextLine();
           Person admin=new Admin(name,Type.admin);
           person.add(admin);
           personelEkle();
       } else if (secim.equals("3")) {
           adminIslemleri();
       }else {
           System.out.println("Hatalı tuşlama yaptınız");
           personelEkle();
       }
    }
    @Override
    public void kitapListesi() {
        System.out.println("----------------------------------------");
        System.out.println("******KİTAP LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < book.size(); i++) {

            System.out.println("Kitabın adı : " + book.get(i).name +
                    "  Yazarın adı  " + book.get(i).yazar + "  İd no:  " + book.get(i).id);

        }
        adminIslemleri();


    }


    @Override
    public void kitapEkle() {
        System.out.println("----------------------------------------");
        System.out.println("Eklemek istediğiniz kitabın adını yazınız : ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Eklemek istediğiniz kitabın yazarını yazınız : ");
        String kitapName = scan.nextLine();
        Book book1 = new Book(name, kitapName);
        book1.durum = Free.alinabilir;
        book.add(book1);
        System.out.println("Tekrar kitap eklemek için 1'i ana sayfaya dönmek için 2'yi tuşlayınız : ");//
        String secim = scan.nextLine();
        switch (secim) {
            case "1":
                kitapEkle();
                break;
            case "2":
                adminIslemleri();
                break;
            default:
                System.out.println("hatalı tuşlama yaptınız ");
                kitapEkle();
                break;
        }

    }

    @Override
    public void kitapSil() {
        System.out.println("----------------------------------------");
        System.out.println("Silmek istediğiniz kitabın id'sini yazınız : ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        for (int i = 0; i < book.size(); i++) {
            if (id.equals(book.get(i).id)) {
                book.remove(book.get(i));
            }
        }
        for (int i = 0; i < myBook.size(); i++) {
            if (id.equals(myBook.get(i).id)) {
                myBook.remove(myBook.get(i));
            }
        }

        System.out.println("Ana sayfaya dönmek için 1'e kitap silmek için 2'yi tuşlayınız : ");
        String secim = scan.nextLine();
        if (secim.equals("1")) {
            adminIslemleri();
        } else if (secim.equals("2")) {
            kitapSil();
        } else {
            System.out.println("Hatalı tuşlama yaptınız");
            kitapSil();
        }


    }

    @Override
    public void personelleriListele() {
        System.out.println("----------------------------------------");
        System.out.println("******KÜTÜPHANEDEKİ TÜM PERSONELLERİN LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < person.size(); i++) {
            System.out.println("Name : "+person.get(i).name + "\t\tID : " + person.get(i).id + "\t\tType : " + person.get(i).type);
        }
        adminIslemleri();
    }

    @Override
    public void adminleriListele() {
        System.out.println("----------------------------------------");
        System.out.println("*******KÜTÜPHANEDEKİ ADMİNLERİN LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).type.equals(Type.admin)) {
                System.out.println("Name : "+person.get(i).name + "\t\tID : " + person.get(i).id + "\t\tType : " + person.get(i).type);
            }

        }
        adminIslemleri();

    }

    @Override
    public void uyeleriListele() {
        System.out.println("----------------------------------------");
        System.out.println("******KÜTÜPHANEDEKİ ÜYELERİN LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).type == Type.member) {
                System.out.println("Name : "+person.get(i).name + "\t\tID : " + person.get(i).id + "\t\tType : " + person.get(i).type);
            }

        }
        adminIslemleri();

    }

    @Override
    public void personelsil() {
        System.out.println("----------------------------------------");
        System.out.println("Silmek istediğiniz personelin id'sini yazınız : ");
        Scanner scan = new Scanner(System.in);
        String idNo = scan.nextLine();
        for (int i = 0; i < person.size(); i++) {
            if (idNo.equals(person.get(i).id)) {
                person.remove(person.get(i));
            }

        }
        System.out.println("Personelleri silmek için 1'i ana sayfaya dönmek için 2'yi tuşlayınız : ");
        String secim = scan.nextLine();
        switch (secim) {
            case "1":
                personelsil();
                break;
            case "2":
                adminIslemleri();
                break;
            default:
                System.out.println("hatalı tuşlama yaptınız ");
                personelsil();
                break;
        }

    }

    @Override
    public void benimKitaplarim() {
        System.out.println("----------------------------------------");
        System.out.println("******ELİNİZDEKİ KİTAPLARIN LİSTESİ******");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < myBook.size(); i++) {
            System.out.println("Kitabın adı : " + myBook.get(i).name +
                    "  Yazarın adı  " + myBook.get(i).yazar + "  İd no:  " + myBook.get(i).id);


        }
        adminIslemleri();

    }

    @Override

    public void adminIslemleri() {
        System.out.println("----------------------------------------");
        System.out.println("Yapmak istediğiniz işlemi yazın");
        System.out.println("\t1 →  Alabileceğiniz kitapları listelemek için\t\t\t 8  → Uyeleri listelemek için" +
                "\n\t2 →  Tüm kitapları listelemek için\t\t\t\t\t\t 9  → Adminleri listelemek için" +
                "\n\t3 → Kütüphanemizden kitap alabilmek için\t\t\t\t 10 → Personelleri listelemek için" +
                "\n\t4 →  Aldığınız kitabı teslim etmek için\t\t\t\t     11 → Personel eklemek için\t\t" +
                "\n\t5 →  Kütüphaneye kitap eklemek için\t\t\t\t\t     12 → Personel silmek için" +
                "\n\t6 → Kütüphaneden kitap silmek için\t\t\t\t\t     13 → Bir üst menüye dönmek için" +
                "\n\t7 →  Elimdeki kitaplar\t\t\t\t\t\t\t\t\t 14 → SİSTEMDEN ÇIKIŞ ");
        Scanner scan = new Scanner(System.in);
        String secim = scan.nextLine();
        switch (secim) {
            case "1":

                alinabilecekKitapListesi();
            case "2":

                kitapListesi();
            case "3":

                oduncKitap();
            case "4":
                kitapTeslimEt();
                break;
            case "5":
                kitapEkle();
                break;
            case "6":
                kitapSil();
                break;
            case "7":

                benimKitaplarim();
                break;
            case "8":

                uyeleriListele();
                break;
            case "9":

                adminleriListele();
                break;
            case "10":

                personelleriListele();
                break;
            case "11":
                personelEkle();
                break;
            case "12":
                personelsil();
                break;
            case "13":
                anaSayfa();
                break;
            case "14":
                System.exit(0);
            default:
                System.out.println("Hatalı tuşlama yaptınız");
                adminIslemleri();
        }
    }
}
