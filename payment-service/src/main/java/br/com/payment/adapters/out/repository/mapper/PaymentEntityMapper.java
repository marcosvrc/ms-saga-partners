package br.com.payment.adapters.out.repository.mapper;

import br.com.payment.adapters.out.repository.entity.PaymentEntity;
import br.com.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
