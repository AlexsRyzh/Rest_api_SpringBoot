package com.example.pract5.repository;

import com.example.pract5.entity.BasketEntity;
import com.example.pract5.entity.ClientEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.repository.template.CommonRepo;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BasketRepo extends CommonRepo<BasketEntity> {

    BasketEntity findByGoodIdAndGoodTypeAndClient_Id(Long goodId, Type goodType, Long id);

}
