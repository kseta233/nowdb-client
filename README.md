#Now DB - Mobile API Tutorial
##Daftar Isi
[TOC]
* auto-gen TOC:
{:toc}

##Android
https://github.com/kseta233/nowdb-client-sample-android

##iOS
https://github.com/kseta233/nowdb-client-sample-iOS

##Pengantar
Halo developers,
Banyak penyedia layanan untuk membuat backend aplikasi mobile. Beberapa yang terkenal:

- [Firebase](https://firebase.google.com/),
- ~~[Parse](http://www.parse.com/)~~,
- [Backendless](https://backendless.com/),
- [appceralator](http://www.appcelerator.com/mobile-app-development-products/),
- [GameSpark](http://www.gamesparks.com/games-back-end/)
- dll,

Salah satu yang akan kita bahas kali adalah layanan Backend Data as A Service, karya anak bangsa yang reliable dan mempunyai performance mumpuni  **[NowDB](http://nowdb.net/)** .

NowDB merupakan penyedia layanan untuk membuat backend API untuk kebutuhan data. Sehingga developer lebih mudah dalam membuat aplikasi frontend. Beberapa aplikasi pemerintahan, telah mempercayakan backend aplikasinya menggunakan nowdb.

Selengkapnya, silahkan kunjungi http://nowdb.net


## NOW DB API
Now DB APi saat ini sudah ada v2. API v2 ini memberikan beberapa keunggulan daripada v1 nya

- performa, API V2 ini dibuat secara lebih baik dengan menggunakan REST API respons JSON
- dashboard aplikasi yang sudah diperbaharui, dengan tampilan lebih fresh, dan memudahkan end user untuk membuat data di now db

NowDB API terdiri dari

- insert:
 - endpoint : http://io.nowdb.net/v2/insert
 - method : POST
 - param:
   - {token} *     = Change with your account token.
   - {project} *   = Change with your project want to access.
   - {collection} * = Change with collection inside the project.
   - {appid} *     = Change with appid from registered application.
   - {id}  *       = Change with data id.
- select_all
 - url: http://io.nowdb.net/v2/select_all/token/{token}/project/{project}/collection/{collection}/appid/{appid}/limit/{limit}/offset/{offset}
 - method: GET
 - param:
   - {token} *      = Change with your account token.
   - {project} *    = Change with your project want to access.
   - {collection} * = Change with collection inside the project.
   - {appid}  *    = Change with appid from registered application.
 - additional param:
   - {limit}      = Change with number that represent data limitation you want to show.
   - {offset}     = Change with number tahat represent to skip data you want to show from the top or first row.
- select_id
 - url: http://io.nowdb.net/v2/select_id/token/{token}/project/{project}/collection/{collection}/appid/{appid}/id/{id}
 - method: GET
 - param:
   - {token} *      = Change with your account token.
   - {project} *    = Change with your project want to access.
   - {collection} * = Change with collection inside the project.
   - {appid}  *    = Change with appid from registered application.
- where
 - url: http://io.nowdb.net/v2/select_where/token/{token}/project/{project}/collection/{collection}/appid/{appid}/where_field/{where_field}/where_value/{where_value}/limit/{limit}/offset/{offset}

 - method: GET
 - param:
   - {token}        = Change with your account token.
   - {project}      = Change with your project want to access.
   - {collection}   = Change with collection inside the project.
   - {appid}        = Change with appid from registered application.
   - {where_field}  = Change with condition field. Field can be more than one separate by "AND", field must be in different name.
   - {where_value}  = Change with condition value. Value can be more than one separate by "AND", value must be same order like condition field.
 - additional param:
   - {limit}      = Change with number that represent data limitation you want to show.
   - {offset}     = Change with number tahat represent to skip data you want to show from the top or first row.

Selain method diatas, masih terdapat API seperti where in, where not in where like, yang selengkapnya dapat dilihat di : http://doc.nowdb.net/


##Kesimpulan

Positif NowDB:
1. NowDB sudah mudah untuk membangun collection dan API dengan dibantu GUI yang modern dan cukup mudah dipahami
2. sebuah collection dapat digunakan untuk berbagai aplikasi
3. berbeda dengan firebase yang memberikan response object dengan id terlebih dahulu untuk setiap field, pengembalian dari nowdb lebih enak untuk digunakan, tetapi kurang prefix object

Masukan untuk Now DB
1. Response API nowdb masih perlu dibenahi, sehingga mempunyai prefix object
2. Harus dibedakan response antara satu object dengan multiple object
