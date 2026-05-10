package com.devsu.banking.client.service;

import com.devsu.banking.vo.ClientVo;

public interface IClientService {

    /**
     * Method to save client
     * @param clientVo
     */
    void saveClient(ClientVo clientVo);

}
