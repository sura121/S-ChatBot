package com.sura.service;

import com.sura.domain.MessageVO;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageVO message(String msg) {

        return new MessageVO();
    }
}
