package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.Seller;
import java.util.List;

public interface SellerService {

    Seller getById(Long id)throws Exception;

    Seller addSeller(Seller seller)throws Exception;

    Seller updateSeller(Long id, Seller seller)throws Exception;

    Seller deleteSeller(Long id)throws Exception;

    List<Seller> getAllSeller() throws Exception;

    Seller findBuyerByEmailAndAndPassword(String email, String password) throws Exception;

  }

