package kutuphane;

import java.util.Scanner;

public class Member extends Person {
    public Member(String name, Type type) {
        super(name, type);
    }

    @Override
    public void oduncKitap() {
        System.out.println("----------------------------------------");
        System.out.println("***********ÖDÜNÇ KİTAPLAR LİSTESİ**********");
        System.out.println("Almak istediğiniz kitabın id'sini yazınız : ");
        Scanner scan = new Scanner(System.in);

        String id = scan.nextLine();
        if (myBook.size() == 3) {
            System.out.println("Elinizde 3 tane kitap var ");
            adminIslemleri();
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
        System.out.println("********ALINABİLECEK KİTAPLAR LİSTESİ**********");
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
        System.out.println("*********KİTAP TESLİM ETME SAYFASI*********");
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
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void kitapListesi() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void kitapEkle() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void kitapSil() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void personelleriListele() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void adminleriListele() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void uyeleriListele() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void personelsil() {
        System.out.println("Sizin böyle bir yetkiniz yoktur");

    }

    @Override
    public void benimKitaplarim() {
        System.out.println("----------------------------------------");
        System.out.println("*******ELİMDEKİ KİTAPLAR*******");
        for (int i = 0; i <myBook.size() ; i++) {
            System.out.println("Kitabın adı : " + myBook.get(i).name +
                    "  Yazarın adı  " + myBook.get(i).yazar + "  İd no:  " + myBook.get(i).id);


        }
           adminIslemleri();
        }




    @Override
    public void adminIslemleri() {
        System.out.println("----------------------------------------------------");
        Scanner scan=new Scanner(System.in);



        System.out.println("Yapmak istediğiniz işlemi yazın");
        System.out.println("Alabileceğiniz kitapları listelemek için => 1\nKütüphanemizden kitap alabilmek için => 2\n" +
                "Daha önce aldığınız kitabı teslim etmek için => 3\nElinizdeki kitapları görebilmek için => 4" +
                "\nBir üst menüye dönmek için => 5\nCıkıs yapmak için => 6");

        String secim = scan.nextLine();

        if (secim.equals("1")) {
            alinabilecekKitapListesi();
        } else if (secim.equals("2")) {
            oduncKitap();
        } else if (secim.equals("3")) {
            kitapTeslimEt();
        } else if(secim.equals("4")){
            benimKitaplarim();
        } else if(secim.equals("5")){
            anaSayfa();
        } else if (secim.equals("6")) {
            System.exit(0);
        } else {
            System.out.println("Hatalı tuşlama yaptınız.");
            adminIslemleri();
        }
    }



}

