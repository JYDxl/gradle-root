package org.github.web.dubbo;

/**
 * Echo Service.
 */
public interface IEchoService {
  String echo(String message) throws Exception;
}
