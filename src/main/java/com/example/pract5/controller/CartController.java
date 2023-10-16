package com.example.pract5.controller;

import com.example.pract5.entity.BasketEntity;
import com.example.pract5.entity.template.Type;
import com.example.pract5.exception.AlreadyExistException;
import com.example.pract5.exception.NotFoundException;
import com.example.pract5.form.CartForm;
import com.example.pract5.service.BasketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    BasketService basketService;

//    @GetMapping()
//    public ResponseEntity getAllGoodsInCart(){
//
//    }
//
//    @GetMapping("/{client_id}")
//    public ResponseEntity setOrder(String client_id){
//
//    }

    @PostMapping("/{client_id}")
    public ResponseEntity addGood(@PathVariable Long client_id,@RequestBody @Valid CartForm form){
        try {
            return ResponseEntity.ok(basketService.addGood(client_id,form));
        } catch (NotFoundException | AlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

//    @PatchMapping("/{client_id}")
//    public ResponseEntity updateAmountGoodInCart(@RequestParam(name = "id_good") Long id_good,
//                                                 @RequestParam(name = "amount") Integer amount){
//
//    }
//
    @DeleteMapping("/{client_id}")
    public ResponseEntity deleteGood(@PathVariable Long client_id,@RequestParam(name = "good_id") Long good_id, @RequestParam(name = "type") Type type){
        try {
            basketService.deleteGood(client_id, good_id, type);
            return ResponseEntity.ok("Товар успешно удален из корзины");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }


}
