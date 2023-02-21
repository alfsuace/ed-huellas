package com.iesam.huellas.app.api;

import com.iesam.huellas.domain.models.AdoptionRecord;
import com.iesam.huellas.domain.models.Cat;
import com.iesam.huellas.domain.models.Dog;
import com.iesam.huellas.domain.models.Member;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    @GET("cats.json")
    public Call<List<Cat>> getCats();
    public Call<List<Dog>> getDogs();
    public Call<List<Member>> getMembers();
    public Call<List<AdoptionRecord>> getAdoptionRecord();
    }
