package com.chendoing.introactivity.data.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.JacksonConverterFactory;
import retrofit2.Retrofit;

@Module
public class ApiserviceModule {

    private static String URL = "http://10.10.10.240:7259";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        Retrofit.Builder builder= new Retrofit.Builder().baseUrl(URL).addConverterFactory(JacksonConverterFactory.create());
        return builder.client(client).build();
    }
    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
