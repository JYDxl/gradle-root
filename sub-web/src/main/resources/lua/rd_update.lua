--
-- Created by IntelliJ IDEA.
-- User: JYD_XL
-- Date: 2019-04-28
-- Time: 00:10
-- To change this template use File | Settings | File Templates.
--

local key = KEYS[1] --EVC_RD_充电桩编码_桩接口
local version = ARGV[1] --时间戳
local power = ARGV[2] --有功功率
local elec = ARGV[3] --充电电量
local soc = ARGV[4] --soc
local pile_temp = ARGV[5] --枪温度
local modular_temp = ARGV[6] --模块温度
local vin = ARGV[7] --VIN码
local card_code = ARGV[8] --启动卡号
local card_flag = ARGV[9] --有卡无卡标志
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
--更新有功功率
redis.call('hset', key, 'power', power)
--更新充电电量
redis.call('hset', key, 'elec', elec)
--更新soc
redis.call('hset', key, 'soc', soc)
--更新枪温度
redis.call('hset', key, 'pileTemp', pile_temp)
--更新模块温度
redis.call('hset', key, 'modularTemp', modular_temp)
--更新VIN码
redis.call('hset', key, 'vin', vin)
--更新充电电量
redis.call('hset', key, 'cardCode', card_code)
--更新启动卡号
redis.call('hset', key, 'cardFlag', card_flag)
--刷新超时时间 2分钟
redis.call('expire', key, 120)
