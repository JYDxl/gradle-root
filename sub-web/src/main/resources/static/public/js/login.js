const vm = new Vue({
  el: '#rrapp',
  data: {
    user: {},
    error: false,
    errorMsg: '',
    src: 'captcha.jpg'
  },
  beforeCreate: function () {
    if (self !== top) {
      top.location.href = self.location.href;
    }
  },
  methods: {
    refreshCode: function () {
      this.src = "captcha.jpg?t=" + $.now();
    },
    login: function (event) {
      console.log(event);
      $.ajax({
        type: "POST",
        url: "/login",
        data: JSON.stringify(vm.user),
        dataType: "json",
        contentType: "application/json",
        cache: false,
        success: function (result) {
          // noinspection JSUnresolvedVariable
          if (result.retCode === 0) {//登录成功
            parent.location.href = 'index.html';
          } else {
            vm.error = true;
            // noinspection JSUnresolvedVariable
            vm.errorMsg = result.retMsg;

            vm.refreshCode();
          }
        }
      });
    }
  }
});
