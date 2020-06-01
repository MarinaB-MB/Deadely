package com.deadely.piegallery.network;

import android.util.Log;

import com.deadely.piegallery.HeaderInterceptor;
import com.deadely.piegallery.TLSSocketFactory;
import com.deadely.piegallery.dataclasses.Photo;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {
    private static APIinterface apIinterface;
    public List<Photo> mPhotoResponse;

    private static String CLIENT_ID = "ZUcbFe6Yr40tzEFIdw2NRtOVNeds990seuFP9bXfwY0";
    public static String base_url = "https://api.unsplash.com/";
    public static String TAG = "YOUR_RESPONSE";
    private static String LATESET = "latest";

    public static APIinterface getClient() {
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

    public void getPhotosList() {
        APIinterface apIinterface = apIinterface();
        Call<List<Photo>> call = apIinterface.getPhotos(1, 10, LATESET);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()) {
                    mPhotoResponse = response.body();

                } else {
                    Log.e(TAG + "error", "error");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e(TAG + "error", String.valueOf(t));
            }
        });
        Log.e(TAG, String.valueOf(mPhotoResponse.size()));
    }

    public static APIinterface apIinterface() {
        return getClient();
    }

}