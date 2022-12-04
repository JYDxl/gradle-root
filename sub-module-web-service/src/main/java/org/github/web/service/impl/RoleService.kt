// package org.github.web.service.impl
//
// import com.baomidou.mybatisplus.core.metadata.IPage
// import org.github.base.PageParam
// import org.github.mysql.web.base.entity.AclRoleEntity
// import org.github.mysql.web.base.service.IAclRoleService
// import org.github.service.ICommonService
// import org.github.spring.restful.json.JSONPageReturn
// import org.github.spring.restful.json.JSONReturn
// import org.github.web.model.bo.RoleSaveBo
// import org.github.web.model.vo.RoleIndexVo
// import org.github.web.service.IRoleService
// import org.springframework.stereotype.Service
// import org.springframework.validation.annotation.Validated
// import javax.annotation.Resource
//
// @Validated
// @Service
// class RoleService: IRoleService {
//   @Resource
//   private lateinit var aclRoleService: IAclRoleService
//
//   @Resource
//   private lateinit var commonService: ICommonService
//
//   override fun save(bo: RoleSaveBo): JSONReturn {
//     aclRoleService.save(bo)
//     return JSONReturn.ok()
//   }
//
//   override fun all(bo: PageParam): JSONPageReturn<RoleIndexVo> {
//     val temp: IPage<AclRoleEntity> = aclRoleService.page(bo.page())
//     val data = commonService.transCode(temp.records, RoleIndexVo::class.java)
//     return JSONPageReturn.of(temp.total, data)
//   }
//
//   override fun getById(id: java.io.Serializable): AclRoleEntity {
//     return aclRoleService.getById(id)
//   }
//
//   override fun update(bo: AclRoleEntity) {
//     aclRoleService.updateById(bo)
//   }
//
//   override fun delete(id: String) {
//     aclRoleService.removeById(id)
//   }
// }
