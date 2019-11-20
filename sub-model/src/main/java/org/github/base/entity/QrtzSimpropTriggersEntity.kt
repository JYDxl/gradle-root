package org.github.base.entity

import java.math.BigDecimal
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.AbstractEntity

/**
 * <p>
 * 
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-19
 */
@TableName("qrtz_simprop_triggers")
class QrtzSimpropTriggersEntity: AbstractEntity() {

    var schedName: String? = null

    var triggerName: String? = null

    var triggerGroup: String? = null

    var strProp1: String? = null

    var strProp2: String? = null

    var strProp3: String? = null

    var intProp1: Int? = null

    var intProp2: Int? = null

    var longProp1: Long? = null

    var longProp2: Long? = null

    var decProp1: BigDecimal? = null

    var decProp2: BigDecimal? = null

    var boolProp1: String? = null

    var boolProp2: String? = null

}
