package com.puboot.common.shiro.redis;

import lombok.Getter;
import lombok.Setter;
import org.crazycake.shiro.WorkAloneRedisManager;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RedisManager extends WorkAloneRedisManager {

    private static final String DEFAULT_HOST = "127.0.0.1:6379";
    private String host = DEFAULT_HOST;

    // timeout for jedis try to connect to redis server, not expire time! In milliseconds
    private int timeout = Protocol.DEFAULT_TIMEOUT;

    private String password;

    private int database = Protocol.DEFAULT_DATABASE;

    private JedisPool jedisPool;

    private void init() {
        synchronized (this) {
            if (jedisPool == null) {
                String[] hostAndPort = host.split(":");
                jedisPool = new JedisPool(getJedisPoolConfig(), hostAndPort[0], Integer.parseInt(hostAndPort[1]), timeout, password, database);
            }
        }
    }

    @Override
    protected Jedis getJedis() {
        if (jedisPool == null) {
            init();
        }
        return jedisPool.getResource();
    }

    @Override
    public Long dbSize(byte[] pattern) {
        long dbSize = 0L;
        Jedis jedis = getJedis();
        try {
            ScanParams params = new ScanParams();
            params.count(DEFAULT_COUNT);
            params.match(pattern);
            byte[] cursor = ScanParams.SCAN_POINTER_START_BINARY;
            ScanResult<byte[]> scanResult;
            do {
                scanResult = jedis.scan(cursor, params);
                List<byte[]> results = scanResult.getResult();
                for (byte[] result : results) {
                    dbSize++;
                }
                cursor = scanResult.getCursorAsBytes();
            } while (scanResult.getCursor().compareTo(ScanParams.SCAN_POINTER_START) > 0);
        } finally {
            jedis.close();
        }
        return dbSize;
    }

    @Override
    public Set<byte[]> keys(byte[] pattern) {
        Set<byte[]> keys = new HashSet<byte[]>();
        Jedis jedis = getJedis();

        try {
            ScanParams params = new ScanParams();
            params.count(DEFAULT_COUNT);
            params.match(pattern);
            byte[] cursor = ScanParams.SCAN_POINTER_START_BINARY;
            ScanResult<byte[]> scanResult;
            do {
                scanResult = jedis.scan(cursor, params);
                keys.addAll(scanResult.getResult());
                cursor = scanResult.getCursorAsBytes();
            } while (scanResult.getCursor().compareTo(ScanParams.SCAN_POINTER_START) > 0);
        } finally {
            jedis.close();
        }
        return keys;
    }
}
