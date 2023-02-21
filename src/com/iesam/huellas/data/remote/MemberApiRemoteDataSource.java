package com.iesam.huellas.data.remote;

import com.iesam.huellas.app.api.ApiClient;
import com.iesam.huellas.domain.models.Member;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class MemberApiRemoteDataSource {

    private ApiClient apiClient = new ApiClient();

    public List<Member> getMembers() {
        try {
            Response<List<Member>> responseMembers = apiClient.apiService.getMembers().execute();
            if (responseMembers.isSuccessful()) {
                return responseMembers.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
