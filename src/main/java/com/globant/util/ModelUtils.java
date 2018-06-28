package com.globant.util;

import com.globant.dto.ClientDTO;
import com.globant.model.Client;

public final class ModelUtils {

    public static Client toClient(ClientDTO clientDTO) {
        return new Client(clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getName(),
                clientDTO.getDescription(),
                clientDTO.getPaymentList());
    }
}
