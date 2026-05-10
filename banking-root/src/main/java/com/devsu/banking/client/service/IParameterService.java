package com.devsu.banking.client.service;

import com.devsu.banking.client.entity.ParameterEntity;

public interface IParameterService {

    ParameterEntity getParameterByCode(String parameterCode);
}
