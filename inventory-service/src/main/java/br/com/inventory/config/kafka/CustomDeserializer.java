package br.com.inventory.config.kafka;

import br.com.inventory.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<SaleMessage> {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try{
            if(data == null){
                return null;
            }
            String dataString = new String(data, "UTF-8");
            return objectMapper.readValue(dataString, SaleMessage.class);
        }catch (Exception e){
            throw new SerializationException("Error when deserializing byte[] to SaleMessage");
        }
    }
}
