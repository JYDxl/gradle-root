// package org.github.web.service
//
// import org.github.base.PageParam
// import org.github.mysql.web.base.entity.AclRoleEntity
// import org.github.spring.restful.json.JSONPageReturn
// import org.github.spring.restful.json.JSONReturn
// import org.github.web.model.bo.RoleSaveBo
// import org.github.web.model.vo.RoleIndexVo
// import javax.validation.Valid
//
// interface IRoleService {
//   fun save(@Valid bo: RoleSaveBo): JSONReturn
//
//   fun all(bo: PageParam): JSONPageReturn<RoleIndexVo>
//
//   fun getById(id: java.io.Serializable): AclRoleEntity
//   fun update(bo: AclRoleEntity)
//   fun delete(id: String)
// }
