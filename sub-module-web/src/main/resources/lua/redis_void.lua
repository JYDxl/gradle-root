--
-- Created by IntelliJ IDEA.
-- User: JYD_XL
-- Date: 2019-04-28
-- Time: 00:10
-- To change this template use File | Settings | File Templates.
--

local key = KEYS[1] --hkey
local version = ARGV[1] --时间戳
--判断key是否存在
local flag = redis.call('exists', key)
--key存在
if flag == 1 then
  local old = redis.call('hget', key, 'version')
  if old then
    old = tonumber(old)
    local new = tonumber(version)
    if old >= new then return end
  end
end

--数据有效

--更新时间戳
redis.call('hset', key, 'version', version)
--刷新超时时间 2分钟
redis.call('expire', key, 120)
