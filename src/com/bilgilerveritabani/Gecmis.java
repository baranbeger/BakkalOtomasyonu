package com.bilgilerveritabani;


public class Gecmis {
	private  int IslemNo;
	private  String  UrunIsim;
	private  int UrunFiyat;
	private  String  UrunKategori;
	private  String  Uruntarih;
	
	public Gecmis(int IslemNo,String UrunIsim,int UrunFiyat,String UrunKategori,String Uruntarih) {
		this.IslemNo=IslemNo;
		this.UrunIsim=UrunIsim;
		this.UrunFiyat=UrunFiyat;
		this.UrunKategori=UrunKategori;
		this.Uruntarih=Uruntarih;
		
	}

	public int getIslemNo() {
		return IslemNo;
	}

	public void setIslemNo(int islemNo) {
		IslemNo = islemNo;
	}

	public String getUrunIsim() {
		return UrunIsim;
	}

	public void setUrunIsim(String urunIsim) {
		UrunIsim = urunIsim;
	}

	public int getUrunFiyat() {
		return UrunFiyat;
	}

	public void setUrunFiyat(int urunFiyat) {
		UrunFiyat = urunFiyat;
	}

	public String getUrunKategori() {
		return UrunKategori;
	}

	public void setUrunKategori(String urunKategori) {
		UrunKategori = urunKategori;
	}

	public String getUruntarih() {
		return Uruntarih;
	}

	public void setUruntarih(String uruntarih) {
		Uruntarih = uruntarih;
	}

	
	
}
