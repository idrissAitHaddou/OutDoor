package com.outdoor.order.commandProduct;

import com.outdoor.order.command.CommandProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandProductsRepository extends JpaRepository<CommandProducts, Long> {
}