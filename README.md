# first-homework

# Hibernate

Hibernate Java geliştiriciler için geliştirilmiş bir ORM kütüphanesidir. Nesne yönelimli modellere göre veritabanı ile olan ilişkiyi sağlayarak, veritabanı üzerinde yapılan işlemleri kolaylaştırmakla birlikte kurulan yapıyı da sağlamlaştırmaktadır.
Nesneye yönelik yazılım ve ilişkisel veritabanı kullanımı günümüzde oldukça yaygındır. Bu iki gözde modelin belkide en önemli problemi en az onlar kadar yaygın ve dahası önü açık olan kuruluş uygulamaları(enterprise applications) ile birlikte kullanıldıklarında oldukça karışık, yorucu ve zaman alıcı olmalarıdır. Hibernate bir nesne/ilişkisel eşleme (Object/Relational Mapping) aracıdır. Burada nesne/ilişkisel eşleme terimi nesne modelindeki veri tanımlarının ilişkisel veri modeline eşleme (mapping) tekniğini ifade etmektedir.
Hibernate yalnızca Java sınıflarından veritabanı tablolarına veya Java veri tiplerinde SQL veri tiplerine dönüşümü yapmaz. Hibernate veri sorgulama(data query) ve veri çekme(data retriaval) işlemlerini de kullanıcı için sağlar. Bu özellikleriyle Hibernate geliştirme kolaylığı ve zamandan kazanç sağlar. Hibernate kullanımı olmadan tüm adı anılan işlemler için [SQL ve JDBC](https://f-yesilyurt.medium.com/veri-veritabanı-dbms-ve-jdbc-kavramları-b49b22e731aa)’nin olanaklarından faydalanılarak el ile(manual) veri işleme(data handling) gerçekleştirilmesi zaruri olacaktır.

![](https://github.com/furkanyesilyurt/n11-java-bootcamp/blob/main/week1-oopAndHibernate/Hibernate_logo_a.png)

## Temel Hibernate Anotasyonları

Bir class veritabanına dönüştürülürken veri tanımları gerekir. Bu tanımlamaları anotasyonlar ile yaparız. Entity özelliklerini Java kodunda belirlemeye yarar.

* **@Entity**
  Entity anotasyonu bir Java Class’ımızın persist class olduğunu belirtir. Hibernate bu anotasyonu gördüğü an veritabanında bir tablo oluşturacağını bilir.

* **@Table**
  Table anotasyonu zorunlu değildir. Eğer kullanılıyorsa veritabanındaki tablo ismini değiştirebilirisiniz. Veritababını ismi ile persist ismi farklı olabilir. Bu işlem name attribute’si ile tanımlanmaktadır.

* **@Id**
  Her entity de mutlaka bulunmalıdır. İlgili entity’nin uniqe değerini tutar.

* **@GeneratedValue**
  GeneratedValue anotasyonu ise birincil anahtarımız için Hibernate’nin birbirinden farklı değer üreten üretecin özelliklerinin tanımlanmasını sağlayan bir anaotasyonudur.  Hangi değerden başlayacağı, ön ek gibi değerler tanımlamayı mümkün kılmaktadır.

* **@SequnceGenerator**
  Sequence generator kullanılacak sequnceleri özeliklerini özelleştirmek için kullanır.

* **@TableGenerator**
  Otomatik artan değerlerde sistem tarafından oluşturulan id değerini tutmak için kullanılmaktadır.Bir sonraki oluşacak olan id değerini bir tablo oluşturarak saklayabilmektedir.Gerek ilişkisel tablolarda gerekse raporlama esnasında kullanılabilir.

* **@Column**
  Column anotasyonu veritabanımızdaki alanın özelliklerini belirler.  Bu alanın uzunluğu, adı, boş geçilip geçilemediği gibi özellikler tanımlayabilmekteyiz.

* **@Version**
  Hibernate, @Version ile işaretlenen kolon sayesinde bir oturumda açılan varlık nesnesinin, diğer bir oturumda değiştirilmesine izin vermeyerek OptimisticLockException fırlatır. Bu istisna yakalanarak ilgili işlemler yapılabilir. Değişiklik yapılmak istenen varlık nesnesinin başka bir oturumda değiştirildiği belirtilerek kullanıcı yönlendirilebilir.

* **@Temporal**
  Bu dip not haritalanan kolunun bir tarih,saat tipinde olacağını yani zamana bağlı veri tiplerinde kullanırız.Farklı kullanım şekilleri vardır ve belirttiğiniz etiket ile sizin o değişkene atadığınız değeri belirttiğiniz formata çevirir.Örneği biz set metodu ile tarih ve saati verip,etiket olarak sadece tarih belirtirsek veritabanına veri tarih olarak kaydedilecektir.

* **@Transient**
  Bu dipnotun kullanıldığı değişken veritabanında ise tabloya karşılık gelecek olan alanın sınıfta var olacağı fakat tablo üzerinde bir kolona karşılık gelmeyeceği yanı tablo üzerinde bir kolonun oluşturulmaması gerektiğini belirtir.Yani bu dip nota sahip alan orm araçları tarafından görmezden gelinir.

* **@Lob**
  Large object olarak ifade edilir,yani büyük veri tipleri için kullanılır.Her veritabanı yönetim sisteminin farklı büyük veri tipleri vardır örneğin mysql longtext diye belirtirken oracle lob diyebilir işte Lob dipnotunu verdiğimizde orm araçları bunu veritabanına göre ayarlayarak o kolonu büyük veri olarak oluşturur.

Hafta_1 ile ilgili ders notlarına ulaşmak için: [Birinci hafta ders notları](https://github.com/furkanyesilyurt/n11-java-bootcamp/tree/main/week1-oopAndHibernate)

Öğrendiğim ve çalıştığım konular hakkında yazdığım medium yazıları için: [Furkan Yeşilyurt Medium](https://f-yesilyurt.medium.com/)
