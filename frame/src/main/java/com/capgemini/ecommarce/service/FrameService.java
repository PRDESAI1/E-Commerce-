package com.capgemini.ecommarce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ecommarce.entity.Frame;
import com.capgemini.ecommarce.repository.FrameRepo;



@Service
public class FrameService {
	@Autowired // autowire enables you to inject the object dependency implicitly
	FrameRepo adminJpaRepoFrame;

	// getting all list of frames
	public List<Frame> getFrame() {
		return adminJpaRepoFrame.findAll();
	}

	// adding frame
	public Frame addFrame(Frame frame) {
		return adminJpaRepoFrame.save(frame);
	}

   //update frame
	public Frame updateFrame(Frame frame) {
		return adminJpaRepoFrame.saveAndFlush(frame);
	}

    //delete frame
	public List<Frame> deleteFrame(int frameId) {
		adminJpaRepoFrame.deleteById(frameId);
		return adminJpaRepoFrame.findAll();
	}

}
