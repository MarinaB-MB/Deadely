package com.deadely.piegallery.network;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {
    private static APIinterface apIinterface;

    private static String CLIENT_ID = "ZUcbFe6Yr40tzEFIdw2NRtOVNeds990seuFP9bXfwY0";
    public static String base_url = "https://api.unsplash.com/";

    private static APIinterface getClient() {
        OkHttpClient client = new OkHttpClient();
        try {
            TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
            if (tlsSocketFactory.getTrustManager() != null) {
                client = new OkHttpClient.Builder()
                        .sslSocketFactory(tlsSocketFactory, tlsSocketFactory.getTrustManager())
                        .addInterceptor(new HeaderInterceptor(CLIENT_ID))
                        .build();
            }
        } catch (
                KeyManagementException e) {
            e.printStackTrace();
        } catch (
                NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (
                KeyStoreException e) {
            e.printStackTrace();
        }

        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apIinterface = retrofit.create(APIinterface.class);

        return apIinterface;
    }

    public static APIinterface apIinterface() {
        return getClient();
    }

}