/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.github.web.dubbo;

import org.github.web.model.User;

import java.util.Map;

/**
 * Rest Service.
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 */
public interface RestService {

  String form(String form);

  String headers(String header, String header2, Integer param);

  String param(String param);

  String params(int a, String b);

  String pathVariables(String path1, String path2, String param);

  User requestBodyMap(Map<String,Object> data, String param);

  Map<String,Object> requestBodyUser(User user);
}
