package net.escoz.dndapi.DTOs.Request;

import lombok.Data;

import java.util.List;

@Data
public class SensesRequest {

    private List<String> senses;
}
