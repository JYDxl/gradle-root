package org.github.system.shiro;

import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.RedisSerializer;

import static com.alibaba.fastjson.JSON.parse;
import static com.alibaba.fastjson.JSON.toJSONString;
import static com.alibaba.fastjson.parser.Feature.SupportAutoType;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName;

public class JSONRedisSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        return toJSONString(obj, WriteClassName).getBytes();
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return parse(new String(bytes), SupportAutoType);
    }
}
