//package org.github.web.dubbo.impl;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.dubbo.config.annotation.DubboService;
//import org.github.web.dubbo.IEchoService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@DubboService
//@Slf4j
//public class EchoServiceImpl implements IEchoService {
//  @Autowired
//  private ObjectMapper mapper;
//
//  @Override
//  public String echo(String message) throws Exception {
//    return mapper.writeValueAsString(message);
//  }
//}
