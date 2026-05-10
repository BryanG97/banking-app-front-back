package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.ClientEntity;
import com.devsu.banking.client.entity.PersonEntity;
import com.devsu.banking.client.repository.IClientRepository;
import com.devsu.banking.client.service.IClientService;
import com.devsu.banking.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;

    @Override
    public void saveClient(ClientVo clientVo){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonId(clientVo.getPerson().getPersonId());

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setPerson(personEntity);
        clientEntity.setClientPassword(clientVo.getClientPassword());
        clientEntity.setClientStatus(true);
        this.iClientRepository.save(clientEntity);
        clientVo.setClientId(clientEntity.getClientId());
        clientVo.setClientStatus(clientEntity.getClientStatus());
    }

}
