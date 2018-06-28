package com.globant.util;

import com.globant.dto.ClientDTO;
import com.globant.model.Client;

public final class DTOUtils {

    public static ClientDTO clientDTO(Client client) {
        return new ClientDTO(client.getId(),
                client.getName(),
                client.getSurname(),
                client.getDescription(),
                client.getPaymentList());
    }
}
