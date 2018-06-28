package com.globant.dao;

import com.globant.model.Payment;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PaymentDAO implements DataAccessObject<Payment> {

    public Payment create( Payment object ) {
        return null;
    }

    public Payment read( int id ) {
        return null;
    }

    public Payment update( Payment object ) {
        return null;
    }

    public void delete( int id ) {

    }

    public List<Payment> readAll() {
        return null;
    }
}
