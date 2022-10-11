class CepTelefonu(val kendiNumaram : String) {
    private val rehber : ArrayList<Kisi>

    init {
        this.rehber= ArrayList()
    }

    fun ekleYeniKisi(yeniKisi:Kisi) : Boolean{
        if (kisiBul(yeniKisi.isim) >= 0){
            println("${yeniKisi.isim} zaten rehberde var")
            return false
        }
        this.rehber.add(yeniKisi)
        println("Basarılı bir sekilde eklendi")
        return true
    }

    fun kisiBul(aranacakKisi : Kisi): Int {

        return this.rehber.indexOf(aranacakKisi)
    }

    fun kisiBul(isim:String) : Int{
        for (i:Int in rehber.indices){
            val oankikisi=rehber[i]
            if (oankikisi.isim.equals(isim)){
                return i
            }
        }
        return -1
    }

    fun tumKisileriListele(){
        println("*******    REHBER  *********")
        if (rehber.size == 0){
            println("Rehberde kayıtlı kisi yok")
            return
        }else{
            for (oankikisi:Kisi in rehber){
                println("${oankikisi.isim} --- ${oankikisi.telno}" )
            }
        }

    }

    fun kisiSorgula(isim: String) : Kisi?{
        val position = kisiBul(isim)

        return if (position>=0){
            rehber[position]
        }else{
            return null
        }
    }

    fun kisiSil(silinecekKisi : Kisi) : Boolean{
        val position = kisiBul(silinecekKisi)
        if (position<0){
            println("Böyle bir kişi yok")
            return false
        }else{
            this.rehber.remove(silinecekKisi)
            println("Kişi silindi")
            return true
        }
    }

    fun kisiGuncelle(eskiKisi : Kisi,yeniKisi : Kisi) : Boolean{
        val bulunanPosition = kisiBul(eskiKisi)
        if (bulunanPosition<0){
            println("Böyle bir kayıt yok")
            return false
        }else{
            rehber[bulunanPosition] = yeniKisi
            println("${eskiKisi.isim} kişisi ${yeniKisi.isim} şeklinde güncellendi")
            return true
        }
    }
}