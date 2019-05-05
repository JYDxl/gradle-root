--
-- Created by IntelliJ IDEA.
-- User: JYD_XL
-- Date: 2019-05-05
-- Time: 22:47
-- To change this template use File | Settings | File Templates.
--

local key = KEYS[1]

redis.call('rpush', key, 0, 1, 2, 3)
return redis.call('lrange', key, 0, -1)
