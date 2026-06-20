package food_ordering_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(true, "Success", data);
    }
}
