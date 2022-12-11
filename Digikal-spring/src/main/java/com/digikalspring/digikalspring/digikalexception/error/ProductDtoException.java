package com.digikalspring.digikalspring.digikalexception.error;

import com.digikalspring.digikalspring.digikalexception.DigikalException;
import com.digikalspring.digikalspring.digikalexception.DigikalType;
import com.digikalspring.digikalspring.model.Product;

public class ProductDtoException extends DigikalException {
    public ProductDtoException(){
        super(DigikalType.PRODUCT_DTO_FAIL);
    }
}
