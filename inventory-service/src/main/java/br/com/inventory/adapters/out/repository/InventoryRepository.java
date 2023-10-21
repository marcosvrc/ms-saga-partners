package br.com.inventory.adapters.out.repository;

import br.com.inventory.adapters.out.repository.entity.InventoryEntity;
import br.com.inventory.application.core.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {

    Optional<InventoryEntity> findByProductId(Integer productId);

}
