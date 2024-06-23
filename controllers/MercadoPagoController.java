package com.example.parcial_prog2_api.controllers;

import com.example.parcial_prog2_api.entities.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mp")
public class MercadoPagoController {

    @Value("${codigo.mercadoPago}")
    private String mpToken;

    @PostMapping()
    public String getList(@RequestBody Pedido pedido){
        if(pedido == null){return "Error recibiendo pedido";}

        String title = "Pedido nro "+pedido.getId();
        int quantity = 1;
        Double price = pedido.getTotal();

        try{
            MercadoPagoConfig.setAccessToken(mpToken);
            //Creamos preferencia
            //Venta
            List<PreferenceItemRequest> items = new ArrayList<>();

            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(title)
                    .quantity(quantity)
                    .unitPrice(new BigDecimal(price))
                    .currencyId("ARS") //MONEDA
                    .build();

            items.add(itemRequest);

            //Control de sucesos
            PreferenceBackUrlsRequest backUrlsRequest = PreferenceBackUrlsRequest.builder()
                    .success("direccion por pago exitoso")
                    .pending("direccion por pago pendiente")
                    .failure("direccion por pago fallido")
                    .build();

            //Concluyendo preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrlsRequest)
                    .build();

            //Creamos el cliente que se comunicará con MP
            PreferenceClient client = new PreferenceClient();
            //Creamos una variable para guardar la respuesta generada
            Preference preference = client.create(preferenceRequest);

            return preference.getId();            
        }catch (MPException | MPApiException mpE){
            return mpE.getMessage();
        }
    }

}
