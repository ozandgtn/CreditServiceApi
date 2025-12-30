# Kredi Hesaplama Backend Servisi

Bu proje, **Spring Boot** kullanılarak geliştirilmiş bir **kredi hesaplama backend servisidir**.

Kullanıcı (Postman üzerinden):
- Meslek grubunu
- İstediği kredi tutarını
- Kaç ayda ödemek istediğini

gönderir.

Sistem:
- Meslek grubuna göre maksimum kredi limitini kontrol eder
- Uygun faiz oranını uygular
- Toplam geri ödeme ve aylık taksit tutarını hesaplar
- Sonucu JSON olarak geri döner

 Tüm testler **Postman** üzerinden yapılmıştır.

---

## 🛠 Kullanılan Teknolojiler

- Java 17  
- Spring Boot  
- Spring Web (REST API)  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- Postman  

---

## 📌 İş Kuralları

### Meslek Gruplarına Göre Aylık Faiz Oranları
- OGRENCI → %1.29  
- MEMUR → %1.59  
- ASKER → %1.79  
- CIFTCI → %1.49  

### Meslek Gruplarına Göre Maksimum Kredi Limitleri
- OGRENCI → 100.000 TL  
- MEMUR → 1.000.000 TL  
- ASKER → 1.500.000 TL  
- CIFTCI → 2.000.000 TL  

İstenen kredi tutarı, meslek grubuna ait maksimum limiti aşarsa işlem reddedilir.

---
## 🧮 Hesaplama Mantığı

Toplam Geri Ödeme = Ana Para × (1 + Aylık Faiz × Vade)
Aylık Taksit = Toplam Geri Ödeme / Vade

---

## 📂 Proje Yapısı

Controller → REST endpoint’ler
Business → İş mantığı (hesaplama, kontrol)
Entity → Veritabanı tabloları
Repository → Veritabanı erişimi
Dto → Request / Response sınıfları
Enum → Meslek tanımları
Exception → Özel hata sınıfları

---

---

## API Endpoint’leri
```		
### Meslekleri Listeleme

GET /api/professions
Response:
```json
[
  "OGRENCI",
  "MEMUR",
  "ASKER",
  "CIFTCI"
]

### Kredi Hesaplama

POST /api/calculate
Request Body:
{
  "profession": "MEMUR",
  "requestedAmount": 200000,
  "termMonths": 12
}

Response:
{
  "id": 1,
  "profession": "MEMUR",
  "requestedAmount": 200000,
  "termMonths": 12,
  "monthlyInterestRate": 0.0159,
  "totalPayment": 238160.00,
  "monthlyInstallment": 19846.67
}

```

Geliştirici

Ozan Alp Dağıtan




























