package org.github.common.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.annotation.Nonnull;
import org.github.base.entity.TipLoginLogEntity;
import org.github.mybatis.MyBatisMapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.metadata.IPage;

@MyBatisMapper
public interface ICommonMapper {
    @Select("select now()")
    @Nonnull
    LocalDateTime now();

    @Nonnull
    IPage<TipLoginLogEntity> page(IPage page);

    //TODO test
    default LocalDate localDate() {
        return now().toLocalDate();
    }

    //TODO test
    default LocalTime localTime() {
        return now().toLocalTime();
    }

    //TODO test
    default Instant instant() {
        return now().atZone(ZoneId.systemDefault()).toInstant();
    }

    //TODO test
    default long time() {
        return instant().getEpochSecond();
    }

    //TODO test
    default Date date() {
        return Date.from(instant());
    }
}
//TODO format
