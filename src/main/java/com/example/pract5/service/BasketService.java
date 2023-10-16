package com.example.pract5.service;

import com.example.pract5.entity.*;
import com.example.pract5.entity.template.AbstractProductEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.exception.AlreadyExistException;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.form.CartForm;
import com.example.pract5.repository.*;
import com.example.pract5.view.BasketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    @Autowired
    protected ClientRepo clientRepo;

    @Autowired
    protected BasketRepo basketRepo;

    @Autowired
    protected BookRepo bookRepo;

    @Autowired
    protected TelephoneRepo telephoneRepo;

    @Autowired
    protected WashingMachineRepo washingMachineRepo;

    public BasketView addGood(Long client_id, CartForm form) throws NotFoundException, AlreadyExistException {
        ClientEntity client = clientRepo.findById(client_id).orElse(null);
        if (client == null) {
            throw new NotFoundException("Корзина пользователя не найдена");
        }

        BasketEntity haveProduct = basketRepo.findByGoodIdAndGoodTypeAndClient_Id(form.getId_good(), form.getGood_type(), client_id);
        if (haveProduct != null){
            throw new AlreadyExistException("Товар уже в корзине");
        }


        AbstractProductEntity product = null;
        if (form.getGood_type() == Type.Books){
            product = bookRepo.findById(form.getId_good()).orElse(null);
        }

        if (form.getGood_type() == Type.Electronics){
            product = telephoneRepo.findById(form.getId_good()).orElse(null);
        }

        if (form.getGood_type() == Type.Plumbing){
            product = washingMachineRepo.findById(form.getId_good()).orElse(null);
        }

        if (product == null) {
            throw new NotFoundException("Товар не найден");
        }

        BasketEntity basket = new BasketEntity();
        basket.setGoodType(form.getGood_type());
        basket.setGoodId(form.getId_good());
        basket.setClient(client);

        BasketView view = new BasketView();
        view.update(basketRepo.save(basket));
        return view;

    }

    public void deleteGood(Long client_id, Long good_id, Type type) throws NotFoundException {
        BasketEntity product = basketRepo.findByGoodIdAndGoodTypeAndClient_Id( good_id, type, client_id);
        if (product == null){
            throw new NotFoundException("Товар не найден");
        }

        basketRepo.deleteById(product.getId());

    }
}
