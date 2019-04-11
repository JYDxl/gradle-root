#!/usr/bin/ruby

def warn_msg
  system "echo 'app/start mysql57|mysql80|rabbitmq|redis4|redis5'"
end

app = ARGV[0]
warn_msg && exit unless app

case app
  when 'mysql57'
    Dir.chdir '/Users/l/app/mysql/mysql-5.7.25'
    system 'bin/mysqld_safe --defaults-file=my.cnf --user=l &'
  when 'mysql80'
    Dir.chdir '/Users/l/app/mysql/mysql-8.0.15'
    system 'bin/mysqld_safe --defaults-file=my.cnf --user=l &'
  when 'rabbitmq'
    Dir.chdir '/Users/l/app/rabbitmq/'
    system 'sbin/rabbitmq-server &'
  when 'redis4'
    Dir.chdir '/Users/l/app/redis/redis-4.0.14/'
    system 'src/redis-server redis.conf &'
  when 'redis5'
    Dir.chdir '/Users/l/app/redis/redis-5.0.4/'
    system 'src/redis-server redis.conf &'
  else
    warn_msg
end
