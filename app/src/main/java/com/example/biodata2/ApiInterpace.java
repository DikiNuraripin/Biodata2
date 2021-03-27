package com.example.biodata2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterpace {
    @GET("b89cb383")
    Call<List<Orang>>getDaftarOrang();
}
