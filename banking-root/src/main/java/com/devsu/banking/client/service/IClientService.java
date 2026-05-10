package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.ClientEntity;
import com.devsu.banking.vo.ClientVo;

import java.util.List;

public interface IClientService {

    /**
     * Method to find all clients
     * @return
     */
    List<ClientEntity> findAll();

    /**
     * Method to save client
     * @param clientVo
     */
    void saveClient(ClientVo clientVo);

}
