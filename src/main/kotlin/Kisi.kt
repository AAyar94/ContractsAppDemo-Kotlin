class Kisi(var isim:String,var telno:String) {
    companion object{
        fun kisiOlustur(isim:String,telno:String) : Kisi{
            return Kisi(isim,telno)
        }
    }



}