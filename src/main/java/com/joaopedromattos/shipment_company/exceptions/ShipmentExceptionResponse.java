package com.joaopedromattos.shipment_company.exceptions;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipmentExceptionResponse {
    private String mensagem;
    private LocalDateTime timeStamp;
    private int status;
}