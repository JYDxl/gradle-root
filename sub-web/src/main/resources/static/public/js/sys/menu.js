$(function () {
  const option = {
    url: "/sys/menu/list",//这个接口需要处理bootstrap table传递的固定参数
    method: 'post',
    toolbar: '#toolbar',    //工具按钮用哪个容器
    striped: true,      //是否显示行间隔色
    cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination: true,     //是否显示分页（*）
    sortable: true,      //是否启用排序
    // sortName: "orderNum",
    // sortOrder: "asc",     //排序方式
    pageNumber: 1,      //初始化加载第一页，默认第一页
    pageSize: 10,      //每页的记录行数（*）
    pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
    queryParamsType: '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
    // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
    //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
    sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
    search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
    strictSearch: true,                //showColumns: true,     //是否显示所有的列
    showRefresh: true,     //是否显示刷新按钮
    minimumCountColumns: 2,    //最少允许的列数
    clickToSelect: true,    //是否启用点击选中行
    searchOnEnterKey: true,
    responseHandler: function (res) {
      //return bootstrap-table能处理的数据格式
      return {
        "total": res.total,
        "rows": res.data
      }
    },
    columns: [
      {
        field: 'menuId',
        title: '序号',
        width: 40,
        formatter: function (value, row, index) {
          // noinspection JSJQueryEfficiency
          const pageSize = $('#table').bootstrapTable('getOptions').pageSize;
          // noinspection JSJQueryEfficiency
          const pageNumber = $('#table').bootstrapTable('getOptions').pageNumber;
          return pageSize * (pageNumber - 1) + index + 1;
        }
      },
      {checkbox: true},
      {title: '菜单ID', field: 'menuId', sortable: true},
      {
        field: 'name', title: '菜单名称', formatter: function (value, row) {
          if (row.type === 0) {
            return value;
          }
          if (row.type === 1) {
            return '<span style="margin-left: 40px;">├─ ' + value + '</span>';
          }
          if (row.type === 2) {
            return '<span style="margin-left: 80px;">├─ ' + value + '</span>';
          }
        }
      },
      {title: '上级菜单', field: 'parentName'},
      {
        title: '菜单图标', field: 'icon', formatter: function (value) {
          return value == null ? '' : '<i class="' + value + ' fa-lg"></i>';
        }
      },
      {title: '菜单URL', field: 'url'},
      {title: '授权标识', field: 'perms'},
      {
        title: '类型', field: 'type', formatter: function (value) {
          if (value === 0) {
            return '<span class="label label-primary">目录</span>';
          }
          if (value === 1) {
            return '<span class="label label-success">菜单</span>';
          }
          if (value === 2) {
            return '<span class="label label-warning">按钮</span>';
          }
        }
      },
      {title: '排序号', field: 'orderNum'}
    ]
  };
  $('#table').bootstrapTable(option);
});
let ztree;

// noinspection JSUnusedLocalSymbols
const vm = new Vue({
  el: '#dtapp',
  data: {
    showList: true,
    title: null,
    menu: {}
  },
  methods: {
    del: function () {
      const rows = getSelectedRows();
      if (rows == null) {
        return;
      }
      const id = 'menuId';
      //提示确认框
      // noinspection JSUnusedLocalSymbols
      layer.confirm('您确定要删除所选数据吗？', {
        btn: ['确定', '取消'] //可以无限个按钮
      }, function (index, layero) {
        const ids = [];
        //遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
          ids[i] = row[id];
        });

        $.ajax({
          type: "POST",
          url: "/sys/menu/del",
          data: JSON.stringify(ids),
          success: function (r) {
            // noinspection JSUnresolvedVariable
            if (r.retCode === 0) {
              layer.alert('删除成功');
              $('#table').bootstrapTable('refresh');
            } else {
              // noinspection JSUnresolvedVariable
              layer.alert(r.retMsg);
            }
          },
          error: function () {
            layer.alert('服务器没有返回数据，可能服务器忙，请重试');
          }
        });
      });
    },
    add: function () {
      vm.showList = false;
      vm.title = "新增";
      vm.menu = {parentName: null, parentId: 0, type: 1, orderNum: 0};
      vm.getMenu();
    },
    update: function (event) {
      const id = 'menuId';
      const menuId = getSelectedRow()[id];
      if (menuId == null) {
        return;
      }

      $.get("/sys/menu/info/" + menuId, function (r) {
        vm.showList = false;
        vm.title = "修改";
        vm.menu = r.data;

        vm.getMenu();
      });
    },
    saveOrUpdate: function (event) {
      // noinspection JSUnresolvedVariable
      const url = vm.menu.menuId == null ? "/sys/menu/save" : "/sys/menu/update";
      // noinspection DuplicatedCode
      $.ajax({
        type: "POST",
        url: url,
        data: JSON.stringify(vm.menu),
        success: function (r) {
          // noinspection JSUnresolvedVariable
          if (r.retCode === 0) {
            layer.alert('操作成功', function (index) {
              layer.close(index);
              vm.reload();
            });
          } else {
            // noinspection JSUnresolvedVariable
            layer.alert(r.retMsg);
          }
        }
      });
    },
    reload: function (event) {
      vm.showList = true;
      $("#table").bootstrapTable('refresh');
    },
    menuTree: function () {
      layer.open({
        type: 1,
        offset: '50px',
        skin: 'layui-layer-molv',
        title: "选择菜单",
        area: ['300px', '450px'],
        shade: 0,
        shadeClose: false,
        content: jQuery("#menuLayer"),
        btn: ['确定', '取消'],
        btn1: function (index) {
          const node = ztree.getSelectedNodes();
          //选择上级菜单
          // noinspection JSUnresolvedVariable
          vm.menu.parentId = node[0].menuId;
          vm.menu.parentName = node[0].name;

          layer.close(index);
        }
      });
    },
    getMenu: function (menuId) {

      const setting = {
        data: {
          simpleData: {
            enable: true,
            idKey: "menuId",
            pIdKey: "parentId",
            rootPId: -1
          },
          key: {
            url: "nourl"
          }
        }
      };

      //加载菜单树
      $.post("/sys/menu/select", function (r) {
        //设置ztree的数据
        ztree = $.fn.zTree.init($("#menuTree"), setting, r.data);

        //编辑（update）时，打开tree，自动高亮选择的条目
        const node = ztree.getNodeByParam("menuId", vm.menu.parentId);
        //选中tree菜单中的对应节点
        ztree.selectNode(node);
        //编辑（update）时，根据当前的选中节点，为编辑表单的“上级菜单”回填值
        vm.menu.parentName = node.name;
      });
    }
  }
});
