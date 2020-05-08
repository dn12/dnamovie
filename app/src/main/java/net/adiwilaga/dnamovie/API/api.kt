package net.adiwilaga.dnamovie.API


import android.util.Log

import io.reactivex.Observable
import net.adiwilaga.dnamovie.model.baselistresponse
import net.adiwilaga.dnamovie.model.genreresponse
import net.adiwilaga.dnamovie.model.movie
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.IOException
import java.io.InputStream
import java.security.GeneralSecurityException
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*


interface api {

//    @POST("/mobileapi/logout/")
//    fun logout(
//    ): Observable<baseresponse<String>>
//
//
//    @Multipart
//    @POST("/mobileapi/editprofile/")
//    fun editprofile(
//            @Part("id_reg") id_reg: RequestBody,
//            @Part("phone") phone: RequestBody,
//            @Part("email") email: RequestBody,
//            @Part("name") name: RequestBody,
//            @Part img: MultipartBody.Part?
//    ): Observable<baseresponse<loginresponse>>
//
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/eventregister/")
//    fun registerevent(
//            @Field("event_id") event_id: String,
//            @Field("id_reg") id_reg: String
//    ): Observable<baseresponse<registereventresponse>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/comment/")
//    fun commentarticle(
//            @Field("article_id") article_id: String,
//            @Field("token") token: String,
//            @Field("comment") comment: String
//    ): Observable<baseresponse<Any>>
//
//
//    @GET("/mobileapi/eventparticipant/")
//    fun getParticipant(@Query("xs") xs: String, @Query("event_id") event_id: String): Observable<baseresponse<List<participant>>>
//
//    @GET("/mobileapi/commentarticle/")
//    fun getComment(@Query("xs") xs: String, @Query("article_id") article_id: String): Observable<baseresponse<List<comment>>>
//
//  @GET("/mobileapi/partner/")
//    fun getPartner(@Query("xs") xs: String): Observable<baseresponse<List<partner>>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/likearticle/")
//    fun likearticle(
//            @Field("article_id") article_id: String,
//            @Field("id_reg") id_reg: String,
//            @Field("type") type: String
//
//    ): Observable<baseresponse<Any>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/forgotpass/")
//    fun forgotpassword(@Field("identity") identity: String): Observable<baseresponse<String>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/login/")
//    fun login(
//            @Field("identity") identity: String,
//            @Field("password") password: String,
//            @Field("fcmid") fcmid: String): Observable<baseresponse<loginresponse>>
//
//    @FormUrlEncoded
//    @POST("/mobileapi/logingoogle/")
//    fun logingoogle(
//            @Field("email") email: String,
//            @Field("googleid") googleid: String,
//            @Field("googleat") googleat: String,
//            @Field("fcmid") fcmid: String
//    ): Observable<baseresponse<loginresponse>>
//
//    @FormUrlEncoded
//    @POST("/mobileapi/loginfb/")
//    fun loginfb(
//            @Field("fbid") fbid: String,
//            @Field("fbat") fbat: String,
//            @Field("fcmid") fcmid: String
//    ): Observable<baseresponse<loginresponse>>
//
//    @FormUrlEncoded
//    @POST("/mobileapi/register/")
//    fun register(
//            @Field("name") name: String,
//            @Field("email") email: String,
//            @Field("password") password: String,
//            @Field("phone") phone: String,
//            @Field("profesi") profesi: String,
//            @Field("promocode") promocode: String
//    ): Observable<baseresponse<registerresponse>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/registerfb/")
//    fun registerfb(
//            @Field("email") email: String,
//            @Field("fbid") fbid: String,
//            @Field("fbat") fbat: String,
//            @Field("promocode") promocode: String
//    ): Observable<baseresponse<registerresponse>>
//
//
//    @FormUrlEncoded
//    @POST("/mobileapi/registergoogle/")
//    fun registergoogle(
//            @Field("email") email: String,
//            @Field("googleid") googleid: String,
//            @Field("googleat") googleat: String,
//            @Field("promocode") promocode: String
//    ): Observable<baseresponse<registerresponse>>
//
//
//    @GET("/mobileapi/detailuser/")
//    fun getdetailuser(@Query("id_reg") id_reg: String): Observable<baseresponse<loginresponse>>
//
//    @GET("/mobileapi/articleheadline/")
//    fun getarticleheadline(@Query("xs") xs: String): Observable<baseresponse<List<article>>>
//
//
//    @GET("/mobileapi/article/")
//    fun getarticle(@Query("xs") xs: String,
//                   @Query("nitems") nitems: String,
//                   @Query("page") page: String,
//                   @Query("category") category: String): Observable<baseresponse<List<article>>>
//
//    @GET("/mobileapi/detailarticle/")
//    fun getarticledetail(@Query("xs") xs: String,
//                         @Query("article_id") article_id: String,
//                         @Query("category") category: String="",
//                         @Query("reg_id") reg_id: String=""
//    ): Observable<baseresponse<articledetail>>
//
//
//    @GET("/mobileapi/category/")
//    fun getcategory(): Observable<baseresponse<List<category>>>
//
//    @GET("/mobileapi/notification/")
//    fun getnotif(
//            @Query("xs") xs: String,
//            @Query("recipient") recipient: String,
//            @Query("token") token: String
//    ): Observable<baseresponse<List<notif>>>
//
//    @FormUrlEncoded
//    @PUT("/mobileapi/updatestatusnotification/")
//    fun readnotif(@Field("notif_id") notif_id: String): Observable<baseresponse<String>>


//
//    @POST("/mobileapi/getartist/jjf19")
//    fun getArtistDetail(@Body obj:Map<String,String>): Observable<baseresponse<artist>>
//
//    @GET("/mobileapi/gethome/jjf19")
//    fun getHome(@Query("xs") xs:String): Observable<homeresponse>
//
//
//    @GET("/mobileapi/getartist/jjf19")
//    fun getArtist(@Query("xs") xs:String): Observable<baseresponse<List<artist>>>
//
//    @GET("/mobileapi/getslider/jjf19")
//    fun getSlider(@Query("xs") xs:String): Observable<baseresponse<List<slider>>>
//
//    @GET("/mobileapi/getschedule/jjf19")
//    fun getSchedule(@Query("xs") xs:String): Observable<baseresponse<List<schedule>>>
//
//    @POST("/mobileapi/gettnc")
//    fun getFestivalInfo(@Body obj:Map<String,String>): Observable<festivalinforesponse>

//    @GET("/mobileapi/lecturer/")
//    fun getlecture(@Query("xs") xs: String,
//                   @Query("nitems") nitems: String,
//                   @Query("page") page: String): Observable<baseresponse<List<lecture>>>
//


