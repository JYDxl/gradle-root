/*
  Copyright (C) 2016-2017 JYD_XL 1252504314l@Gmail.com

  Permission is hereby granted, free of charge, to any person obtaining
  a copy of this software and associated documentation files (the
  "Software"), to deal in the Software without restriction, including
  without limitation the rights to use, copy, modify, merge, publish,
  distribute, sublicense, and/or sell copies of the Software, and to
  permit persons to whom the Software is furnished to do so, subject to
  the following conditions:

  The above copyright notice and this permission notice shall be
  included in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.github.spring.footstone;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;


/**
 * 数据包装接口.
 *
 * @author JYD_XL
 */
public interface IWrapper {
  /**
   * 读取数据.
   *
   * @param input InputStream
   * @param clazz Class<T>
   * @param <T>   泛型
   * @return T
   * @throws IOException IO异常
   */
  @Nonnull
  <T> T readValue(@NotNull InputStream input, @NotNull Class<T> clazz) throws IOException;

  /**
   * 读取数据.
   *
   * @param json  String
   * @param clazz Class<T>
   * @param <T>   泛型
   * @return T
   * @throws IOException IO异常
   */
  @Nonnull
  <T> T readValue(@NotNull String json, @NotNull Class<T> clazz) throws IOException;

  /**
   * 写入数据.
   *
   * @param output OutputStream
   * @param value  Object
   * @throws IOException IO异常
   */
  void writeValue(@NotNull OutputStream output, @NotNull Object value) throws IOException;

  /**
   * 将对象转为字节数据.
   *
   * @param value Object
   * @return byte[]
   */
  @Nonnull
  byte[] writeValueAsBytes(@NotNull Object value);

  /**
   * 将对象转为字符串.
   *
   * @param value Object
   * @return String
   */
  @Nonnull
  String writeValueAsString(@NotNull Object value);
}
