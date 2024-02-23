package net.escoz.dndapi.DTOs.Reponses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class BasicResponse {

    private Integer status;
    private String message;

    public BasicResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

    public BasicResponse(String message) {
        this.status = HttpStatus.OK.value();
        this.message = message;
    }
}
