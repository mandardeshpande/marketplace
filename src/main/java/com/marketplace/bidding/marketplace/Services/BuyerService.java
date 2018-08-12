package com.marketplace.bidding.marketplace.Services;

import com.marketplace.bidding.marketplace.models.Buyer;
import com.marketplace.bidding.marketplace.models.User;
import java.util.List;

public interface BuyerService {

    Buyer getById(Long id)throws Exception;

    Buyer registerBuyer(Buyer buyer)throws Exception;

    Buyer updateBuyer(Long id, Buyer buyer)throws Exception;

    Buyer deleteBuyer(Long id)throws Exception;

    List<Buyer> getAllBuyer() throws Exception;

    Buyer findByBuyerUser_Id(Long buyerId) throws Exception;

  }

