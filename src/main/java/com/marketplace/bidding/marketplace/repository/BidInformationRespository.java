package com.marketplace.bidding.marketplace.repository;

import com.marketplace.bidding.marketplace.models.BidInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidInformationRespository extends CrudRepository<BidInformation,Long> {

}
