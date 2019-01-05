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
package org.github.spring.footstone

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

object JSONWrapper : ObjectMapper(), IWrapper {
  init {
    this.dateFormat = DATE_FORMAT_SEC
    this.setTimeZone(TIME_ZONE_CHINA)
    this.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    this.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
    this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
    this.disable(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)
    this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    this.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)
    this.disable(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)
  }
}
