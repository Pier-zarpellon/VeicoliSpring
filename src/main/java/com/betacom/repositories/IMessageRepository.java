package com.betacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.models.MessageID;
import com.betacom.models.Messaggi;


public interface IMessageRepository extends JpaRepository<Messaggi, MessageID> {

}
