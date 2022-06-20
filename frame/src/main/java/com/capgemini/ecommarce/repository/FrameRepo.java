package com.capgemini.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ecommarce.entity.Frame;
@Repository
public interface FrameRepo extends JpaRepository<Frame,Integer> {

}