    @GET("/3/discover/movie")
    fun getMovie(@Query("sort_by")sort_by: String,
                         @Query("api_key")api_key: String,
                         @Query("page")page: String): Observable<baselistresponse<movie>>
    @GET("/3/genre/movie/list")
    fun getGenre(@Query("api_key")api_key: String): Observable<genreresponse>






    companion object {
        fun create(): api {

            var client= okhttp3() //plain
//            var client=getCustomTrust() //pinned


            val retrofit = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org")
                    .build()

            return retrofit.create(api::class.java)
        }



        private fun okhttp3(): OkHttpClient {
            val httpClient = OkHttpClient().newBuilder()

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

//            httpClient.networkInterceptors().add(interceptor)
            httpClient.networkInterceptors().add(logging)  //logging



            return httpClient.build()

        }


//        fun getCustomTrust(): OkHttpClient{
//            val trustManager: X509TrustManager
//            val sslSocketFactory: SSLSocketFactory
//            try {
//                trustManager = trustManagerForCertificates(trustedCertificatesInputStream())
//                val sslContext = SSLContext.getInstance("TLS")
//                sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
//                sslSocketFactory = sslContext.socketFactory
//            } catch (e: GeneralSecurityException) {
//                throw RuntimeException(e)
//            }
//
//
//            val logging = HttpLoggingInterceptor()
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//            var client = OkHttpClient.Builder()
//                    .connectTimeout(30, TimeUnit.SECONDS)
//                    .readTimeout(30, TimeUnit.SECONDS)
//                    .writeTimeout(30, TimeUnit.SECONDS)
//                    .sslSocketFactory(sslSocketFactory, trustManager)
//                    .addInterceptor(interceptor)
//                    .addInterceptor(logging)
//                    .build()
//
//            return client
//        }
//
//
//            /**
//             * Returns an input stream containing one or more certificate PEM files. This implementation just
//             * embeds the PEM files in Java strings; most applications will instead read this from a resource
//             * file that gets bundled with the application.
//             */
//            private fun trustedCertificatesInputStream(): InputStream {
//                // PEM files for root certificates of Comodo and Entrust. These two CAs are sufficient to view
//                // https://publicobject.com (Comodo) and https://squareup.com (Entrust). But they aren't
//                // sufficient to connect to most HTTPS sites including https://godaddy.com and https://visa.com.
//                // Typically developers will need to get a PEM file from their organization's TLS administrator.
//                val comodoRsaCertificationAuthority = (""
//                        + "-----BEGIN CERTIFICATE-----\n"
//                        + "MIIF2DCCA8CgAwIBAgIQTKr5yttjb+Af907YWwOGnTANBgkqhkiG9w0BAQwFADCB\n"
//                        + "hTELMAkGA1UEBhMCR0IxGzAZBgNVBAgTEkdyZWF0ZXIgTWFuY2hlc3RlcjEQMA4G\n"
//                        + "A1UEBxMHU2FsZm9yZDEaMBgGA1UEChMRQ09NT0RPIENBIExpbWl0ZWQxKzApBgNV\n"
//                        + "BAMTIkNPTU9ETyBSU0EgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkwHhcNMTAwMTE5\n"
//                        + "MDAwMDAwWhcNMzgwMTE4MjM1OTU5WjCBhTELMAkGA1UEBhMCR0IxGzAZBgNVBAgT\n"
//                        + "EkdyZWF0ZXIgTWFuY2hlc3RlcjEQMA4GA1UEBxMHU2FsZm9yZDEaMBgGA1UEChMR\n"
//                        + "Q09NT0RPIENBIExpbWl0ZWQxKzApBgNVBAMTIkNPTU9ETyBSU0EgQ2VydGlmaWNh\n"
//                        + "dGlvbiBBdXRob3JpdHkwggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAwggIKAoICAQCR\n"
//                        + "6FSS0gpWsawNJN3Fz0RndJkrN6N9I3AAcbxT38T6KhKPS38QVr2fcHK3YX/JSw8X\n"
//                        + "pz3jsARh7v8Rl8f0hj4K+j5c+ZPmNHrZFGvnnLOFoIJ6dq9xkNfs/Q36nGz637CC\n"
//                        + "9BR++b7Epi9Pf5l/tfxnQ3K9DADWietrLNPtj5gcFKt+5eNu/Nio5JIk2kNrYrhV\n"
//                        + "/erBvGy2i/MOjZrkm2xpmfh4SDBF1a3hDTxFYPwyllEnvGfDyi62a+pGx8cgoLEf\n"
//                        + "Zd5ICLqkTqnyg0Y3hOvozIFIQ2dOciqbXL1MGyiKXCJ7tKuY2e7gUYPDCUZObT6Z\n"
//                        + "+pUX2nwzV0E8jVHtC7ZcryxjGt9XyD+86V3Em69FmeKjWiS0uqlWPc9vqv9JWL7w\n"
//                        + "qP/0uK3pN/u6uPQLOvnoQ0IeidiEyxPx2bvhiWC4jChWrBQdnArncevPDt09qZah\n"
//                        + "SL0896+1DSJMwBGB7FY79tOi4lu3sgQiUpWAk2nojkxl8ZEDLXB0AuqLZxUpaVIC\n"
//                        + "u9ffUGpVRr+goyhhf3DQw6KqLCGqR84onAZFdr+CGCe01a60y1Dma/RMhnEw6abf\n"
//                        + "Fobg2P9A3fvQQoh/ozM6LlweQRGBY84YcWsr7KaKtzFcOmpH4MN5WdYgGq/yapiq\n"
//                        + "crxXStJLnbsQ/LBMQeXtHT1eKJ2czL+zUdqnR+WEUwIDAQABo0IwQDAdBgNVHQ4E\n"
//                        + "FgQUu69+Aj36pvE8hI6t7jiY7NkyMtQwDgYDVR0PAQH/BAQDAgEGMA8GA1UdEwEB\n"
//                        + "/wQFMAMBAf8wDQYJKoZIhvcNAQEMBQADggIBAArx1UaEt65Ru2yyTUEUAJNMnMvl\n"
//                        + "wFTPoCWOAvn9sKIN9SCYPBMtrFaisNZ+EZLpLrqeLppysb0ZRGxhNaKatBYSaVqM\n"
//                        + "4dc+pBroLwP0rmEdEBsqpIt6xf4FpuHA1sj+nq6PK7o9mfjYcwlYRm6mnPTXJ9OV\n"
//                        + "2jeDchzTc+CiR5kDOF3VSXkAKRzH7JsgHAckaVd4sjn8OoSgtZx8jb8uk2Intzna\n"
//                        + "FxiuvTwJaP+EmzzV1gsD41eeFPfR60/IvYcjt7ZJQ3mFXLrrkguhxuhoqEwWsRqZ\n"
//                        + "CuhTLJK7oQkYdQxlqHvLI7cawiiFwxv/0Cti76R7CZGYZ4wUAc1oBmpjIXUDgIiK\n"
//                        + "boHGhfKppC3n9KUkEEeDys30jXlYsQab5xoq2Z0B15R97QNKyvDb6KkBPvVWmcke\n"
//                        + "jkk9u+UJueBPSZI9FoJAzMxZxuY67RIuaTxslbH9qh17f4a+Hg4yRvv7E491f0yL\n"
//                        + "S0Zj/gA0QHDBw7mh3aZw4gSzQbzpgJHqZJx64SIDqZxubw5lT2yHh17zbqD5daWb\n"
//                        + "QOhTsiedSrnAdyGN/4fy3ryM7xfft0kL0fJuMAsaDk527RH89elWsn2/x20Kk4yl\n"
//                        + "0MC2Hb46TpSi125sC8KKfPog88Tk5c0NqMuRkrF8hey1FGlmDoLnzc7ILaZRfyHB\n"
//                        + "NVOFBkpdn627G190\n"
//                        + "-----END CERTIFICATE-----\n")
//                val entrustRootCertificateAuthority = (""
//                        + "-----BEGIN CERTIFICATE-----\n"
//                        + "MIIEkTCCA3mgAwIBAgIERWtQVDANBgkqhkiG9w0BAQUFADCBsDELMAkGA1UEBhMC\n"
//                        + "VVMxFjAUBgNVBAoTDUVudHJ1c3QsIEluYy4xOTA3BgNVBAsTMHd3dy5lbnRydXN0\n"
//                        + "Lm5ldC9DUFMgaXMgaW5jb3Jwb3JhdGVkIGJ5IHJlZmVyZW5jZTEfMB0GA1UECxMW\n"
//                        + "KGMpIDIwMDYgRW50cnVzdCwgSW5jLjEtMCsGA1UEAxMkRW50cnVzdCBSb290IENl\n"
//                        + "cnRpZmljYXRpb24gQXV0aG9yaXR5MB4XDTA2MTEyNzIwMjM0MloXDTI2MTEyNzIw\n"
//                        + "NTM0MlowgbAxCzAJBgNVBAYTAlVTMRYwFAYDVQQKEw1FbnRydXN0LCBJbmMuMTkw\n"
//                        + "NwYDVQQLEzB3d3cuZW50cnVzdC5uZXQvQ1BTIGlzIGluY29ycG9yYXRlZCBieSBy\n"
//                        + "ZWZlcmVuY2UxHzAdBgNVBAsTFihjKSAyMDA2IEVudHJ1c3QsIEluYy4xLTArBgNV\n"
//                        + "BAMTJEVudHJ1c3QgUm9vdCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTCCASIwDQYJ\n"
//                        + "KoZIhvcNAQEBBQADggEPADCCAQoCggEBALaVtkNC+sZtKm9I35RMOVcF7sN5EUFo\n"
//                        + "Nu3s/poBj6E4KPz3EEZmLk0eGrEaTsbRwJWIsMn/MYszA9u3g3s+IIRe7bJWKKf4\n"
//                        + "4LlAcTfFy0cOlypowCKVYhXbR9n10Cv/gkvJrT7eTNuQgFA/CYqEAOwwCj0Yzfv9\n"
//                        + "KlmaI5UXLEWeH25DeW0MXJj+SKfFI0dcXv1u5x609mhF0YaDW6KKjbHjKYD+JXGI\n"
//                        + "rb68j6xSlkuqUY3kEzEZ6E5Nn9uss2rVvDlUccp6en+Q3X0dgNmBu1kmwhH+5pPi\n"
//                        + "94DkZfs0Nw4pgHBNrziGLp5/V6+eF67rHMsoIV+2HNjnogQi+dPa2MsCAwEAAaOB\n"
//                        + "sDCBrTAOBgNVHQ8BAf8EBAMCAQYwDwYDVR0TAQH/BAUwAwEB/zArBgNVHRAEJDAi\n"
//                        + "gA8yMDA2MTEyNzIwMjM0MlqBDzIwMjYxMTI3MjA1MzQyWjAfBgNVHSMEGDAWgBRo\n"
//                        + "kORnpKZTgMeGZqTx90tD+4S9bTAdBgNVHQ4EFgQUaJDkZ6SmU4DHhmak8fdLQ/uE\n"
//                        + "vW0wHQYJKoZIhvZ9B0EABBAwDhsIVjcuMTo0LjADAgSQMA0GCSqGSIb3DQEBBQUA\n"
//                        + "A4IBAQCT1DCw1wMgKtD5Y+iRDAUgqV8ZyntyTtSx29CW+1RaGSwMCPeyvIWonX9t\n"
//                        + "O1KzKtvn1ISMY/YPyyYBkVBs9F8U4pN0wBOeMDpQ47RgxRzwIkSNcUesyBrJ6Zua\n"
//                        + "AGAT/3B+XxFNSRuzFVJ7yVTav52Vr2ua2J7p8eRDjeIRRDq/r72DQnNSi6q7pynP\n"
//                        + "9WQcCk3RvKqsnyrQ/39/2n3qse0wJcGE2jTSW3iDVuycNsMm4hH2Z0kdkquM++v/\n"
//                        + "eu6FSqdQgPCnXEqULl8FmTxSQeDNtGPPAUO6nIPcj2A781q0tHuu2guQOHXvgR1m\n"
//                        + "0vdXcDazv/wor3ElhVsT/h5/WrQ8\n"
//                        + "-----END CERTIFICATE-----\n")
//
//                val SISTERCERT = ("-----BEGIN CERTIFICATE-----\n" +
//                        "MIIFbTCCBFWgAwIBAgISA7G8uELBmI3Gf2VXx+9bpVPeMA0GCSqGSIb3DQEBCwUA\n" +
//                        "MEoxCzAJBgNVBAYTAlVTMRYwFAYDVQQKEw1MZXQncyBFbmNyeXB0MSMwIQYDVQQD\n" +
//                        "ExpMZXQncyBFbmNyeXB0IEF1dGhvcml0eSBYMzAeFw0xOTA4MTkwMDA0MzhaFw0x\n" +
//                        "OTExMTcwMDA0MzhaMBoxGDAWBgNVBAMTD3Npc3Rlcm5ldC5jby5pZDCCASIwDQYJ\n" +
//                        "KoZIhvcNAQEBBQADggEPADCCAQoCggEBALD+6Uh1sMWD65FymjHQ/TsflTvy/adR\n" +
//                        "b7fLNjXPcW1f+c5qxm06Laa33ICWHKhxzoXqVQS4A8ym/MFeCOqLdZp5gnv0IBZy\n" +
//                        "947utVpq3XopKwtpUn3084B4TziqFfT8WoFnFjiWcACHIE1IgFpBsrxsNDyEZNn3\n" +
//                        "41UqeyQ35PeROW8mbcPK+xV5uNlf9B9IVXpUzfAd1xKxFfiIaaCM1bGUuL8QbFk9\n" +
//                        "TG/MuGFfphKdEvn32b3oUROKQX67CedNcbx63O7f0FEUXaT28eO+ODAZNnRVk4kD\n" +
//                        "ksmX9hNi6PSIYXoebEhzl+CsWorxudRAatWb2B7Ag+I4BTKSdkF9iQ0CAwEAAaOC\n" +
//                        "AnswggJ3MA4GA1UdDwEB/wQEAwIFoDAdBgNVHSUEFjAUBggrBgEFBQcDAQYIKwYB\n" +
//                        "BQUHAwIwDAYDVR0TAQH/BAIwADAdBgNVHQ4EFgQUocXFUQfIxfvgiUND+mAk3pnC\n" +
//                        "+8owHwYDVR0jBBgwFoAUqEpqYwR93brm0Tm3pkVl7/Oo7KEwbwYIKwYBBQUHAQEE\n" +
//                        "YzBhMC4GCCsGAQUFBzABhiJodHRwOi8vb2NzcC5pbnQteDMubGV0c2VuY3J5cHQu\n" +
//                        "b3JnMC8GCCsGAQUFBzAChiNodHRwOi8vY2VydC5pbnQteDMubGV0c2VuY3J5cHQu\n" +
//                        "b3JnLzAvBgNVHREEKDAmgg9zaXN0ZXJuZXQuY28uaWSCE3d3dy5zaXN0ZXJuZXQu\n" +
//                        "Y28uaWQwTAYDVR0gBEUwQzAIBgZngQwBAgEwNwYLKwYBBAGC3xMBAQEwKDAmBggr\n" +
//                        "BgEFBQcCARYaaHR0cDovL2Nwcy5sZXRzZW5jcnlwdC5vcmcwggEGBgorBgEEAdZ5\n" +
//                        "AgQCBIH3BIH0APIAdwDiaUuuJujpQAnohhu2O4PUPuf+dIj7pI8okwGd3fHb/gAA\n" +
//                        "AWynZ5FtAAAEAwBIMEYCIQCiNLuownj2BM6LVmCQWnt93a7NtobCphdnIJW0jgcT\n" +
//                        "mQIhANMPnptKOnMtSpmmwkIOnGP4Z2gzv3bQpZZHe9zCW9WOAHcAY/Lbzeg7zCzP\n" +
//                        "C3KEJ1drM6SNYXePvXWmOLHHaFRL2I0AAAFsp2eRYAAABAMASDBGAiEA52pKusfd\n" +
//                        "vCY9o5nGekoTkPBZBGnHrAgkbktx2ctpu58CIQD53yLVYH7UzlxPxVwilut/9Ksq\n" +
//                        "hSAwUB+r0hmqj0E1gTANBgkqhkiG9w0BAQsFAAOCAQEAa5LfBOl1dNRpkybkkgyw\n" +
//                        "cPQ9u/KAX91XnuRbRsRdLWRvCOTKpUWXoaDpQMY7rYQWTfUvKjRAo1gsmg3GbJCx\n" +
//                        "ZopfTSMJ8zx4lvBVmcoQyikpy1eKZZUqzqtA+p1eP26ipnKd3X1xfGz0Mu/7BKz/\n" +
//                        "YtykoCLH8EQMy4/qQgoJmx5JVEgMO2vqXWkhpitIkAQsBW4mRVsdgp8QM43mq6Lu\n" +
//                        "a5VQ6RBqVvIhSHBhHieYCph50kgY+EphwXDPdRqU07b+VS2oF/kpN+PjdXIKI7D+\n" +
//                        "7zl/FjGbD/Rk7WV7vb1irxNaeHV4Q42nbVlHt2+sMrVgkNoP3xnLYLEMnBdz3AHP\n" +
//                        "Ww==\n" +
//                        "-----END CERTIFICATE-----")
//
//
//
//                return Buffer()
//                        //                .writeUtf8(comodoRsaCertificationAuthority)
//                        //                .writeUtf8(entrustRootCertificateAuthority)
//                        .writeUtf8(SISTERCERT)
//                        .inputStream()
//            }
//
//            /**
//             * Returns a trust manager that trusts `certificates` and none other. HTTPS services whose
//             * certificates have not been signed by these certificates will fail with a `SSLHandshakeException`.
//             *
//             *
//             * This can be used to replace the host platform's built-in trusted certificates with a custom
//             * set. This is useful in development where certificate authority-trusted certificates aren't
//             * available. Or in production, to avoid reliance on third-party certificate authorities.
//             *
//             *
//             * See also [CertificatePinner], which can limit trusted certificates while still using
//             * the host platform's built-in trust store.
//             *
//             * <h3>Warning: Customizing Trusted Certificates is Dangerous!</h3>
//             *
//             *
//             * Relying on your own trusted certificates limits your server team's ability to update their
//             * TLS certificates. By installing a specific set of trusted certificates, you take on additional
//             * operational complexity and limit your ability to migrate between certificate authorities. Do
//             * not use custom trusted certificates in production without the blessing of your server's TLS
//             * administrator.
//             */
//            @Throws(GeneralSecurityException::class)
//            private fun trustManagerForCertificates(`in`: InputStream): X509TrustManager {
//                val certificateFactory = CertificateFactory.getInstance("X.509")
//                val certificates = certificateFactory.generateCertificates(`in`)
//                if (certificates.isEmpty()) {
//                    throw IllegalArgumentException("expected non-empty set of trusted certificates")
//                }
//
//                // Put the certificates a key store.
//                val password = "password".toCharArray() // Any password will work.
//                val keyStore = newEmptyKeyStore(password)
//                var index = 0
//                for (certificate in certificates) {
//                    val certificateAlias = Integer.toString(index++)
//                    keyStore.setCertificateEntry(certificateAlias, certificate)
//                }
//
//                // Use it to build an X509 trust manager.
//                val keyManagerFactory = KeyManagerFactory.getInstance(
//                        KeyManagerFactory.getDefaultAlgorithm())
//                keyManagerFactory.init(keyStore, password)
//                val trustManagerFactory = TrustManagerFactory.getInstance(
//                        TrustManagerFactory.getDefaultAlgorithm())
//                trustManagerFactory.init(keyStore)
//                val trustManagers = trustManagerFactory.trustManagers
//                if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
//                    throw IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers))
//                }
//                return trustManagers[0] as X509TrustManager
//            }
//
//            @Throws(GeneralSecurityException::class)
//            private fun newEmptyKeyStore(password: CharArray): KeyStore {
//                try {
//                    val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
//                    val `in`: InputStream? = null // By convention, 'null' creates an empty key store.
//                    keyStore.load(`in`, password)
//                    return keyStore
//                } catch (e: IOException) {
//                    throw AssertionError(e)
//                }
//
//            }

    }
}