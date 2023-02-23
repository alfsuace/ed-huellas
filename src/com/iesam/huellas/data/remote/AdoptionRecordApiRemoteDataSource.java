package com.iesam.huellas.data.remote;

import com.iesam.huellas.app.api.ApiClient;
import com.iesam.huellas.domain.models.AdoptionRecord;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class AdoptionRecordApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<AdoptionRecord> getAdoptionRecords() {
        try {
            Response<List<AdoptionRecord>> responseAdoptionRecords = apiClient.apiService.getAdoptionRecords().execute();
            if (responseAdoptionRecords.isSuccessful()) {
                return responseAdoptionRecords.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
