package com.iesam.huellas.data.remote;

import com.iesam.huellas.app.api.ApiClient;
import com.iesam.huellas.domain.models.Dog;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class DogApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Dog> getDogs() {
        try {
            Response<List<Dog>> responseDogs = apiClient.apiService.getDogs().execute();
            if (responseDogs.isSuccessful()) {
                return responseDogs.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
