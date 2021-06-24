package org.github.postgresql.runoobdb.base.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.github.base.Entity
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 
 *
 * @author JYD_XL
 */
@TableName("public.company")
@ApiModel(value = "CompanyEntity对象", description = "")
open class CompanyEntity : Entity() {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    open var id: Int? = null

    open var name: String? = null

    open var age: Int? = null

    open var address: String? = null

    open var salary: String? = null

    override fun pkVal(): java.io.Serializable? {
        return id
    }

    override fun toString(): String {
        return "CompanyEntity{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", address=" + address +
        ", salary=" + salary +
        "}"
    }

}
