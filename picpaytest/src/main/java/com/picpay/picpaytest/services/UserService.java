package com.picpay.picpaytest.services;

import com.picpay.picpaytest.domain.user.User;
import com.picpay.picpaytest.domain.user.UserType;
import com.picpay.picpaytest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo lojista não está autorizado a fazer transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Usuário insuficiente");
        }


    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("usuário não encontrado"));

    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
