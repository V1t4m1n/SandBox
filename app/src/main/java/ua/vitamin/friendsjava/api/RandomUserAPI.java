package ua.vitamin.friendsjava.api;

import retrofit2.Call;
import retrofit2.http.GET;
import ua.vitamin.friendsjava.dto.UserDTO;

public interface RandomUserAPI {

    @GET("api?results=100")
    Call<UserDTO> getPeople();
}
