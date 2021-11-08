package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Companystockexchangemap;


@Repository
public interface companystockexRepo extends JpaRepository<Companystockexchangemap, Long>{

}
