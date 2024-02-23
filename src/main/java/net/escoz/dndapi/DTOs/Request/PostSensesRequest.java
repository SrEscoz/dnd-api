package net.escoz.dndapi.DTOs.Request;

import lombok.Data;

import java.util.List;

@Data
public class PostSensesRequest {

    private List<String> senses;
}
