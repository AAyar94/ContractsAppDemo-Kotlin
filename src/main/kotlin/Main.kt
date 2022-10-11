import java.util.Scanner

private val tara=Scanner(System.`in`)
private val ceptelefonu = CepTelefonu("555-555-555")

fun main(args: Array<String>) {



    telefonubaşlat()
    menuGoster()

    var cıkıs: Boolean = false
    while(!cıkıs){
        println("Seciminiz : 6 -- Menuyu göster")
        var secim=tara.nextInt()

        when(secim){
            0 ->{
                println("Çıkış yapılıyor")
                cıkıs=true
            }
            1 ->{
                ceptelefonu.tumKisileriListele()
            }
            2 -> {
                yeniKisiEkleFunc()
            }
            3 ->{
                kisiSorgulaM()
            }
            4 ->{
                kisiSilM()
            }
            5 ->{
                kisiGuncelleM()
            }
            6 ->{
                menuGoster()
            }
            else -> println("Yanlış bir seçim yaptınız")
        }
    }

}

fun kisiGuncelleM() {
    println("Güncellenecek Kisinin Adını Giriniz:")
    val guncellenecekKisi =tara.next()
    var bulunanKisi = ceptelefonu.kisiSorgula(guncellenecekKisi)
    if (bulunanKisi == null){
        println("Kayıt Bulunamadı")
        return
    }else{
        println("Yeni kişinin Adını Giriniz:")
        val yeniIsim = tara.next()
        println("Yeni kisinin telefon numarasını giriniz:")
        val yeniTelNo = tara.next()
        ceptelefonu.kisiGuncelle(bulunanKisi , Kisi.kisiOlustur(yeniIsim,yeniTelNo))
2


    }
    }

fun yeniKisiEkleFunc() {
    println("Yeni kişinin Adını Giriniz:")
    val isim= tara.next()
    println("Yeni kisinin telefon numarasını giriniz:")
    val telNo=tara.next()

    ceptelefonu.ekleYeniKisi(Kisi.kisiOlustur(isim,telNo))

}
fun kisiSorgulaM(){
    println("Sorgulanacak Kisinin Adını Giriniz:")
    val isim = tara.next()
    val bulunanKisi =ceptelefonu.kisiSorgula(isim)
    if (bulunanKisi== null){
        println("Rehberde Böyle bir kişi yok")
        return
    }else{
        println("Bulunan Kişi :  ${bulunanKisi.isim} ---"+ "${bulunanKisi.telno}")
    }
}
fun kisiSilM(){
    println("Silinecek Kişinin adını giriniz:")
    val silinecekIsim = tara.next()
    val bulunanKisi = ceptelefonu.kisiSorgula(silinecekIsim)

    if (bulunanKisi != null){
        if(ceptelefonu.kisiSil(bulunanKisi!!)){
        println("Silme Yapıldı")
    }}else{
        println("Kişi bulunamadı")
    }}

fun telefonubaşlat(){
    println("Telefıon başlatılıyor")
}

fun menuGoster(){
    println("*******************")
    println("0 -- Çıkış \n" +
            "1 -- Tüm kişileri Listele \n" +
            "2 -- Yeni Kişi ekle \n" +
            "3 -- Kişi Sorgula \n" +
            "4 -- Kişiyi Sil \n" +
            "5 -- Var olan Kişiyi Güncelle \n" +
            "6 -- Menüyü Göster \n")
}