package br.com.sales.config.kafka;

import br.com.sales.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public byte[] serialize(String s, SaleMessage saleMessage) {
       try {
           if(saleMessage == null) {
               return null;
           }
           return objectMapper.writeValueAsBytes(saleMessage);
       } catch (Exception e) {
           throw new SerializationException("Error when serializing object to byte[]");
       }
    }
}