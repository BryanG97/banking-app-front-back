package com.devsu.banking.core.service;

import com.devsu.banking.client.entity.ParameterEntity;
import com.devsu.banking.client.repository.IParameterRepository;
import com.devsu.banking.client.service.IParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterService implements IParameterService {

    @Autowired
    private IParameterRepository iParameterRepository;

    @Override
    public ParameterEntity getParameterByCode(String parameterCode) {
        return this.iParameterRepository.getReferenceById(parameterCode);
    }

}
